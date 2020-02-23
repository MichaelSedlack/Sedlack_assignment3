import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	static SecureRandom rng = new SecureRandom();
	static Scanner scan = new Scanner(System.in);
	static 	int multiplicandOne, multiplicandTwo, answer;

	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		CAI2 cai = new CAI2();
		cai.askQuestion();
	}
	
	private void multiply()
	{
		multiplicandOne = random();
		multiplicandTwo	= random();
		answer = multiplicandOne*multiplicandTwo;
	}
	
	private static int random()
	{
		int print;
		print = rng.nextInt(10);
		return print;
	}
	private static int randomResponse()
	{
		int response;
		response = rng.nextInt(4);
		return response;
	}
	private void askQuestion()
	{
		multiply();
		System.out.println("What is " + multiplicandOne +" X " + multiplicandTwo + "?");
		if(!isAnswerCorrect(readResponse()))
			askQuestion();
	}
	private int readResponse(){
		int userGuess;
		userGuess = scan.nextInt();
		return userGuess;
	}
	private boolean isAnswerCorrect(int guess)
	{
		boolean correct;
		if(guess == answer)
		{
			displayCorrectResponse(randomResponse());
			correct = true;
		}
		else
		{
			displayIncorrectResponse(randomResponse());
			correct = false;
		}
		return correct;
	}
	private void displayCorrectResponse(int response)
	{
		switch(response)
		{
			case 0: System.out.println("Very good!");
				break;
			case 1: System.out.println("Excellent!");
				break;
			case 2: System.out.println("Nice Work!");
				break;
			case 3: System.out.println("Keep up the good work!");
				break;
		}
	}
	private void displayIncorrectResponse(int response)
	{
		switch(response)
		{
			case 0: System.out.println("No. Please try again.");
				break;
			case 1: System.out.println("Wrong. Try once more.");
				break;
			case 2: System.out.println("Don't give up!");
				break;
			case 3: System.out.println("No. Keep trying.");
				break;
		}
	}
}