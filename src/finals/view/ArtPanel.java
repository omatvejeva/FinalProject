package finals.view;

import finals.controller.Controller; 

import javax.swing.*; 


public class ArtPanel extends JPanel 
{
	private Controller app; 
	private SpringLayout layout; 
	private JPanel buttonPanel; 
	private JButton saveButton; 
	private JButton loadButton; 
	
	public ArtPanel(Controller app)
	{
		super(); 
		this.app = app; 
	}
	
}
