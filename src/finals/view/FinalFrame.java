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
	public static final String ART_SCREEN = "art"; 
	public static final String INFO_SCREEN = "info"; 
	public static final String PHOTO_SCREEN = "photo"; 
	
	
	private Controller app; 
	private FinalPanel panel; 
	private JPanel panelCards; 
	private ArtPanel artPanel; 
	private PhotoPanel photoPanel; 

	private JMenuBar menuBar; 
	private JMenu menu; 
	
	public FinalFrame(Controller app)
	{
		super(); 
		
		this.app = app; 
		this.panel = new FinalPanel (this.app); 
		this.menuBar = new JMenuBar(); 
		this.artPanel = new ArtPanel(this.app); 
		this.photoPanel = new PhotoPanel(this.app); 
		
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
		JMenuItem photo = new JMenuItem("Photos"); 
		 
		
		quitItem.addActionListener(select ->System.exit(0)); 
		draw.addActionListener(select -> replaceScreen( ART_SCREEN));
		info.addActionListener(select -> replaceScreen(INFO_SCREEN));
		photo.addActionListener(select -> replaceScreen(PHOTO_SCREEN));
	 
		
		menu.add(info); 
		menu.add(draw); 
		menu.add(photo); 
	 
		menu.add(quitItem); 
		
		menuBar.add(menu); 
		
		
	}
	public void replaceScreen(String screen)
	{
		
		((CardLayout) panelCards.getLayout()).show(panelCards, screen);
	}
	
	
	private void setupFrame()
	{
		panelCards.add(panel, INFO_SCREEN); 
		panelCards.add(artPanel, ART_SCREEN); 
		panelCards.add(photoPanel, PHOTO_SCREEN); 
		
		this.add(panelCards); 
		this.setJMenuBar(menuBar);
		
		this.setTitle("Final Project (change later)");
		this.setSize(1024,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setResizable(false); 
	
		this.setVisible(true);
		
	}
}
