
public class SavingsAccountTest {
	public static void main(String[] args)
	{
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		saver1.modifyInterest(0.04);
		saver1.setBalance(2000);
		saver2.setBalance(3000);
		saver1.MonthlyInterest();
		saver2.MonthlyInterest();
		saver2.modifyInterest(0.05);
		saver1.MonthlyInterest();
		saver2.MonthlyInterest();
	}
}
