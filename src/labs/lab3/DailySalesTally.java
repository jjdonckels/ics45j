package labs.lab3;

import java.util.ArrayList;

public class DailySalesTally {

	private ArrayList<Purchase> salesList;
	private ArrayList<String> clientList;
	private final double BOUTIQUE_DISCOUNT = 0.05;
	private final double LOYALTY_DISCOUNT = 0.1;
	

	public DailySalesTally() {
		salesList = new ArrayList<Purchase>();
		clientList = new ArrayList<String>();
	}


	/**
	 * Adds a purchase to the tally
	 * 
	 * @param p	the purchase
	 */
	public void addPurchase(Purchase p) {
		salesList.add(p);
		
		// if client is not already in client list, add the client to the list
		if (clientList.size() > 0)
		{
			for (int i = 0; i < clientList.size(); ++i)
			{
				if (clientList.get(i).equals(p.getClientName()))
					return;
			}
		}
		clientList.add(p.getClientName()); // add name to list if not already found there
	}
	
	
	/**
	 * Calculates the total for the day for the client with the given name
	 * 
	 * @param clientName	name of the client for whom to calculate the total
	 * @return				total for the given client
	 */
	public double getTotalForClient(String clientName) {
		double total = 0;
		boolean firstPurchase = true;
		
		// go through each sale in the list and add to the total each time 
		// one of the sales is for the desired client,
		// while also applying appropriate discounts 
		// for loyalty and boutique
		for (int i = 0; i < salesList.size(); ++i)
		{
			if (salesList.get(i).getClientName().equals(clientName))
			{
				double currPrice = salesList.get(i).getPrice();
				
				// check for boutique discount
				if (salesList.get(i).isBoutiquePurchase())
					currPrice *= (1.0 - BOUTIQUE_DISCOUNT);
				
				// check for loyalty discount by seeing if client name is in list
				// and if the first purchase has been logged yet
				boolean found = false;
				for (int k = 0; k < clientList.size(); ++k)
				{
					if (clientList.get(k).equals(clientName))
					{
						found = true;
						break;
					}
				}
				if (found && !firstPurchase)
					currPrice *= (1 - LOYALTY_DISCOUNT);
				else 
					firstPurchase = false;
				
				// any discounts have been applied, so now we can add to total
				total += currPrice;
			}
		}
		
		return total;
	}


	/**
	 * Calculates the grand total for the day for all purchases
	 * 
	 * @return	the grand total for the day for all purchases
	 */
	public double getGrandTotal() {
		double total = 0;
		for (int i = 0; i < clientList.size(); ++i)
		{
			total += getTotalForClient(clientList.get(i));
		}
		
		return total;
	}
}