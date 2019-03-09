package Tests;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import calculatorProject.Calculator;

public class TestExceptions {

	Calculator calculator;

	@Before
	public void beforeTests() {
		calculator = new Calculator();
	}


	/*
	 * Testar metoderna i Calculator för ArithmeticException
	 */
	@Test ( expected = ArithmeticException.class)
	public void divideByZero_Exception() {

		// Arrange

		// Act
		calculator.divide(10, 0);
		// Assert
	}

	/*
	 * Testar metoderna i Calculator för ArithmeticException
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testExceptions()  {

		// Arrange

		// Act
		thrown.expect(ArithmeticException.class);
		calculator.divide(10, 0);
		// Assert

	}

}
