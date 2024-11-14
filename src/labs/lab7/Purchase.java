package labs.lab7;

import java.time.LocalDate;

/**
 * Represents a purchase
 *
 */
public class Purchase implements Comparable<Purchase> {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a new Purchase
	 * 
	 * @param date        the date of the purchase
	 * @param description a description of the purchase
	 * @param amount      the amount of the purchase (if < 0, sets it to 0)
	 */
	public Purchase(LocalDate date, String description, double amount) {
		// FILL IN
	}


	public LocalDate getDate() {
		return LocalDate.now(); // FIX ME
	}


	public String getDescription() {
		return ""; // FIX ME
	}


	public double getAmount() {
		return -1.0; // FIX ME
	}


	/**
	 * Returns a string representing this purchase, consisting of the date,
	 * description, and amount, each separated by a single space
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}


	/**
	 * Returns true if the date, description, and amount all match
	 */
	@Override
	public boolean equals(Object o) {
		return false; // FIX ME
	}


	/**
	 * Compares first by date (earlier dates first), then by amount (higher amounts
	 * first), then by description (lexicographically)
	 */
	public int compareTo(Purchase other) {
		return -1; // FIX ME
	}

}