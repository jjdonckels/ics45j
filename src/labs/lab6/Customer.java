package labs.lab6;

/**
 * A customer in a customer database
 */
public class Customer {

	private int id;
	private String name;
	private double balance;

	/**
	 * Constructs a customer with the given id, name, and with a zero balance
	 * 
	 * @param id   customer id
	 * @param name customer name
	 */
	public Customer(int id, String name) {
		if (id < 0)
			throw new IllegalArgumentException("Customer ID cannot be negative");
		this.id = id;
		
		if (name.isBlank())
			throw new IllegalArgumentException("Customer name cannot be blank");
		this.name = name;
		
		balance = 0;
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
		if (id < 0)
			throw new IllegalArgumentException("Customer ID cannot be negative");
		this.id = id;
		
		if (name.isBlank())
			throw new IllegalArgumentException("Customer name cannot be blank");
		this.name = name;
		
		if (balance < 0)
			throw new IllegalArgumentException("Customer balance cannot be negative");
		this.balance = balance;
	}
	
	
	public int getID() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}


	/**
	 * Gets the current customer balance
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	

	/**
	 * Adjusts customer balance by the given amount
	 * 
	 * @param amount the amount by which to adjust the balance
	 */
	public void adjustBalance(double amount) {
		if (balance + amount < 0)
			throw new IllegalArgumentException("Cannot adjust balance to negative amount");
		
		balance += amount;
	}
}
