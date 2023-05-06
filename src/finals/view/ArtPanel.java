package finals.view;

import finals.controller.Controller;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.*; 

// art panel class 
public class ArtPanel extends JPanel 
{
	/*
	 * instance variables 
	 */
	private Controller app; 
	private SpringLayout layout; 
	private JPanel buttonPanel; 
	private JButton saveButton; 
	private JButton loadButton; 
	private Color currentColor; 
	private BufferedImage canvasImage; 
	private CanvasPanel canvas; 
	private JLabel demoLabel;
	
	private JPanel menuPanel;
	private JPanel colorPanel;
	private JButton blackButton;
	private JButton blueButton;
	private JButton brownButton;
	private JButton redButton;
	private JButton greenButton;
	private JButton purpleButton;
	private JButton yellowButton;
	private JButton choiceButton;

	private JButton eraseButton;
	
	private int previousX; 
	private int previousY; 
	
	/*
	 * initalizes variables /  panel 
	 */
	public ArtPanel(Controller app)
	{
		super(); 
		this.app = app; 
		this.canvas = new CanvasPanel(app); 
		
		
		this.layout = new SpringLayout();
		this.demoLabel = new JLabel("Placeholder Text");
		this.saveButton = new JButton("Save Image?");
		this.loadButton = new JButton("Load Image?");
		this.menuPanel = new JPanel(new GridLayout(0,1));
		this.colorPanel = new JPanel(new GridLayout(0,2));
		this.blackButton = new JButton("Black");
		this.blueButton = new JButton("Blue");
		this.brownButton = new JButton("Cyan");
		this.redButton = new JButton("Red");
		this.greenButton = new JButton("Green");
		this.purpleButton = new JButton("Pink");
		this.yellowButton = new JButton("Yellow");
		this.choiceButton = new JButton("Choose Your Color");
		this.eraseButton = new JButton("Erase Canvas");
		
		
		
		
		this.currentColor = Color.MAGENTA; 
		this.canvasImage = new BufferedImage(800,800, BufferedImage.TYPE_INT_ARGB); 
		
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		this.setMaximumSize(new Dimension(800, 800));
	
		setupPanel(); 
		setupLayout(); 
		setupListeners(); 
	}
	
	/*
	 * overriden method 
	 */
	@Override 
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(canvasImage, 0, 0, null);
	}
	
	/*
	 * tracks location 
	 */
	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE; 
		previousY = Integer.MIN_VALUE; 
	}
	/*
	 * method sets up how the panel looks 
	 */
	private void setupPanel()
	{
		Color greenish = new Color(160,230,142); 
		this.setLayout(layout); 
		this.setBackground(greenish); 
		menuPanel.add(demoLabel); 
		menuPanel.add(saveButton); 
		menuPanel.add(loadButton); 
		this.add(menuPanel); 
		this.add(canvas); 
		
		this.add(demoLabel);
		menuPanel.add(eraseButton);
		this.add(colorPanel);
		colorPanel.add(blackButton);
		colorPanel.add(blueButton);
		colorPanel.add(brownButton);
		colorPanel.add(redButton);
		colorPanel.add(greenButton);
		colorPanel.add(purpleButton);
		colorPanel.add(yellowButton);
		colorPanel.add(choiceButton);
		this.setPreferredSize(new Dimension(1200,900));
	}
	
	/*
	 * method that works with colour 
	 */
	public void updateColor()
	{
		Color userColor = JColorChooser.showDialog(this, "Pick your color!", Color.WHITE);
		canvas.setColor(userColor);
		choiceButton.setBackground(userColor);
	}
	
	private void setupListeners() 
	{
		loadButton.addActionListener(click -> canvas.loadImage());
		saveButton.addActionListener(click -> canvas.saveImage());
		
		canvas.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent drag)
			{
				int x = drag.getX(); 
				int y = drag.getY(); 
				canvas.drawLine(x, y, 15);
			}
			public void mouseMoved(MouseEvent move)
			{
				int x = move.getX(); 
				int y = move.getY(); 
			
				String message = "The mouse is at X; " + x + " Y: " + y; 
				demoLabel.setText(message); 
			}
			
		}); 
		
		canvas.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent click)
			{
				int x = click.getX(); 
				int y = click.getY(); 
				
				canvas.drawDot(x, y, 25); 
			}
			public void mousePressed(MouseEvent press)
			{
				
			}
			public void mouseReleased(MouseEvent release)
			{
				canvas.resetPoint(); 
			}
			public void mouseEntered(MouseEvent enter)
			{
				
			}
			public void mouseExited(MouseEvent exit)
			{
				canvas.resetPoint(); 
			}
				
		});
		
		saveButton.addActionListener(click -> canvas.saveImage());
		loadButton.addActionListener(click -> canvas.loadImage());
		eraseButton.addActionListener(click -> canvas.eraseCanvas());
		blackButton.addActionListener(click -> canvas.setColor(Color.BLACK));
		blueButton.addActionListener(click -> canvas.setColor(Color.BLUE));
		brownButton.addActionListener(click -> canvas.setColor(Color.CYAN));
		redButton.addActionListener(click -> canvas.setColor(Color.RED));
		greenButton.addActionListener(click -> canvas.setColor(Color.GREEN));
		purpleButton.addActionListener(click -> canvas.setColor(Color.PINK));
		yellowButton.addActionListener(click -> canvas.setColor(Color.YELLOW));
		choiceButton.addActionListener(click -> updateColor());
			
	}
		
	public void drawOnCanvas(int xPosition, int yPosition, int width)
	{
		Graphics2D drawingGraphics = (Graphics2D)canvasImage.getGraphics(); 
		drawingGraphics.setPaint(currentColor);
		drawingGraphics.setStroke(new BasicStroke(width)); 
		if(previousX == Integer.MIN_VALUE || previousY == Integer.MIN_VALUE)
		{
			drawingGraphics.drawLine(xPosition, yPosition, xPosition + 30, yPosition +30);
		}
		else
		{
			drawingGraphics.drawLine(previousX, previousY, xPosition, yPosition);
		}
		this.previousX = xPosition; 
		this.previousY = yPosition; 
		
		drawingGraphics.dispose();
		repaint(); 
		
	}

	private void setupLayout()
	{ 
		layout.putConstraint(SpringLayout.NORTH, canvas, 34, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, canvas, -50, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, canvas, -34, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, canvas, -650, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, menuPanel, 86, SpringLayout.SOUTH, colorPanel);
		layout.putConstraint(SpringLayout.NORTH, colorPanel, 17, SpringLayout.NORTH, this);
	
	}
}
