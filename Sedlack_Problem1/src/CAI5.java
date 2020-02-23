import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	static SecureRandom rng = new SecureRandom();
	static Scanner scan = new Scanner(System.in);
	static int intOne, intTwo, totalCorrect, difficulty,  operatorNumber;
	static float answer;
	static boolean[][] multiplicandList, addList, subtractList, divideList;
	

	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		int i = 0;
		multiplicandList = new boolean[10000][10000];
		addList = new boolean[10000][10000];
		subtractList = new boolean[10000][10000];
		divideList = new boolean[10000][10000];
		CAI5 cai = new CAI5();
		cai.setDifficulty(cai.difficulty());
		cai.askOperator();
		while(i < 10)
		{
			cai.askQuestion(operatorNumber);
			i++;
		}
		cai.calculatePercent();
		cai.newSet();
	}
	
	private int difficulty()
	{
		int level;
		System.out.println("Choose a difficulty: 1, 2, 3, 4.");
		level = scan.nextInt();
		return level;
	}

	private void setDifficulty(int n)
	{
		difficulty = 10;
		for(int i = 1; i < n; i++)
			difficulty *= 10;
	}

	private void askOperator()
	{
		System.out.println("Choose an operator: 1 for addition, 2 for multiplication, 3 for subtraction, 4 for divide, or 5 for a random assortment of all 4");
		setOperator(scan.nextInt());
	}

	private void setOperator(int n)
	{ 
		operatorNumber = n;
	}
	
	private int operator(int n)
	{
		int o;
		if(n == 5)
			o = rng.nextInt(4)+1;
		else
			o = n;
		switch(o)
		{
			case 1: add();
				break;
			case 2: multiply();
				break;
			case 3: subtract();
				break;
			case 4: divide();
				break;
		}
		return o;
	}

	private void add()
	{
		intOne = random();
		intTwo	= random();
		if(checkForDouble(intOne, intTwo))
			add();
		addList[intOne][intTwo] = true;
		answer = intOne+intTwo;
	}

	private void multiply()
	{
		intOne = random();
		intTwo	= random();
		if(checkForDouble(intOne, intTwo))
			multiply();
		multiplicandList[intOne][intTwo] = true;
		answer = intOne*intTwo;
	}

	private void subtract()
	{
		intOne = random();
		intTwo	= random();
		if(checkForDouble(intOne, intTwo))
			subtract();
		subtractList[intOne][intTwo] = true;
		answer = intOne-intTwo;
	}

	private void divide()
	{
		intOne = random();
		intTwo = random();
		if(checkForDouble(intOne, intTwo) || intTwo == 0)
			divide();
		divideList[intOne][intTwo] = true;
		answer = ((float)intOne)/intTwo;
	}

	private int random()
	{
		return rng.nextInt(difficulty); 
	}

	private static boolean checkForDouble(int a, int b)
	{
		boolean doup = false;
		switch(operatorNumber)
		{
			case 1: if(addList[a][b])
						doup = true;
					else
						doup = false; 
				break;
			case 2: if(multiplicandList[a][b])
						doup = true;
					else
						doup = false;
				break;
			case 3: if(subtractList[a][b])
						doup = true;
					else
						doup = false;
				break;
			case 4: if(divideList[a][b])
						doup = true;
					else
						doup = false;
				break;
		}
		
		return doup;
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
	
	private void calculatePercent()
	{
		if((((float)totalCorrect)/10) < 0.75)
			System.out.println("Please ask your teacher for extra help.");
		else
			System.out.println("Congratulations, you are ready to go to the next level!");
	}
	private static int randomResponse()
	{
		int response;
		response = rng.nextInt(4);
		return response;
	}
	private void askQuestion(int n)
	{
		switch(operator(n))
		{
			case 1: System.out.println("What is " + intOne +" + " + intTwo + "?");
				break;
			case 2: System.out.println("What is " + intOne +" X " + intTwo + "?");
				break;
			case 3: System.out.println("What is " + intOne +" - " + intTwo + "?");
				break;
			case 4: System.out.println("What is " + intOne +" / " + intTwo + "?");
				break;
		}
		isAnswerCorrect(readResponse());
	}
	private float readResponse(){
		float userGuess;
		userGuess = scan.nextFloat();
		return userGuess;
	}
	private boolean isAnswerCorrect(float guess)
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