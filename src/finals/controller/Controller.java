package finals.controller;

import finals.view.FinalFrame;
import javax.swing.JOptionPane; 

public class Controller 
{
	private FinalFrame frame; 

	public Controller()
	{
		this.frame = new FinalFrame(this); 
	}
	
	public void start()
	{
		
	}
	public void handleError(Exception error)
	{
		JOptionPane.showMessageDialog(frame, error.getMessage(), "Ooooops!", JOptionPane.ERROR_MESSAGE);
	}
	
}
