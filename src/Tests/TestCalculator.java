package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculatorProject.Calculator;

public class TestCalculator {

	@Test
	public void add_Test() {

		// Arrange
		Calculator calculator = new Calculator();

		// Act
		double actual = calculator.add(3, 2);

		// Assert
		assertEquals(5d, actual, 0.111);
	}

}
