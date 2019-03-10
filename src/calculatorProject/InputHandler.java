package calculatorProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

	Scanner scanner = new Scanner(System.in);
	String result = "";
	Pattern allowed = Pattern.compile("[^0-9%*/+-.E]");	// Till�tna tecken i input String
	Pattern allowedEnding = Pattern.compile("[0-9]");	// Till�tna sista tecken i input String
	Pattern allowedBeginning = Pattern.compile("[-+0-9]");	// Till�tna tecken f�rsta tecken i input String
	boolean legalInput;

	public boolean handleInput(String expression) {

		// Variabler
		String endCharacter, beginCharacter;
		endCharacter = "";
		beginCharacter = "";
		legalInput = false;

		// Skapar ett Matcher-objekt f�r att kolla om inmatning �r korrekt
		Matcher hasAllowed = allowed.matcher(expression);

		// Kollar s� det inte �r en tom String
		if (!expression.equals("")) {

			// Kollar s� att input inte inneh�ller felaktiga tecken
			legalInput = !hasAllowed.find();

			if (legalInput) {

				// Vad har vi f�r tecken i slutet? Kollar s� inte n�t annat �n en siffra
				endCharacter = expression.substring(expression.length() - 1);
				Matcher hasAllowedEnding = allowedEnding.matcher(endCharacter);
				if (!hasAllowedEnding.find()) {		// True om tecken �terfinns i Pattern allowedEnding
					return false;
				}

				// Kollar s� att input inte b�rjar med otill�tet tecken
				beginCharacter = expression.substring(0, 1);
				Matcher hasAllowedBeginning = allowedBeginning.matcher(beginCharacter);
				if (!hasAllowedBeginning.find()) {		// True om tecken �terfinns i Pattern allowedBeginning
					return false;
				}
			}
		}

		return legalInput;

	}
}
