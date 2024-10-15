package labs.lab3;

public class Inventory {
	// ADD YOUR INSTANCE VARIABLES HERE
	
	
	/**
	 * Constructs a new Inventory
	 */
	public Inventory() {
		// FILL IN
	}
	
	
	/**
	 * If an item with the given item's description does not already exist
	 * in the inventory, adds that item to the inventory. If an item with
	 * the given item's description does exist, updates that item with 
	 * the given item's values.
	 * 
	 * @param item	item to add/update
	 */
	public void addOrUpdateItem(Item item) {
		// FILL IN
	}
	
	
	/**
	 * Removes item with the given description, if it exists
	 * 
	 * @param description	description of item to remove
	 */
	public void removeItemWithDescription(String description) {
		// FILL IN
	}
	
	
	/**
	 * Returns a report of items that are under-stocked (items whose
	 * current stock is less than their target stock)
	 * 
	 * @return	a string that reports which items need to be ordered
	 * and how many of each. If no items are under-stocked, report reads
	 * "No items under-stocked".
	 */
	public String getUnderstockReport() {
		return ""; // FIX ME
	}
	
	
	/**
	 * Returns a report of items that are over-stocked (items whose
	 * current stock is more than their target stock)
	 * 
	 * @return	a string that reports which items are overstocked and
	 * by how much. If no items are over-stocked, report reads
	 * "No items over-stocked".
	 */
	public String getOverstockReport() {
		return ""; // FIX ME
	}
}