package labs.lab6;

/**
 * A customer in a customer database
 */
public class Customer {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a customer with the given id, name, and with a zero balance
	 * 
	 * @param id   customer id
	 * @param name customer name
	 */
	public Customer(int id, String name) {
		// FILL IN
	}


	/**
	 * Constructs a customer with the given id, name, and balance.
	 * 
	 * Note: For info on why you don't need to include a throws clause in the method
	 * declaration, it's because it throws an un-checked (runtime) exception. Only
	 * include a throws clause if it throws a checked exception. See
	 * https://stackoverflow.com/questions/4392446/when-to-use-throws-in-a-java-method-declaration
	 * 
	 * @param id      customer id
	 * @param name    customer name
	 * @param balance customer balance
	 */
	public Customer(int id, String name, double balance) {		
		// FILL IN
	}
	
	
	public int getID() {
		return -1; // FIX ME
	}
	
	
	public String getName() {
		return ""; // FIX ME
	}


	/**
	 * Gets the current customer balance
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return -1.0; // FIX ME
	}
	

	/**
	 * Adjusts customer balance by the given amount
	 * 
	 * @param amount the amount by which to adjust the balance
	 */
	public void adjustBalance(double amount) {
		// FILL IN
	}
}
