package finals.view;

import finals.controller.Controller;
import javax.swing.JFrame; 
import finals.view.*;

import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem; 

public class FinalFrame extends JFrame
{
	private Controller app; 
	private FinalPanel panel; 
	private ArtPanel artPanel; 
	private JMenuBar menuBar; 
	private JMenu menu; 
	
	public FinalFrame(Controller app)
	{
		super(); 
		
		this.app = app; 
		this.panel = new FinalPanel (this.app); 
		this.menuBar = new JMenuBar(); 
		this.artPanel = new ArtPanel(this.app); 
		
		 setupMenu(); 
		 setupFrame(); 
	}
	private void setupMenu()
	{ 
		this.menuBar = new JMenuBar(); 
		this.menu = new JMenu("Menu"); 
		JMenuItem quitItem = new JMenuItem("Quit Application");  
		
		JMenuItem info = new JMenuItem("Information"); 
		JMenuItem draw = new JMenuItem("Drawing"); 
		
		quitItem.addActionListener(select ->System.exit(0)); 
	//	draw.addActionListener(select -> artPanel.drawOnCanvas());
//		info.addActionListener(select -> );
		
		menu.add(info); 
		menu.add(draw); 
		menu.add(quitItem); 
		
		menuBar.add(menu); 
		
		
	}
	
	
	private void setupFrame()
	{
		this.setJMenuBar(menuBar);
		this.setContentPane(panel);
		this.setTitle("Final Project (change later)");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setResizable(false); 
	
		this.setVisible(true);
		
	}
}
