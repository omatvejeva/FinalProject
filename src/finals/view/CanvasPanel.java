package finals.view;


import finals.controller.Controller;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter; 


public class CanvasPanel extends JPanel 
{
	/*
	 * Instant variables 
	 */
	private Controller app; 
	private SpringLayout layout; 
	private JPanel buttonPanel; 
	private JButton saveButton; 
	private JButton loadButton; 
	private Color currentColor; 
	private BufferedImage canvasImage; 
	
	private int previousX; 
	private int previousY; 
	
	/*
	 * Constructor for canvas panel 
	 */
	public CanvasPanel(Controller app)
	{
		super(); 
		this.app = app; 
		this.currentColor = Color.MAGENTA; 
		this.canvasImage = new BufferedImage(800,800, BufferedImage.TYPE_INT_ARGB); 
		
		setupPanel();
		resetPoint();
		
		
	}
	
	/*
	 * overridden method 
	 */
	@Override 
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(canvasImage, 0, 0, null);
	}
	
	/*
	 * method for points 
	 */
	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE; 
		previousY = Integer.MIN_VALUE; 
	}
	/*
	 * method that draws dots at last location 
	 */
	public void drawDot(int currentX, int currentY, int width)
	{
		Graphics2D currentGraphics = canvasImage.createGraphics(); 
		
		currentGraphics.setColor(currentColor);
		currentGraphics.setStroke(new BasicStroke(width)); 
		currentGraphics.drawOval(currentX, currentY, width, width);
		repaint(); 
	}
	
/*
 * draws lines / method 
 */
	public void drawLine(int currentX, int currentY, int width)
	{
		Graphics2D currentGraphics = canvasImage.createGraphics(); 
		
		currentGraphics.setColor(currentColor);
		currentGraphics.setStroke(new BasicStroke(width));
		if (previousX == Integer.MIN_VALUE)
		{
			currentGraphics.drawLine(currentX, currentY, currentX, currentY);
		}
		else
		{
			currentGraphics.drawLine(previousX, previousY, currentX, currentY);
		}
		
		previousX = currentX; 
		previousY = currentY; 
		repaint(); 
	}
	/*
	 * method that sets up the panel 
	 */
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(700, 1000));

		this.setBackground(Color.WHITE);

		this.currentColor = Color.BLACK; 
	}
	/*
	 *method that sets up the color, returns  a color  
	 */
	public void setColor(Color color)
	{
		this.currentColor = color;

	}
/*
 * method that erases the canvas 
 */
	public void eraseCanvas()

	{

		this.canvasImage = new BufferedImage(700, 1000, BufferedImage.TYPE_INT_ARGB);

		repaint();

	}
/*
 * method that saves an image to the computer 
 */
	public void saveImage()
	{
		try 
		{
			JFileChooser saveDialog = new JFileChooser(); 
			saveDialog.showSaveDialog(this); 
			String savePath = saveDialog.getSelectedFile().getPath(); 
			
			if(!savePath.endsWith(".png"))
			{
				savePath += ".png"; 
			}
			
			ImageIO.write(canvasImage, "PNG", new File(savePath)); 
			
		}
		catch (IOException | NullPointerException error)
		{
			app.handleError(error);
		}
	}
	/*
	 * method that loads an image off the computer 
	 */
	public void loadImage()
	{
		try
		{
			JFileChooser imageChooser = new JFileChooser(); 
			imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileFilter imageFilter = new FileNameExtensionFilter("Image Files Only!", ImageIO.getReaderFileSuffixes()); 
			imageChooser.setFileFilter(imageFilter);
			
			if(imageChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				File resultingFile = imageChooser.getSelectedFile(); 
				BufferedImage updatedCanvas = ImageIO.read(resultingFile); 
				canvasImage = updatedCanvas; 
				
				this.setPreferredSize(new Dimension(canvasImage.getWidth(), canvasImage.getHeight())); 
			}
			repaint(); 
		}
		catch (IOException error)
		{
			app.handleError(error);
		}
	}
	
}