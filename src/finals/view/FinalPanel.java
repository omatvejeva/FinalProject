package finals.view;

import finals.controller.Controller; 

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton; 
import javax.swing.SpringLayout; 
import javax.swing.JTextArea; 
import javax.swing.JLabel; 

import java.awt.GridLayout; 
import java.awt.Color; 


public class FinalPanel extends JPanel
{
	private Controller app; 
	
	private SpringLayout layout; 
	
	private JPanel buttonPanel;
	private JScrollPane dataPane; 
	private JTextArea displayArea; 
	private JButton cactiButton; 
	private JPanel cactiPanel; 
	private JButton succulentsButton; 
	private JPanel succulentsPanel; 
	
	private JLabel titleLabel; 
	
	
	public FinalPanel(Controller app)
	{
		super(); 
		this.app = app; 
		
		this.layout = new SpringLayout(); 
		
		this.titleLabel = new JLabel("Learn about cacti and succulents"); 
		
		this.buttonPanel = new JPanel (new GridLayout(0,1)); 
		this.displayArea = new JTextArea(); 
		this.dataPane = new JScrollPane(); 
		this.cactiButton = new JButton("Cacti"); 
		this.cactiPanel = new JPanel(new GridLayout(0,2)); 
		this.succulentsButton = new JButton("Succulents"); 
		this.succulentsPanel = new JPanel(new GridLayout(0,2)); 
	
		
		setupPanel(); 
		setupLayout(); 
		setupListeners(); 
	}
	
	private void setupPanel()
	{
		Color greenish = new Color(160,230,142); 
		this.setBackground(greenish);
		this.setLayout(layout);
		
		buttonPanel.add(cactiButton); 
		buttonPanel.add(cactiPanel); 
		buttonPanel.add(succulentsButton); 
		buttonPanel.add(succulentsPanel); 
		
		dataPane.setViewportView(displayArea); 
		
		this.add(titleLabel); 
		this.add(buttonPanel); 
		this.add(dataPane); 
	}
           
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 25, SpringLayout.WEST, this); 
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 40, SpringLayout.NORTH, this); 
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -800, SpringLayout.EAST, this); 
		
		layout.putConstraint(SpringLayout.NORTH, dataPane, 40, SpringLayout.NORTH, this); 
		layout.putConstraint(SpringLayout.SOUTH, dataPane, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, dataPane, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, dataPane, 300, SpringLayout.WEST, this); 
	}
	
	private void setupListeners()
	{
		cactiButton.addActionListener(click -> updateScreen(0));
		succulentsButton.addActionListener(click -> updateScreen(1));
		
	}
	private void updateScreen(int number)
	{
		displayArea.setText(app.getInfo(number));
	}
}
