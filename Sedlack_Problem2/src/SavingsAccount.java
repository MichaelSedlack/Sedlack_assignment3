import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

public class SavingsAccount extends JPanel {
	private static double annualInterestRate;
	private static int i = 0;
	private double balance;

	private static void showTable(double n)
	{
		i++;
		SavingsAccount save = new SavingsAccount();
		save.setBalance(n);
		JFrame frame = new JFrame("Yearly Interest Data - " + i);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(save.createTable());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 250);
	}
	public Container createTable() 
	{
		new GridLayout(1,0);
        String[] columnNames = {"Month",
                                "Balance"};
        Object[][] data = {
        		{"January", "$" + new Double(calculateMonthlyInterest())},
				{"February", "$" + new Double(calculateMonthlyInterest())},
				{"March", "$" + new Double(calculateMonthlyInterest())},
				{"April", "$" + new Double(calculateMonthlyInterest())},
				{"May", "$" + new Double(calculateMonthlyInterest())},
				{"June", "$" + new Double(calculateMonthlyInterest())},
				{"July", "$" + new Double(calculateMonthlyInterest())},
				{"August", "$" + new Double(calculateMonthlyInterest())},
				{"September", "$" + new Double(calculateMonthlyInterest())},
				{"October", "$" + new Double(calculateMonthlyInterest())},
				{"November", "$" + new Double(calculateMonthlyInterest())},
				{"December", "$" + new Double(calculateMonthlyInterest())}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
		return scrollPane;
	}
	public void setBalance(double n)
	{
		balance = n;
	}
	public double getBalance()
	{
		return balance;
	}
	
	public void modifyInterest(double d)
	{
		annualInterestRate = d;
	}
	public double getInterest()
	{
		return annualInterestRate;
	}
	double calculateMonthlyInterest()
	{
		setBalance(((getBalance()*annualInterestRate)/12)+getBalance());
		return getBalance();
	}
	
	void MonthlyInterest()
	{
		showTable(getBalance());
		for(int j = 0; j < 12; j++)
			calculateMonthlyInterest();
	}
}
