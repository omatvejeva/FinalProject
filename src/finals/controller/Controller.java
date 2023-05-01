package finals.controller;

import finals.model.Cacti;
import finals.model.Succulents;
import finals.view.FinalFrame;
import javax.swing.JOptionPane;

import finals.controller.IOController;

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
	private Cacti myCactus; 
	private Succulents mySucculent; 
	/*
	 * constructs the controller  
	 */
	public Controller()
	{
		this.myCactus = new Cacti("a succulent plant with a thick, "
				+ "fleshy stem that typically bears spines, lacks "
				+ "leaves, and has brilliantly colored flowers. "
				+ "Cacti are native to arid regions of the New World "
				+ "and are cultivated elsewhere, especially as "
				+ "houseplants."); 
		this.mySucculent = new Succulents();
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
	public String getInfo(int number)
	{
		if(number ==0)
		{
			return myCactus.getDescription(); 
		}
		else
		{
			return mySucculent.getDescription(); 
		}
	}
	
	
	public void save(String path, String contents)
	{
		IOController.saveTextToFile(this, path, contents);
	}
	
	public String load(String path)
	{
		String results = IOController.loadTextFromFile(this, path); 
		
		return results; 
	}
	
}
