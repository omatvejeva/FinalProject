package finals.view;

import finals.controller.*;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener; 


public class PhotoPanel extends JPanel
{
	
	private Controller app; 
	DefaultListModel<String> model = new DefaultListModel<String>(); 
	JList<String> list = new JList<String>(model); 
	//JPanel photoPanel = new JPanel(); 
	JLabel labelForImages = new JLabel(); 
	HashMap<String, String> data = new HashMap<String, String>(); 
	
	
	
	public PhotoPanel(Controller app)
	{
		super(); 
		this.app = app;
		Color greenish = new Color(160,230,142); 
		this.setBackground(greenish);
		
		
		
		data.put("Monkey's Tail", "monkey.jpeg"); 
		data.put("Powder Puff","puff.jpg"); 
		data.put("Prickly Pear", "pear.jpeg"); 
		data.put("Bishop's Cap", "cap.jpeg"); 
		data.put("String of Pearl", "pearl.jpeg"); 
		data.put("Aeonium Lily Pad", "lily.jpeg"); 
		data.put("Star Window", "star.jpeg"); 
		data.put("Tom's Thumb", "tom.jpeg"); 
		
		for(Object x : data.keySet())
		{
			model.addElement(String.valueOf(x));
		}
		this.add(new JScrollPane(list)); 
	//	labelForImages.setText("I exist!!");
		this.add(labelForImages); 
		
		
		list.addListSelectionListener(new ListSelectionListener()
				{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				String selection = list.getSelectedValue();
				labelForImages.setText(selection);
				
				try
				{
					ImageIcon plant = new ImageIcon(getClass().getResource("/finals/view/images/"+data.get(selection))); 
					labelForImages.setIcon(plant); 
					
					
					repaint(); 
				}
				catch (NullPointerException error)
				{
					labelForImages.setText("as;ldjhf"); 
				}
				
				
				
			}
		}); 
		
	}

}
