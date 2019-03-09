package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculatorProject.Calculator;

public class TestCalculator {

	Calculator calculator = new Calculator();


	@Test
	public void add_Test() {

		// Arrange
		Calculator calculator = new Calculator();

		// Act
		double actual = calculator.add(3, 2);

		// Assert
		assertEquals(5d, actual, 0.111);
	}


	@Test
	public void subtract_Test() {

		// Arrange
		Calculator calculator = new Calculator();

		// Act
		double actual = calculator.subtract(25, 12);

		// Assert
		assertEquals(13d, actual, 0.111);

	}


	@Test
	public void multiplication_Test() {

		// Arrange
		Calculator calculator = new Calculator();

		// Act
		double actual = calculator.multiply(3, 2);

		// Assert
		assertEquals(6d, actual, 0.111);

	}


	@Test
	public void division_Test() {

		// Arrange
		Calculator calculator = new Calculator();

		// Act
		double actual = calculator.divide(5, 2);

		// Assert
		assertEquals(2.5d, actual, 0.111);

	}


	@Test
	public void modulus_Test() {

		// Arrange
		Calculator calculator = new Calculator();

		// Act
		double actual = calculator.remainder(10, 3);

		// Assert
		assertEquals(1d, actual, 0.111);

	}

}
