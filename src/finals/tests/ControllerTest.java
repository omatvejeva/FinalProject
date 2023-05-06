package finals.tests;

/**
 * Project imports
 */
import finals.controller.Controller;
/**
 * Reflection imports
 */
import java.lang.reflect.*;

/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest
{
	private Controller testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
	}

	@Test
	void testStructure()
	{
		Field [] fields = testedController.getClass().getDeclaredFields();
		assertTrue(fields.length > 2, "You need at least 3 data members in your Controller");
		Method [] methods = testedController.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 2, "You need at least two methods in the controller");
		boolean hasStart = false;
	
		boolean hasHandle = false;
		boolean hasSave = false;
		boolean hasLoad = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("handleError"))
			{
				hasHandle = true;
				Type[] types = method.getGenericParameterTypes();
				assertTrue(types[0].getTypeName().equals("java.lang.Exception"), "The parameter type needs to be: Exception");
				assertTrue(method.getReturnType().equals(Void.TYPE), "The method needs to be a void method!");
			}
			if (method.getName().equals("start"))
			{
				hasStart = true;
				assertTrue(method.getReturnType().equals(Void.TYPE), "The method needs to be a void method!");
			}
			
			else if (method.getName().equals("load"))
			{
				hasLoad = true;
				Type[] types = method.getGenericParameterTypes();
				assertTrue(method.getReturnType().equals(String.class), "The load method needs to return a String");
				assertTrue(types[0].getTypeName().equals("java.lang.String"), "The first parameter type needs to be: String");
			}
			else if (method.getName().equals("save"))
			{
				hasSave = true;
				Type[] types = method.getGenericParameterTypes();
				assertTrue(method.getReturnType().equals(Void.TYPE), "The method needs to be a void method!");
				assertTrue(types[0].getTypeName().equals("java.lang.String"), "The first parameter type needs to be: String");
				assertTrue(types[1].getTypeName().equals("java.lang.String"), "The second parameter type needs to be: String");
			}
		}
		assertTrue(hasHandle, "You need a method named handleError");
		assertTrue(hasStart, "You need a method named start");
		assertTrue(hasSave, "You need a method named save");
		assertTrue(hasLoad, "You need a method named load");
	}

}
