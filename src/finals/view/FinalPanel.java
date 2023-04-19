package finals.view;

import finals.controller.Controller; 

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton; 
import javax.swing.SpringLayout; 
import javax.swing.JTextArea; 


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
	private JButton succulentsButton; 
	
	
	
	
	public FinalPanel(Controller app)
	{
		super(); 
		this.app = app; 
		
		this.layout = new SpringLayout(); 
		
		this.buttonPanel = new JPanel (new GridLayout(0,1)); 
		this.displayArea = new JTextArea(); 
		this.dataPane = new JScrollPane(); 
		this.cactiButton = new JButton("Cacti"); 
		this.succulentsButton = new JButton("Succulents"); 
		
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
		buttonPanel.add(succulentsButton); 
		
		dataPane.setViewportView(displayArea); 
		
		this.add(buttonPanel); 
		this.add(dataPane); 
	}
           
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 25, SpringLayout.WEST, this); 
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 25, SpringLayout.NORTH, this); 
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -800, SpringLayout.EAST, this); 
		
		layout.putConstraint(SpringLayout.NORTH, dataPane, 25, SpringLayout.NORTH, this); 
		layout.putConstraint(SpringLayout.SOUTH, dataPane, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, dataPane, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, dataPane, 300, SpringLayout.WEST, this); 
	}
	
	private void setupListeners()
	{
		
	}
}
