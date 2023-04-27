package finals.view;

import finals.controller.Controller;

import java.awt.CardLayout;

import javax.swing.JFrame; 
import javax.swing.JPanel; 
import finals.view.*;

import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem; 

public class FinalFrame extends JFrame
{
	private Controller app; 
	private FinalPanel panel; 
	private JPanel panelCards; 
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
		this.panelCards = new JPanel(new CardLayout()); 
		
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
		draw.addActionListener(select -> replaceScreen( "Art"));
//		info.addActionListener(select -> );
		
		menu.add(info); 
		menu.add(draw); 
		menu.add(quitItem); 
		
		menuBar.add(menu); 
		
		
	}
	public void replaceScreen(String screen)
	{
		
	//	((CardLayout) panelCards.getLayout()).show(panelCards, screen);
	}
	
	
	private void setupFrame()
	{
	//	panelCards.add(panel, "Panel"); 
	//	panelCards.add(artPanel, "Art"); 
	//	this.add(panelCards); 
		this.setJMenuBar(menuBar);
		this.setContentPane(panel);
		this.setTitle("Final Project (change later)");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setResizable(false); 
	
		this.setVisible(true);
		
	}
}
