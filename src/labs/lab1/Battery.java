package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	private double maxCap;
	private double currCap;

	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
		maxCap = capacity;
		currCap = capacity;
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
		currCap -= amount;
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
		currCap = maxCap;
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
		return currCap;
	}
}
