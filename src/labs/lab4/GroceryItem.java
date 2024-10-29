package labs.lab4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Represents a perishable, edible item with an expiration date
 */
public class GroceryItem extends MerchandiseItem {

	private String expirationDate;
	
	private static final int SHIPPING_TIME = 1;

	/**
	 * Constructor
	 * 
	 * @param name           name of item
	 * @param price          price of item
	 * @param expirationDate expiration date of item, in the format YYYY-MM-DD
	 */
	public GroceryItem(String name, double price, String expirationDate) {
		super(name, price);
		this.expirationDate = expirationDate;
	}


	/**
	 * Returns the expiration date, in the format YYYY-MM-DD
	 * 
	 * @return the expiration date, in the format YYYY-MM-DD
	 */
	public String getExpirationDate() {
		return expirationDate;
	}


	/**
	 * Sets the expiration date
	 * 
	 * @param s new expiration date, in the format YYYY-MM-DD
	 */
	public void setExpirationDate(String s) {
		expirationDate = s;
	}


	@Override
	public String purchase(String purchaseDate) {
		LocalDate tempDate = LocalDate.parse(purchaseDate);
		
		// advance by the appropriate number of business days
		for (int i = 1; i <= SHIPPING_TIME; ++i)
		{
			tempDate = tempDate.plusDays(1);
			// advance past any weekends
			if (tempDate.getDayOfWeek() == DayOfWeek.SATURDAY)
				tempDate = tempDate.plusDays(2);
			else if (tempDate.getDayOfWeek() == DayOfWeek.SUNDAY)
				tempDate = tempDate.plusDays(1);
		}
		
		return tempDate.toString();
	}


	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof GroceryItem)
		{
			GroceryItem other = (GroceryItem) otherObject;
			return super.equals(other) && expirationDate.equals(other.expirationDate);
		}
		return false;
	}


	@Override
	public String toString() {
		return super.toString() + ", expiration date: " + expirationDate;
	}

}