import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	static SecureRandom rng = new SecureRandom();
	static Scanner scan = new Scanner(System.in);
	static 	int multiplicandOne, multiplicandTwo, answer;

	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		CAI1 cai = new CAI1();
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
			displayCorrectResponse();
			correct = true;
		}
		else
		{
			displayIncorrectResponse();
			correct = false;
		}
		return correct;
	}
	public void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	public void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
}