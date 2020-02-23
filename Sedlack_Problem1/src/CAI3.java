import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	static SecureRandom rng = new SecureRandom();
	static Scanner scan = new Scanner(System.in);
	static 	int multiplicandOne, multiplicandTwo, answer, totalCorrect;
	static boolean[][] multiplicandList;
	

	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		int i = 0;
		multiplicandList = new boolean[10][10];
		CAI3 cai = new CAI3();
		while(i < 10)
		{
			cai.askQuestion();
			i++;
		}
		cai.calculatePercent();
		cai.newSet();
	}
	
	private void newSet()
	{
		System.out.println("Would you like a new set of questions? Type 1 for yes, 0 for no.");
		if(checkNewSet(scan.nextInt()))
			quiz();
		
	}
	private boolean checkNewSet(int num)
	{
		boolean check;
		if(num == 0)
			check = false;
		else if(num == 1)
			check = true;
		else check = false;
		return check;
	}
	
	private void multiply()
	{
		multiplicandOne = random();
		multiplicandTwo	= random();
		if(checkForDouble(multiplicandOne, multiplicandTwo))
			multiply();
		multiplicandList[multiplicandOne][multiplicandTwo] = true;
		answer = multiplicandOne*multiplicandTwo;
	}
	private void calculatePercent()
	{
		if((((float)totalCorrect)/10) < 0.75)
			System.out.println("Please ask your teacher for extra help.");
		else
			System.out.println("Congratulations, you are ready to go to the next level!");
	}
	private static int random()
	{
		int print;
		print = rng.nextInt(10);
		return print;
	}
	
	private static boolean checkForDouble(int a, int b)
	{
		boolean doup;
		if(multiplicandList[a][b])
			doup = true;
		else
			doup = false;
		
		return doup;
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
		isAnswerCorrect(readResponse());
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
			totalCorrect++;
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