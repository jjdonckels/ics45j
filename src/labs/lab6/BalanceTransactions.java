package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A utility class for validating the cash on hand amount at the end of the day with the 
 * amount recorded in a file
 */

public class BalanceTransactions {

	/**
	 * Given a starting balance (amount of cash at the beginning of the day) and an
	 * ending balance (amount of cash at the end of the day), checks whether the
	 * actual amount of cash at the end of the day equals the expected value (within
	 * an 1E-3 error margin)
	 * 
	 * @param startBalance amount of cash at the beginning of the day; assume always
	 *                     >= 0
	 * @param endBalance   amount of cash at the end of the day
	 * @param filename     name of file containing transactions
	 * 
	 * @return a string indicating whether the end of day total was balanced or not
	 *         (either "End of day total is properly balanced." or "End of day total
	 *         is not balanced."
	 */
	public static String balance(double startBalance, double endBalance, String filename) 
	{
		double balance = startBalance;
		
		try
		{
			Scanner in = new Scanner(new File(filename));
			while (in.hasNext())
			{
				in.nextInt(); // process over the invoice number
				double cashAmount = in.nextDouble();
				String invoiceStatus = in.next();
				
//				DEBUG
//				System.out.println(cashAmount);
				
				// if invoice paid, subtract from balance
				// if invoice received, add to balance
				if (invoiceStatus.equals("P"))
					balance -= cashAmount;
				else if (invoiceStatus.equals("R"))
					balance += cashAmount;
				
			}
			
			in.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.print("File: " + filename + " not found");
			return "";
		}
		
//		DEBUG
//		System.out.println("start: " + startBalance);
//		System.out.println("end: " + endBalance);
//		System.out.println("actual end: " + balance);
		
		
		// after all invoices have been processed, check if ending balance is as expected
		if (Math.abs(balance - endBalance) <= 1E-3)
		{
			return "End of day total is properly balanced.";
		}
		return "End of day total is not balanced.";
	}
}
