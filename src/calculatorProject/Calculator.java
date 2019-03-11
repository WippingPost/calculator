package calculatorProject;

import java.util.ArrayList;

public class Calculator {

	private ArrayList<String> splitExpression;

	public String calculateExpression(String expression) throws Exception{

		splitExpression = new ArrayList<>();

		// Delar upp expression och
		// Placerar alla tal och operat�rer i en lista efter varandra

		String[] exp = expression.split("(?<=[*/%+-])");

		for (int i = 0; i < exp.length; i++) {
			String[] temp = exp[i].split("(?=[*/%+-])");
			splitExpression.add(temp[0]);
			try {
				splitExpression.add(temp[1]);
			} catch (Exception e) {
			}
		}


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

					// Kollar vad f�r tecken som kommer efter
					if (splitExpression.get(i + 1).equals("+")) {
						splitExpression.remove(i + 1);
						i--;	// St�ll tillbaka pekaren igen
					} else if (splitExpression.get(i + 1).equals("-")) {
						if (splitExpression.get(i + 2).equals("-")) {

						} else {
							d2 = (Double.parseDouble(splitExpression.get(i + 2)) * - 1);
							splitExpression.set(i + 1, d2.toString());
							splitExpression.remove(i + 2);
							i--;	// St�ll tillbaka pekaren igen
							d2 = 0.0;
						}
					} else {
						d2 = Double.parseDouble(splitExpression.get(i + 1));

						// multiplicerar d1 o d2
						result = multiply(d1, d2);

						// L�gger till result till listan samt raderar f�rbrukade poster
						splitExpression.set(i - 1, result.toString());
						splitExpression.remove(i);
						splitExpression.remove(i);
						i--;	// St�ller tillbaka i s� att den pekar p� r�tt element n�sta iteration
					}

				} catch (Exception e) {
					throw new Exception(e);
				}
			}


			// Kollar om vi har / tecken...
			if (splitExpression.get(i).contains("/")) {
				try {
					d1 = Double.parseDouble(splitExpression.get(i - 1));

					// Kollar vad f�r tecken som kommer efter
					if (splitExpression.get(i + 1).equals("+")) {
						splitExpression.remove(i + 1);
						i--;	// St�ll tillbaka pekaren igen
					} else if (splitExpression.get(i + 1).equals("-")) {
						if (splitExpression.get(i + 2).equals("-")) {

						} else {
							d2 = (Double.parseDouble(splitExpression.get(i + 2)) * - 1);
							splitExpression.set(i + 1, d2.toString());
							splitExpression.remove(i + 2);
							i--;	// St�ll tillbaka pekaren igen
							d2 = 0.0;
						}
					} else {
						d2 = Double.parseDouble(splitExpression.get(i + 1));

						// Dividerar d1 o d2
						result = divide(d1, d2);

						// L�gger till result till listan samt raderar f�rbrukade poster
						splitExpression.set(i - 1, result.toString());
						splitExpression.remove(i);
						splitExpression.remove(i);
						i--;	// St�ller tillbaka i s� att den pekar p� r�tt element n�sta iteration
					}
				} catch (Exception e) {
					if (e.toString().contains("ArithmeticException")) {
						throw new ArithmeticException();
					} else {
						throw new Exception(e);
					}
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
				} catch (Exception e){
					if (e.toString().contains("ArithmeticException")) {
						throw new ArithmeticException();
					} else {
						throw new Exception(e);
					}
				}
			}
		}



		// Nu har vi en f�rdig lista att bara summera ihop

		Double result = 0.0, temp = 0.0;

		// Kollar om v�r lista bara har en enda post
		if (splitExpression.size() == 1) {

			result = Double.parseDouble(splitExpression.get(0));

		} else {

			for (int i = 0; i < splitExpression.size(); i++) {

				// Kollar f�rst om vi har en siffra eller en operat�r (utifall uttrycket b�rjar med en operat�r (- eller +))
				if (splitExpression.get(i).equals("-")) {
					try {
						if (splitExpression.get(i + 1).equals("-")) {
							splitExpression.set(i, "+");	// �ndra tecken
							splitExpression.remove(i + 1);
							temp = 0.0;
							i--;	// St�ller tillbaka pekaren s� att den pekar p� r�tt element n�sta iteration
						} else {
							temp = Double.parseDouble(splitExpression.get(i + 1)) * -1;
						}
					} catch (Exception e) {
						throw new Exception(e);
					}
					i++;	// St�ller fram s� att den pekar p� r�tt element n�sta iteration
				} else {
					if (splitExpression.get(i).equals("+")) {
						i++;	// St�ller fram i s� att den pekar p� r�tt element n�sta iteration
					}
					try {
						temp = Double.parseDouble(splitExpression.get(i));
					} catch (Exception e) {
						throw new Exception(e);
					}

				}
				result = result + temp;
			}
		}

		if (result > Double.MAX_VALUE) {
			throw new Exception("Overflow");
		}

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
			throw new ArithmeticException();
		} else return (d1 / d2);

	}

	// Modulus, Remainder
	public double remainder(double d1, double d2) {
		if (d1 == 0 || d2 == 0) {
			throw new ArithmeticException();
		} else return (d1 % d2);

	}

}
