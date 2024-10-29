package labs.lab4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Represents a non-grocery and non-digital item in the online store
 */
public class StandardItem extends MerchandiseItem {

	private String description;
	
	private static final int SHIPPING_TIME = 5;

	/**
	 * Constructor
	 * 
	 * @param name        item name
	 * @param price       item price
	 * @param description item description
	 */
	public StandardItem(String name, double price, String description) {
		super(name, price);
		this.description = description;
	}


	/**
	 * Returns item's description
	 * 
	 * @return item's description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Sets item's description
	 * 
	 * @param s new description
	 */
	public void setDescription(String s) {
		description = s;
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
	public String toString() {
		return super.toString() + ", description: " + description;
	}


	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof StandardItem)
		{
			StandardItem other = (StandardItem) otherObject;
			return super.equals(other) && description == other.description;
		}
		return false;
	}

}