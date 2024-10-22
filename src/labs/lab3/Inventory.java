package labs.lab3;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList;
	
	
	/**
	 * Constructs a new Inventory
	 */
	public Inventory() {
		itemList = new ArrayList<Item>();
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
		boolean itemExists = false;
		int itemIndex = -1;
		
		// loop through item list and see if it exists
		for (int i = 0; i < itemList.size(); ++i)
		{
			if (itemList.get(i).getDescription().equals(item.getDescription()))
			{
				itemExists = true;
				itemIndex = i;
				break;
			}
		}
		
		// item doesn't already exist and needs to be added
		if (!itemExists)
			itemList.add(item);
		else  // item already exists so it just gets updated
		{
			itemList.get(itemIndex).setCurrentStock(item.getCurrentStock());
			itemList.get(itemIndex).setTargetStock(item.getTargetStock());
		}
	}
	
	
	/**
	 * Removes item with the given description, if it exists
	 * 
	 * @param description	description of item to remove
	 */
	public void removeItemWithDescription(String description) {
		
		// loop through item list and remove it if it exists
		for (int i = 0; i < itemList.size(); ++i)
		{
			if (itemList.get(i).getDescription().equals(description))
			{
				itemList.remove(i);
				return;
			}
		}
		
		return;
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
		String returnMe = "";
		
		// go through inventory and see what's understocked
		for (int i = 0; i < itemList.size(); ++i)
		{
			int stockDifference = itemList.get(i).getTargetStock() - itemList.get(i).getCurrentStock();
			if (stockDifference > 0)
			{
				returnMe += "Order " + stockDifference + " more of " + 
							itemList.get(i).getDescription() + " | ";
			}
		}
		
		if (returnMe.isEmpty())
			return "No items under-stocked";
		else 
			return returnMe.substring(0, returnMe.length() - 3);
		// returns everything but last 3 characters which would be " | " and isn't needed at the end
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
		String returnMe = "";
		
		// go through inventory and see what's overstocked
		for (int i = 0; i < itemList.size(); ++i)
		{
			int stockDifference = itemList.get(i).getCurrentStock() - itemList.get(i).getTargetStock();
			if (stockDifference > 0)
			{
				returnMe += itemList.get(i).getDescription() + " over-stocked by " + 
							stockDifference + " items | ";
			}
		}
		
		if (returnMe.isEmpty())
			return "No items over-stocked";
		else 
			return returnMe.substring(0, returnMe.length() - 3);
		// returns everything but last 3 characters which would be " | " and isn't needed at the end
	}
}