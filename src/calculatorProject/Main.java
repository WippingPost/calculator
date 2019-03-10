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
					System.out.println("===> '" + expression + "' = Felaktigt uttryck!\nVar god f�rs�k igen!");
				}

			} while(!legalInput);

			// H�mtar String fr�n InputHandler
			//expression = inputHandler.getExpression();


			try {
				result = calculator.calculateExpression(expression);
			} catch (Exception e) {

				if (e.toString().contains("ArithmeticException")) {		// Om division med noll
				result = "Division med noll �r inte till�tet!\nF�rs�k igen!";

				} else if (e.toString().contains("NumberFormatException")) {	// Om otill�tna tecken i f�ljd
					result = "Otill�tet uttryck!\nVar god f�rs�k igen!";

				} else if (e.toString().contains("Overflow")) {		// Om talet �r st�rre �n Double.Max_Value
					result = "Talet �r f�r stort!";
				}
			}
			System.out.println("===> '" + expression + "' = " + result);
		}
	}
}