package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import calculatorProject.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@Category(UnitTests.class)
public class TestWithParameters {

	Calculator calculator;

	@Before
	public void setUpCalculator() {
		calculator = new Calculator();
	}


	@Test
	@Parameters({
		"5*5, 25.0",
		"20/2/2, 5.0",
		"2*3*4*5, 120.0"
	})
	public void calculateExpressionFromParameters(String expression, String expected) {

		// Arrange

		// Act
		String actual = "";
		try {
			actual = calculator.calculateExpression(expression);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assert
		assertEquals(expected, actual);
	}


	@Test
	@Parameters({
		"5,5,25",
		"10,9,90",
		"11,9,99",
		"25,11,275",
		"42,3,126"
	})
	public void multiplicationWithParameters(Double d1, Double d2, Double expected) {
		// Arrange

		// Act
		Double actual = calculator.multiply(d1, d2);
		// Assert
		assertEquals(expected, actual, 0.111);

	}

}
