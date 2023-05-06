package finals.tests;

/**
 * Project imports
 */
import finals.view.*;
import finals.controller.Controller;
/**
 * Reflection imports
 */
import java.lang.reflect.*;
import java.awt.*;
import javax.swing.*;
/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PanelTest
{
	private FinalPanel testedPanel;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedPanel = new FinalPanel(new Controller());
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedPanel = null;
	}

	@Test
	void testStructure()
	{
		Field [] dataMembers = testedPanel.getClass().getDeclaredFields();
		
		for (Field field : dataMembers)
		{
			int status = field.getModifiers();
			assertTrue(Modifier.isPrivate(status), "All data members need to be private!");
		}
		
		Component [] contents = testedPanel.getComponents();
		int fieldCount = 0;
		int panelCount = 0;
		int paneCount = 0;
		int buttonCount = 0;
		
		for (Component current : contents)
		{
			
			if (current instanceof JPanel)
			{
				JPanel subPanel = (JPanel) current;
				panelCount++;
				assertTrue(subPanel.getLayout() instanceof GridLayout);
				for (Component panelItem : subPanel.getComponents())
				{
					if (panelItem instanceof JTextField)
					{
						fieldCount++;
					}
					else if (panelItem instanceof JButton)
					{
						buttonCount++;
						JButton testedButton = (JButton) panelItem;
						assertTrue(testedButton.getActionListeners().length == 1, "Each button needs a listener!");
					}
					if (panelItem instanceof JPanel)
					{
						JPanel nestedPanel = (JPanel) panelItem;
						for (Component subPanelItem : nestedPanel.getComponents())
						{
							if (subPanelItem instanceof JButton)
							{
								buttonCount++;
								JButton testedButton = (JButton) subPanelItem;
								assertTrue(testedButton.getActionListeners().length == 1, "Each button needs a listener!");
							}
						}
					}	
				}
			}
			if (current instanceof JScrollPane)
			{
				paneCount++;
				JScrollPane tested = (JScrollPane) current;
				
			}
		}
		
	
		assertTrue(panelCount == 1, "You need a JPanel with a grid layout");
	
		
	}
	
	
	@Test
	void testRequiredMethods()
	{
		Method [] methods = testedPanel.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 4, "You need at least 7 methods in the panel");
		boolean hasUpdateDisplay = false;
		boolean hasSetupPanel = false;
		boolean hasSetupListeners = false;
		boolean hasSetupLayout = false;
		
		
		for (Method method : methods)
		{
			if (method.getName().equals("updateDisplay"))
			{
				hasUpdateDisplay = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The updateDisplay method must be private");
				assertTrue(method.getParameterCount() == 2, "The updateDisplay method needs two parameters!");
				assertTrue(method.getGenericParameterTypes()[0].getTypeName().equals("java.lang.String"), "The first parameter should be a String");
				assertTrue(method.getGenericParameterTypes()[1].getTypeName().equals("int"), "The first parameter should be an int");
			}
			else if (method.getName().equals("setupPanel"))
			{
				hasSetupPanel = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupPanel method must be private");
			}
			else if (method.getName().equals("setupListeners"))
			{
				hasSetupListeners = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupListeners method must be private");
			}
			else if (method.getName().equals("setupLayout"))
			{
				hasSetupLayout = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupLayout method must be private");
			}
		
		}
		assertTrue(hasUpdateDisplay, "You need a method named updateDisplay");
		assertTrue(hasSetupPanel, "You need a method named setupPanel");
		assertTrue(hasSetupListeners, "You need a method named setupListeners");
		assertTrue(hasSetupLayout, "You need a method named setupLayout");
		
	}

}
