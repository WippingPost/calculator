package calculatorProject;

import java.util.ArrayList;

public class Calculator {

	private ArrayList<String> splitExpression;

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		try {
			calculator.calculateExpression("10");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String calculateExpression(String expression) throws Exception{

		splitExpression = new ArrayList<>();

		// Delar upp expression och
		// Placerar alla tal och operat�rer i en lista efter varandra

		String[] exp = expression.split("(?<=[*/%+-])");

		//System.out.println("Uttryck efter f�rsta split: " + Arrays.toString(exp));

		for (int i = 0; i < exp.length; i++) {
			String[] temp = exp[i].split("(?=[*/%+-])");
			splitExpression.add(temp[0]);
			try {
				splitExpression.add(temp[1]);
			} catch (IndexOutOfBoundsException e) {
			}
		}

		//System.out.println("En f�rsta lista: " + splitExpression);



		// F�rst k�r vi igenom listan och utf�r multiplikation och/eller division
		// Enligt de regler om prioritering som finns,
		// Och uppdaterar listan allteftersom

		for (int i = 0; i < splitExpression.size()-1; i++) {

			// Variabler
			Double result, d1, d2;

			// Kollar om vi har * tecken...
			if (splitExpression.get(i).contains("*")) {
				try {
					d1 = Double.parseDouble(splitExpression.get(i - 1));
					d2 = Double.parseDouble(splitExpression.get(i + 1));

					// multiplicerar d1 o d2
					result = multiply(d1, d2);

					// L�gger till result till listan samt raderar f�rbrukade poster
					splitExpression.set(i - 1, result.toString());
					splitExpression.remove(i);
					splitExpression.remove(i);
					i--;	// St�ller tillbaka i s� att den pekar p� r�tt element n�sta iteration
				} catch (Exception e) {
					// TODO
				}
			}


			// Kollar om vi har / tecken...
			if (splitExpression.get(i).contains("/")) {
				try {
					d1 = Double.parseDouble(splitExpression.get(i - 1));
					d2 = Double.parseDouble(splitExpression.get(i + 1));

					// Dividerar d1 o d2
					result = divide(d1, d2);

					// L�gger till result till listan samt raderar f�rbrukade poster
					splitExpression.set(i - 1, result.toString());
					splitExpression.remove(i);
					splitExpression.remove(i);
					i--;	// St�ller tillbaka i s� att den pekar p� r�tt element n�sta iteration
				} catch (Exception e) {
					// TODO
				}
			}


			// Kollar om vi har % (Modulus) tecken...
			if (splitExpression.get(i).contains("%")) {
				try {
					d1 = Double.parseDouble(splitExpression.get(i - 1));
					d2 = Double.parseDouble(splitExpression.get(i + 1));

					// Kollar kvarstoden av d1 % d2
					result = remainder(d1, d2);

					// L�gger till result till listan samt raderar f�rbrukade poster
					splitExpression.set(i - 1, result.toString());
					splitExpression.remove(i);
					splitExpression.remove(i);
					i--;	// St�ller tillbaka i s� att den pekar p� r�tt element n�sta iteration
				} catch (Exception e) {
					// TODO
				}
			}
		}


		//System.out.println("Efter multiplikation/division: " + splitExpression);

		// Kollar s� att listan inte slutar med en operat�r
		switch (splitExpression.get(splitExpression.size()-1)) {
		case "*":
		case "/":
		case "+":
		case "-":
			throw new Exception("Felaktig avslutning p� uttryck!");
		}

		// Nu har vi en f�rdig lista att bara summera ihop

		Double result = 0.0, temp = 0.0;

		// Kollar om v�r lista bara har en enda post
		if (splitExpression.size() == 1) {

			result = Double.parseDouble(splitExpression.get(0));

		} else {

			for (int i = 0; i < splitExpression.size() - 1; i++) {

				// Kollar f�rst om vi har en siffra eller en operat�r (utifall uttrycket b�rjar med en operat�r (- eller +))
				if (splitExpression.get(i).equals("-")) {
					try {
						temp = Double.parseDouble(splitExpression.get(i + 1)) * -1;
					} catch (Exception e) {
						// TODO: handle exception
					}
					splitExpression.set(i + 1, temp.toString());
					splitExpression.remove(i);
					i--;	// St�ller tillbaka i s� att den pekar p� r�tt element n�sta iteration
				} else {
					if (splitExpression.get(i).equals("+")) {
						i++;	// St�ller fram i s� att den pekar p� r�tt element n�sta iteration
					}
					temp = Double.parseDouble(splitExpression.get(i));
				}
				result = result + temp;
			}
		}

		//System.out.println("Resultat utr�kning = " + result);

		return result.toString();
	}



	// Addition
	public double add(double d1, double d2) {
		return d1 + d2;
	}

	// Subtraction
	public double subtract(double d1, double d2) {
		return d1 - d2;
	}

	// Multiplication
	public double multiply(double d1, double d2) {
		return (d1 * d2);
	}

	// Division
	public double divide(double d1, double d2) {

		if (d1 == 0 || d2 == 0) {
			System.out.println("Division by zero not allowed!");
			throw new ArithmeticException("Division by zero not allowed!");
		} else return (d1 / d2);

	}

	// Remainder
	public double remainder(double d1, double d2) {
		return (d1 % d2);
	}

}
