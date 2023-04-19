package finals.view;

import finals.controller.Controller;
import javax.swing.JFrame; 
import java.awt.Color; 

public class FinalFrame extends JFrame
{
	private Controller app; 
	private FinalPanel panel; 
	
	public FinalFrame(Controller app)
	{
		super(); 
		
		this.app = app; 
		this.panel = new FinalPanel (this.app); 
		
		 setupFrame(); 
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Final Project (change later)");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setResizable(false); 
	
		this.setVisible(true);
		
	}
}
