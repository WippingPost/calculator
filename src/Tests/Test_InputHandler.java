package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import calculatorProject.InputHandler;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@Category(UnitTests.class)
public class Test_InputHandler {

	InputHandler inputHandler;

	@Before
	public void setUp() {
		inputHandler = new InputHandler();
	}


	/*
	 * Testar InputHandler mot diverse LEGALA uttryck.
	 */
	@Parameters({
		"12*35/-35+4*3, true",
		"1---3+23/0.5*7, true",
		"1*2*3*-4*5, true",
		"0.5*3, true",
		"0*0, true",
		"100/0, true",
		"0/100, true",
		"1.7976931348623157E308, true"
	})
	@Test
	public void testFor_Legal_Inputs(String expression, boolean expected) {
		// Arrange

		// Act
		boolean actual = inputHandler.handleInput(expression);

		// Assert
		assertEquals(expected, actual);
	}


	/*
	 * Testar InputHandler mot diverse ILLEGALA uttryck
	 */
	@Parameters({
		"12*3+42x, false",
		"/12*3+2, false",
		"*3*3, false",
		"1*2a*3, false",
		"!12/4, false",
		"100*3+4*, false",
		"1*3/, false",
		".5*3, false"
	})
	@Test
	public void testFor_Illegal_Inputs(String expression, boolean expected) {
		// Arrange

		// Act
		boolean actual = inputHandler.handleInput(expression);

		// Assert
		assertEquals(expected, actual);
	}

}
