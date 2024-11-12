package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	ArrayList<BankAccount> accounts;

	/**
	 * Construct a Bank object with accounts read from the given file
	 * 
	 * @param filename the name of the file
	 */
	public Bank(String fileName) {
		accounts = new ArrayList<BankAccount>();
		
		try 
		{
			Scanner in = new Scanner(new File(fileName));
			
			while (in.hasNext())
			{
				int currAccNum = in.nextInt();
				double currAccBalance = in.nextDouble();
				
				accounts.add(new BankAccount(currAccNum, currAccBalance));
			}
			
			in.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Gets the account with the lowest balance.
	 * 
	 * @return the account with the lowest balance, or null if there are
	 * no accounts in this bank
	 */
	public BankAccount getLowestBalanceAccount() {
		if (accounts.isEmpty())
			return null;
		
		BankAccount min = accounts.get(0);
		
		for (int i = 1; i < accounts.size(); ++i) 
		{
			if (accounts.get(i).getBalance() < min.getBalance())
				min = accounts.get(i);
		}
		
		return min;
	}
}
