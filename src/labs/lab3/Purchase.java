package labs.lab3;

/**
 * Represents a purchase made in Robert's doggy spa/boutique
 */
public class Purchase {

	private String description;
	private String clientName;
	private double price;
	private boolean boutiquePurchase;

	
	/**
	 * Constructs a new Purchase
	 * 
	 * @param description		description of the purchase
	 * @param clientName		name of client who made the purchase
	 * @param price				price of the purchase
	 * @param boutiquePurchase	whether or not this was a boutique purchase
	 */
	public Purchase(String description, String clientName, double price, boolean boutiquePurchase) {
		this.description = description;
		this.clientName = clientName;
		this.price = price;
		this.boutiquePurchase = boutiquePurchase;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public String getClientName() {
		return clientName;
	}


	public double getPrice() {
		return price;
	}


	public boolean isBoutiquePurchase() {
		return boutiquePurchase;
	}
}