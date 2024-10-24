package labs.lab4;

import java.time.LocalDate;

/**
 * Represents a perishable, edible item with an expiration date
 */
public class GroceryItem extends MerchandiseItem {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructor
	 * 
	 * @param name           name of item
	 * @param price          price of item
	 * @param expirationDate expiration date of item, in the format YYYY-MM-DD
	 */
	public GroceryItem(String name, double price, String expirationDate) {
		super(name, price);
		// FILL IN
	}


	/**
	 * Returns the expiration date, in the format YYYY-MM-DD
	 * 
	 * @return the expiration date, in the format YYYY-MM-DD
	 */
	public String getExpirationDate() {
		return ""; // FIX ME
	}


	/**
	 * Sets the expiration date
	 * 
	 * @param s new expiration date, in the format YYYY-MM-DD
	 */
	public void setExpirationDate(String s) {
		// FILL IN
	}


	@Override
	public String purchase(String purchaseDate) {
		return ""; // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		return false; // FIX ME
	}


	@Override
	public String toString() {
		return ""; // FIX ME
	}

}