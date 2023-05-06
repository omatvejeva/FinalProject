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

import javax.swing.JFrame;

/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FrameTest
{
	private FinalFrame testedFrame;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedFrame = new FinalFrame(new Controller()); 
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedFrame = null;
	}

	@Test
	void testPokeFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "ChatFrame needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");

	}
}
