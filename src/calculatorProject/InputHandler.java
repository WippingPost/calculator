package calculatorProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

	Scanner scanner = new Scanner(System.in);
	String result = "";
	Pattern allowed = Pattern.compile("[^0-9%*/+-.E]");	// Tillåtna tecken i input String
	Pattern allowedEnding = Pattern.compile("[0-9]");	// Tillåtna sista tecken i input String
	Pattern allowedBeginning = Pattern.compile("[-+0-9]");	// Tillåtna tecken första tecken i input String
	boolean legalInput;

	public boolean handleInput(String expression) {

		// Variabler
		String endCharacter, beginCharacter;
		endCharacter = "";
		beginCharacter = "";
		legalInput = false;

		// Skapar ett Matcher-objekt för att kolla om inmatning är korrekt
		Matcher hasAllowed = allowed.matcher(expression);

		// Kollar så det inte är en tom String
		if (!expression.equals("")) {

			// Kollar så att input inte innehåller felaktiga tecken
			legalInput = !hasAllowed.find();

			if (legalInput) {

				// Vad har vi för tecken i slutet? Kollar så inte nåt annat än en siffra
				endCharacter = expression.substring(expression.length() - 1);
				Matcher hasAllowedEnding = allowedEnding.matcher(endCharacter);
				if (!hasAllowedEnding.find()) {		// True om tecken återfinns i Pattern allowedEnding
					return false;
				}

				// Kollar så att input inte börjar med otillåtet tecken
				beginCharacter = expression.substring(0, 1);
				Matcher hasAllowedBeginning = allowedBeginning.matcher(beginCharacter);
				if (!hasAllowedBeginning.find()) {		// True om tecken återfinns i Pattern allowedBeginning
					return false;
				}
			}
		}

		return legalInput;

	}
}
