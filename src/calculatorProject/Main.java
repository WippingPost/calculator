package calculatorProject;


public class Main {

	public static void main(String[] args) throws Exception {

		Calculator calculator = new Calculator();
		InputHandler inputHandler = new InputHandler();
		String result = "", expression = "";

		while (true) {

			// Hämtar String från InputHandler
			expression = inputHandler.getExpression();

			try {
				result = calculator.calculateExpression(expression);
			} catch (Exception e) {

				if (e.toString().contains("ArithmeticException")) {		// Om division med noll
				result = "Division med noll är inte tillåtet!\nFörsök igen!";

				} else if (e.toString().contains("NumberFormatException")) {	// Om otillåtna tecken i följd
					result = "Otillåtet uttryck, försök igen!";

				} else if (e.toString().contains("Overflow")) {		// Om talet är större än Double.Max_Value
					result = "Talet är för stort!";
				}
			}
			System.out.println("Resultatet av '" + expression + "' = " + result);
		}
	}
}