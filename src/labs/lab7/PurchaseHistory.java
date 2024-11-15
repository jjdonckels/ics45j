package labs.lab7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Represents a record of purchases
 *
 */
public class PurchaseHistory {

	private ArrayList<Purchase> purchases;

	public PurchaseHistory() {
		purchases = new ArrayList<Purchase>();
	}


	/**
	 * Adds a purchase to the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 */
	public void addPurchase(LocalDate date, String description, double amount) {
		purchases.add(new Purchase(date, description, amount));
	}


	/**
	 * Removes all purchases matching the given parameters from the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 * 
	 * @return the number of purchases matching the parameters and therefore removed
	 */
	public int removePurchase(LocalDate date, String description, double amount) {
		Purchase target = new Purchase(date, description, amount);
		int numRemoved = 0;
		
		// loop through every purchase
		for (int i = 0; i < purchases.size(); ++i) 
		{
			if (purchases.get(i).equals(target))
			{
				purchases.remove(i);
				++numRemoved;
				// decrement index to account for the shortening of the list after removal
				--i;
			}
		}
		
		return numRemoved;
	}


	/**
	 * Gets a list of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a list of purchases in the date range, in sorted order
	 */
	public List<Purchase> getPurchasesInDateRange(LocalDate start, LocalDate end) {
		ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
		
		// loop through all purchases
		for (int i = 0; i < purchases.size(); ++i) 
		{
			Purchase current = purchases.get(i);
			
			// check date range
			if (current.getDate().compareTo(start) >= 0 && current.getDate().compareTo(end) <= 0)
				toReturn.add(current);
		}
		
		Collections.sort(toReturn);
		
		return toReturn;
	}


	/**
	 * Gets the total of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return the total of purchases in the date range
	 */
	public double getPurchaseTotalInDateRange(LocalDate start, LocalDate end) {
		double total = 0;
		
		// loop through all purchases
		for (int i = 0; i < purchases.size(); ++i)
		{
			Purchase current = purchases.get(i);
			
			// check date range
			if (current.getDate().compareTo(start) >= 0 && current.getDate().compareTo(end) <= 0)
				total += current.getAmount();
		}
		
		return total;
	}


	/**
	 * Gets a list of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return a list of purchases matching the description, in sorted order
	 */
	public List<Purchase> getPurchasesMatchingDescription(String description) {
		ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
		
		// loop through all purchases
		for (int i = 0; i < purchases.size(); ++i) 
		{
			String currentDescription = purchases.get(i).getDescription();
			
			if (currentDescription.equals(description))
				toReturn.add(purchases.get(i));
		}
		
		Collections.sort(toReturn);
		
		return toReturn;
	}


	/**
	 * Gets the total of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return the total of purchases that match the description
	 */
	public double getPurchaseTotalMatchingDescription(String description) {
		double total = 0;
		
		// loop through all purchases
		for (int i = 0; i < purchases.size(); ++i) 
		{
			String currentDescription = purchases.get(i).getDescription();
			
			if (currentDescription.equals(description))
				total += purchases.get(i).getAmount();
		}
		
		return total;
	}


	/**
	 * Gets a list of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return a list of purchases in the amount range, in sorted order
	 */
	public List<Purchase> getPurchasesInAmountRange(double min, double max) {
		ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
		
		// loop through all purchases
		for (int i = 0; i < purchases.size(); ++i) 
		{
			double current = purchases.get(i).getAmount();
			
			if (current >= min && current <= max)
				toReturn.add(purchases.get(i));
		}
		
		Collections.sort(toReturn);
		
		return toReturn;
	}


	/**
	 * Gets the total of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return the total of purchases in the amount range
	 */
	public double getPurchaseTotalInAmountRange(double min, double max) {
		double total = 0;
		
		// loop through all purchases
		for (int i = 0; i < purchases.size(); ++i) 
		{
			double current = purchases.get(i).getAmount();
			
			if (current >= min && current <= max)
				total += current;
		}
		
		return total;
	}


	/**
	 * Gets the most expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the most expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMaxPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> validPurchases = getPurchasesInDateRange(start, end);
		
		// go through validPurchases and find the max
		if (validPurchases.size() == 0)
			return new ArrayList<Purchase>(); // return empty list if no valid purchases
		else if (validPurchases.size() == 1) // if only one valid purchase just return that one
		{
			ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
			toReturn.add(validPurchases.get(0));
			
			return toReturn;
		}
		
		// if there are multiple valid purchases, we need to loop through them and find the max
		double maxAmount = validPurchases.get(0).getAmount();
		
		for (int i = 1; i < validPurchases.size(); ++i) 
		{
			double currentAmount = validPurchases.get(i).getAmount();
			
			if (currentAmount > maxAmount)
				maxAmount = currentAmount;
		}
		
		// now we have the max, so we need all purchases that have an amount equal to max
		ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
		
		// go back through valid purchases and add those that have amount equal to max
		for (int i = 0; i < validPurchases.size(); ++i)
		{
			Purchase current = validPurchases.get(i);
			
			if (current.getAmount() == maxAmount)
				toReturn.add(current);
		}
		
		Collections.sort(toReturn);
		
		return toReturn;
	}


	/**
	 * Gets the least expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the least expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMinPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> validPurchases = getPurchasesInDateRange(start, end);
		
		// go through validPurchases and find the min
		if (validPurchases.size() == 0)
			return new ArrayList<Purchase>(); // return empty list if no valid purchases
		else if (validPurchases.size() == 1) // if only one valid purchase just return that one
		{
			ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
			toReturn.add(validPurchases.get(0));
			
			return toReturn;
		}
		
		// if there are multiple valid purchases, we need to loop through them and find the min
		double minAmount = validPurchases.get(0).getAmount();
		
		for (int i = 1; i < validPurchases.size(); ++i) 
		{
			double currentAmount = validPurchases.get(i).getAmount();
			
			if (currentAmount < minAmount)
				minAmount = currentAmount;
		}
		
		// now we have the max, so we need all purchases that have an amount equal to max
		ArrayList<Purchase> toReturn = new ArrayList<Purchase>();
		
		// go back through valid purchases and add those that have amount equal to max
		for (int i = 0; i < validPurchases.size(); ++i)
		{
			Purchase current = validPurchases.get(i);
			
			if (current.getAmount() == minAmount)
				toReturn.add(current);
		}
		
		Collections.sort(toReturn);
		
		return toReturn;
	}


	/**
	 * Returns a string representing all the purchases in the history, sorted, with
	 * a comma and space between each one
	 */
	@Override
	public String toString() {
		ArrayList<Purchase> sortedPurchases = new ArrayList<Purchase>();
		
		for(int i = 0; i < purchases.size(); ++i)
		{
			Purchase temp = purchases.get(i);
			sortedPurchases.add(new Purchase(temp.getDate(), temp.getDescription(), temp.getAmount()));
		}
		
		Collections.sort(sortedPurchases);
		
		String returnMe = "";
		
		// now we have all the purchases sorted, so we can return their strings from here
		for (int i = 0; i < sortedPurchases.size() - 1; ++i)
		{
			returnMe += sortedPurchases.get(i).toString() + ", ";
		}
		
		// add last purchase without comma and space at the end
		returnMe += sortedPurchases.get(sortedPurchases.size() - 1).toString();
		
		return returnMe;
	}

}
