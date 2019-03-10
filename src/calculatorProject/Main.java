package calculatorProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Calculator calculator = new Calculator();
		InputHandler inputHandler = new InputHandler();
		String result = "", expression = "";
		Scanner scanner = new Scanner(System.in);
		boolean legalInput;

		while (true) {

			do {

				System.out.println("\nSkriv in ett matematiskt uttryck: ");
				expression = scanner.nextLine();

				legalInput = inputHandler.handleInput(expression);

				if (!legalInput) {
					System.out.println("===> '" + expression + "' = Felaktigt uttryck!\nVar god försök igen!");
				}

			} while(!legalInput);

			// Hämtar String från InputHandler
			//expression = inputHandler.getExpression();


			try {
				result = calculator.calculateExpression(expression);
			} catch (Exception e) {

				if (e.toString().contains("ArithmeticException")) {		// Om division med noll
				result = "Division med noll är inte tillåtet!\nFörsök igen!";

				} else if (e.toString().contains("NumberFormatException")) {	// Om otillåtna tecken i följd
					result = "Otillåtet uttryck!\nVar god försök igen!";

				} else if (e.toString().contains("Overflow")) {		// Om talet är större än Double.Max_Value
					result = "Talet är för stort!";
				}
			}
			System.out.println("===> '" + expression + "' = " + result);
		}
	}
}