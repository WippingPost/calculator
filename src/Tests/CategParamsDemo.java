package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import calculatorProject.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@Category(UnitTests.class)
public class CategParamsDemo {

	@Test
	@Parameters({
		"5,5,25",
		"2,2,4",
		"43,0,0"
	})
	public void multiplyingtest(double a, double b, double expected) {
		Calculator calc = new Calculator();
		double actual = calc.multiply(a, b);
		assertEquals(expected, actual, 0.001);
	}
}
