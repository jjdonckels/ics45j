package labs.lab4;

import java.util.UUID;

/**
 * Represents an abstract item in an online store
 */
public abstract class MerchandiseItem {

	/* 
	 * Note: UUID is a Java utility class that represents an immutable universally unique identifier
	 * See the Javadocs for more info
	 */
	private UUID id;
	private String name;
	private double price;

	
	/**
	 * Constructor
	 * 
	 * @param name	name of item
	 * @param price	price of item
	 */
	public MerchandiseItem(String name, double price) {
		id = UUID.randomUUID();
		this.name = name;
		this.price = price;
	}


	/**
	 * Returns the ID of the item
	 * 
	 * @return	the ID of the item
	 */
	public UUID getID() {
		return id;
	}


	/**
	 * Returns the name of the item
	 * 
	 * @return	the name of the item
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name of the item
	 * 
	 * @param s	new name
	 */
	public void setName(String s) {
		name = s;
	}


	/**
	 * Returns the price of the item
	 * 
	 * @return	price of the item
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * Sets the price of the item
	 * 
	 * @param d	price of the item
	 */
	public void setPrice(double d) {
		price = d;
	}


	/**
	 * Causes this item to be purchased
	 * 
	 * @param purchaseDate	date of purchase, in the format YYYY-MM-DD
	 * 
	 * @return	a string containing the date you will get your item in the format YYYY-MM-DD
	 */
	public abstract String purchase(String purchaseDate);
}