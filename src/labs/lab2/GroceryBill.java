package labs.lab2;

public class GroceryBill {
	
	private double total;
	private double discount;
	
	public GroceryBill(double itemTotal) {
		total = itemTotal;
		
		if (total < 10)
			discount = 0;
		else if (total <= 60)
			discount = 5;
		else if (total <= 150)
			discount = 10;
		else if (total <= 210)
			discount = 15;
		else 
			discount = 20;
	}
	
	
	public double getDiscount() {
		return discount;
	}
	
	
	/**
	 * 
	 * @return	the amount owed, after applying:
	 * 1. Any discount
	 * 2. A 10% sales tax
	 */
	public double getAmountOwed() {
		double activeDiscount = (discount / 100.0) * total;
		double activeTotal = total - activeDiscount;
		return activeTotal * 1.1;
	}
}