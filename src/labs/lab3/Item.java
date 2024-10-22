package labs.lab3;

/**
 * Represents an item in the inventory
 */
public class Item {
	private String description;
	private int targetStock;
	private int currentStock;
	
	
	/**
	 * Constructs a new Item
	 * 
	 * @param description	string description of the item
	 * @param targetStock	how many of the item should be kept in stock
	 * @param currentStock	how many of the item is currently in stock
	 */
	public Item(String description, int targetStock, int currentStock) {
		this.description = description;
		this.targetStock = targetStock;
		this.currentStock = currentStock;
	}
	
	
	/**
	 * Returns a string description of the item
	 * 
	 * @return	a string description of the item
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * Returns how many of the item should be kept in stock
	 * 
	 * @return	how many of the item should be kept in stock
	 */
	public int getTargetStock() {
		return targetStock;
	}
	
	
	/**
	 * Returns how many of the item is currently in stock
	 * 
	 * @return	how many of the item is currently in stock
	 */
	public int getCurrentStock() {
		return currentStock;
	}
	
	
	/**
	 * Sets the target stock to a new amount
	 * 
	 * @param targetStock	how many of the item should be kept in stock
	 */
	public void setTargetStock(int targetStock) {
		this.targetStock = targetStock;
	}
	
	
	/**
	 * Sets the current stock to a new amount
	 * 
	 * @param currentStock	how many of the item is currently in stock
	 */
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
}