package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
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



	// ********************************************************************************
	// ********************************************************************************
	// Testar olika inparametrar f�r korrekt utr�kning.
	// ********************************************************************************
	// ********************************************************************************
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


	// ********************************************************************************
	// ********************************************************************************
	// Testar olika inparametrar som inneh�ller division med noll.
	// Inkluderar �ven modulus-metoden.
	// Kollar efter "ArithmetcException"-error
	// ********************************************************************************
	// ********************************************************************************
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	@Parameters({
		"5*5%0, 25.0",
		"20/2/0, 0",
		"2*3*4*5+3-4*34/0, 120.0"
	})
	public void calculateExpressionFromParametersAndCheckForArithmeticExceptionDivideByZero(String expression, String expected) throws Exception {

		// Arrange

		// Act
		thrown.expect(ArithmeticException.class);
		String actual = "";
		actual = calculator.calculateExpression(expression);
		// Assert
		assertEquals(expected, actual);
	}

	/*
	 * Testar multiplikation med inparametrar
	 */
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


	/*
	 * Testar kombinationer av dubbla matematiska tecken, s�som '++' '--' '---' osv..
	 */
	@Test
	@Parameters({
		"5*-5, -25.0",
		"20/2/-2, -5.0",
		"12--2, 14.0",
		"12---2, 10.0"
	})
	public void calculateExpressionFromMultipleOperatorsInARow(String expression, String expected) {

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

}
