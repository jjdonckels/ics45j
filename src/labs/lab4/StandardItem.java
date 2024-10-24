package labs.lab4;

/**
 * Represents a non-grocery and non-digital item in the online store
 */
public class StandardItem extends MerchandiseItem {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructor
	 * 
	 * @param name        item name
	 * @param price       item price
	 * @param description item description
	 */
	public StandardItem(String name, double price, String description) {
		super(name, price);
		// FILL IN
	}


	/**
	 * Returns item's description
	 * 
	 * @return item's description
	 */
	public String getDescription() {
		return ""; // FIX ME
	}


	/**
	 * Sets item's description
	 * 
	 * @param s new description
	 */
	public void setDescription(String s) {
		// FILL IN
	}


	@Override
	public String purchase(String purchaseDate) {
		return ""; // FIX ME
	}


	@Override
	public String toString() {
		return ""; // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		return false; // FIX ME
	}

}