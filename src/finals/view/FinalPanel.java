package finals.view;

import finals.controller.Controller; 

import javax.swing.JPanel; 
import javax.swing.JButton; 
import javax.swing.SpringLayout; 

import java.awt.Color; 


public class FinalPanel extends JPanel
{
	private Controller app; 
	
	private SpringLayout layout; 
	
	
	
	public FinalPanel(Controller app)
	{
		super(); 
		this.app = app; 
		
		this.layout = new SpringLayout(); 
		
		setupPanel(); 
		setupLayout(); 
		setupListeners(); 
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GREEN);
	}

	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
