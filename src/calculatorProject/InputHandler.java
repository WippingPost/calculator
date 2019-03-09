package calculatorProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

	Scanner scanner = new Scanner(System.in);
	String result = "", expression = "";
	Pattern allowed = Pattern.compile("[^0-9%*/+-]");
	Pattern allowedEnding = Pattern.compile("[0-9]");
	Pattern allowedBeginning = Pattern.compile("[-+0-9]");
	boolean legalinput;

	public String getExpression() {

		do {
			legalinput = false;
			System.out.println("\nSkriv in ett matematiskt uttryck: ");
			expression = scanner.nextLine();

			Matcher hasAllowed = allowed.matcher(expression);


			// Kollar så att input inte innehåller felaktiga tecken
			legalinput = !hasAllowed.find();

			// Kollar så inte tom String
			if (expression.equals("")) {
				legalinput = false;
			} else {
				String endCharacter = expression.substring(expression.length() - 1);
				// Kollar så att input inte avslutas med något annat än en siffra
				Matcher hasAllowedEnding = allowedEnding.matcher(endCharacter);
				legalinput = hasAllowedEnding.find();	// True om tecken återfinns i Pattern allowedEnding

				// Kollar så att input inte börjar med otillåtet tecken
				String beginCharacter = expression.substring(0, 1);
				Matcher hasAllowedBeginning = allowedBeginning.matcher(beginCharacter);
				legalinput = hasAllowedBeginning.find();  // True om tecken återfinns i Pattern allowedBeginning
			}

			if (!legalinput) {
				System.out.println("Felaktigt uttryck '" + expression + "', var god försök igen!");
			}

		} while (!legalinput);

		return expression;

	}
}
