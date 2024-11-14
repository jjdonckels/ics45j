package labs.lab7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a record of purchases
 *
 */
public class PurchaseHistory {

	// ADD YOUR INSTANCE VARIABLES EHRE

	public PurchaseHistory() {
		// FILL IN
	}


	/**
	 * Adds a purchase to the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 */
	public void addPurchase(LocalDate date, String description, double amount) {
		// FILL IN
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
		return -1; // FIX ME
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
		return new ArrayList<Purchase>(); // FIX ME
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
		return -1.0; // FIX ME
	}


	/**
	 * Gets a list of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return a list of purchases matching the description, in sorted order
	 */
	public List<Purchase> getPurchasesMatchingDescription(String description) {
		return new ArrayList<Purchase>(); // FIX ME
	}


	/**
	 * Gets the total of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return the total of purchases that match the description
	 */
	public double getPurchaseTotalMatchingDescription(String description) {
		return -1.0; // FIX ME
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
		return new ArrayList<Purchase>(); // FIX ME
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
		return -1.0; // FIX ME
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
		return new ArrayList<Purchase>(); // FIX ME
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
		return new ArrayList<Purchase>(); // FIX ME
	}


	/**
	 * Returns a string representing all the purchases in the history, sorted, with
	 * a comma and space between each one
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}

}
