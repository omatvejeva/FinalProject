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
		
		this.buttonPanel = new JPanel (new GridLayout(0,2)); 
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
	}
           
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
