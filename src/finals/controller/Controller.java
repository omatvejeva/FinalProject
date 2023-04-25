package finals.controller;

import finals.view.FinalFrame;
import javax.swing.JOptionPane; 

/*Controller for the final project 
 * Author Olivia Matvejeva 
 */

public class Controller 
{
	/*
	 * Variable for the finalFrame class 
	 */
	private FinalFrame frame; 

	/*
	 * constructs the controller  
	 */
	public Controller()
	{
		this.frame = new FinalFrame(this); 
	}
	/*
	 * start method 
	 */
	public void start()
	{
		
	}
	/*
	 * handles errors and is a contructor 
	 */
	public void handleError(Exception error)
	{
		JOptionPane.showMessageDialog(frame, error.getMessage(), "Ooooops!", JOptionPane.ERROR_MESSAGE);
	}
	
}
