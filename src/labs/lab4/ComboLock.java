package labs.lab4;

/**
 * A class to simulate a combination lock.
 */
public class ComboLock {
	private int n1;
	private int n2;
	private int n3;
	private int currNum;
	private int prevTurnDirection;
	private boolean correctCombo;
	private boolean isUnlocked;
	
	private static final int RIGHT = 1;
	private static final int LEFT = -1;
	private static final int MAX = 40;

	/**
	 * Initializes the combination of the lock. Assume all inputs are valid ints
	 * between 0 and 39 inclusive
	 * 
	 * @param num1 first number to turn right to
	 * @param num2 second number to turn left to
	 * @param num3 third number to turn right to
	 */
	public ComboLock(int num1, int num2, int num3) {
		n1 = num1;
		n2 = num2;
		n3 = num3;
		currNum = 0;
		prevTurnDirection = 0;
		correctCombo = false;
		isUnlocked = false;
	}

	/**
	 * Resets the state of the lock so that it can be opened again; resets the
	 * dial so that it points to 0
	 */
	public void reset() {
		currNum = 0;
		prevTurnDirection = 0;
		correctCombo = false;
		isUnlocked = false;
		
	}

	/**
	 * Turns lock left given number of ticks.
	 * 
	 * @param ticks number of ticks to turn left; assume ticks always between 0 
	 * and 39 inclusive
	 */
	public void turnLeft(int ticks) {
		// turning left advances numbers forward
		currNum += ticks; // move lock by given amount of ticks
		currNum %= MAX; // put currNum back in correct combo lock range 
		
		if (prevTurnDirection == RIGHT && correctCombo && currNum == n2)
			correctCombo = true;
		else 
			correctCombo = false;
		
		prevTurnDirection = LEFT;
	}

	/**
	 * Turns lock right given number of ticks
	 * 
	 * @param ticks number of ticks to turn right; assume ticks always between 0
	 * and 39 inclusive
	 */
	public void turnRight(int ticks) {
		// turning right moves numbers backward
		currNum -= ticks; 
		
		// account for currNum going negative but keeping the real range between 0 and MAX - 1
		while (currNum < 0)
			currNum = MAX + currNum;
		
		if (!correctCombo && currNum == n1)
		{
			// this starts the correct combo
			correctCombo = true;
		}
		else if (correctCombo && prevTurnDirection == LEFT && currNum == n3)
		{
			// this branch is for when the third and last number of the combo lock
			// is reached with the right sequence of turns
			correctCombo = false; // this resets back to the beginning after successfully inputting the correct combo
			isUnlocked = true;
		}
		
		prevTurnDirection = RIGHT;
	}

	/**
	 * Returns true if the lock can be opened now, false otherwise
	 * 
	 * @return true if lock is in open state
	 */
	public boolean open() {
		return isUnlocked;
	}
}
