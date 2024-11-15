package labs.lab7;

import java.time.LocalDate;

/**
 * Represents a purchase
 *
 */
public class Purchase implements Comparable<Purchase> {

	private LocalDate date;
	private String description;
	private double amount;

	/**
	 * Constructs a new Purchase
	 * 
	 * @param date        the date of the purchase
	 * @param description a description of the purchase
	 * @param amount      the amount of the purchase (if < 0, sets it to 0)
	 */
	public Purchase(LocalDate date, String description, double amount) {
		this.date = date;
		this.description = description;
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public String getDescription() {
		return description;
	}


	public double getAmount() {
		return amount;
	}


	/**
	 * Returns a string representing this purchase, consisting of the date,
	 * description, and amount, each separated by a single space
	 */
	@Override
	public String toString() {
		return date.toString() + " " + description + " " + amount;
	}


	/**
	 * Returns true if the date, description, and amount all match
	 */
	@Override
	public boolean equals(Object o) {
		Purchase other = (Purchase) o;
		
		return date.equals(other.date) && 
				description.equals(other.description) && 
				amount == other.amount;
	}


	/**
	 * Compares first by date (earlier dates first), then by amount (higher amounts
	 * first), then by description (lexicographically)
	 */
	public int compareTo(Purchase other) {
		if (date.compareTo(other.date) < 0) return -1;
		else if (date.compareTo(other.date) > 0) return 1;
		
		// dates are equal so compare amounts
		if (amount > other.amount) return -1; 
		else if (amount < other.amount) return 1;
		
		// amounts are equal so compare descriptions
		return description.compareTo(other.description);
	}

}