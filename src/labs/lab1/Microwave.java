package labs.lab1;

/**
 * A class for representing a microwave oven.
 */
public class Microwave {

	private int time;
	private int powerLevel;

	/**
	 * Creates a microwave with 0 seconds on the timer and at power level 1
	 */
	public Microwave() {
		time = 0;
		powerLevel = 1;
	}

	/**
	 * Increases the time on the timer by 30 seconds
	 */
	public void increaseTime() {
		int timeToAdd = 30;
		time += timeToAdd;
	}

	/**
	 * Switches the power level from 1 to 2, or vice versa
	 */
	public void switchPower() {
		if (powerLevel == 1)
			powerLevel = 2;
		else if (powerLevel == 2)
			powerLevel = 1;
		else 
			powerLevel = -1;
	}

	/**
	 * Resets the microwave to its initial state.
	 */
	public void reset() {
		time = 0;
		powerLevel = 1;
	}

	/**
	 * Starts the machine, and returns information about its cooking state
	 * 
	 * @return	a message containing information about its cooking state ("Cooking 
	 * for ... seconds at level ...")
	 */
	public String start() {
		return "Cooking for " + time + " seconds at level " + powerLevel;
	}

}
