package finals.view;


import finals.controller.Controller;


import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*; 


public class CanvasPanel extends JPanel 
{
	private Controller app; 
	private SpringLayout layout; 
	private JPanel buttonPanel; 
	private JButton saveButton; 
	private JButton loadButton; 
	private Color currentColor; 
	private BufferedImage canvasImage; 
	
	private int previousX; 
	private int previousY; 
	
	public CanvasPanel(Controller app)
	{
		super(); 
		this.app = app; 
		this.currentColor = Color.MAGENTA; 
		this.canvasImage = new BufferedImage(800,800, BufferedImage.TYPE_INT_ARGB); 
		
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		this.setMaximumSize(new Dimension(800, 800));
		
		
	}
	
	@Override 
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(canvasImage, 0, 0, null);
	}
	
	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE; 
		previousY = Integer.MIN_VALUE; 
	}
}