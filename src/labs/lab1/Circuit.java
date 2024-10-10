package labs.lab1;

/**
 * This class models the circuit for a hallway light.
 */
public class Circuit {

	private int switch1;
	private int switch2;
	private int lightOn;
	
	public Circuit()
	{
		switch1 = 0;
		switch2 = 0;
		lightOn = 0;
	}

	/**
	 * Gets the current state of the indicated switch
	 * 
	 * @param switchNum the number of the switch (1 or 2)
	 * @return the state of the indicated switch (0 = down, 1 = up)
	 */
	public int getSwitchState(int switchNum) {
		// validate switchNum
		if (switchNum != 1 && switchNum != 2)
			return -1;
		
		if (switchNum == 1)
			return switch1;
		else 
			return switch2;
	}


	/**
	 * Gets the current state of the hallway lamp.
	 * 
	 * @return the state of the lamp (0 = off, 1 = on)
	 */
	public int getLampState() {
		return lightOn;
	}


	/**
	 * Changes the indicated switch from up to down, or vice versa. Toggling the
	 * switch also changes the state of the lamp.
	 * 
	 * @param switch the number of the switch (1 or 2)
	 */
	public void toggleSwitch(int switchNum) {
		if (switchNum == 1)
			switch1 = (switch1 + 1) % 2;
		else if (switchNum == 2)
			switch2 = (switch2 + 1) % 2;
		
		if (switchNum == 1 || switchNum == 2)
			lightOn = (lightOn + 1) % 2;
	}
}
