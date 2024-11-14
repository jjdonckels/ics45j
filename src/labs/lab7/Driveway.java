package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
	private Stack<Integer> driveway; // represents cars in the driveway
	private Stack<Integer> street; // represents cars on the street

	/**
	 * Constructor
	 */
	public Driveway() {
		// FILL IN
	}

	
	/**
	 * Returns a String representation of the driveway. For a driveway stack
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string
	 * returned by this method would be: "Driveway: 1 2 3 4"
	 * 
	 * @return	a String representation of this driveway
	 */
	public String getDriveway() {
		return ""; // FIX ME
	}

	
	/**
	 * Returns a String representation of the street. For a street stack 
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string 
	 * returned by this method would be: "Street: 1 2 3 4"
	 * 
	 * @return	a String representation of the street
	 */
	public String getStreet() {
		return ""; // FIX ME
	}

	
	/**
	 * Adds the given license plate to the driveway if it's not already in the
	 * driveway. Returns a log of the process.
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> add(int licensePlate) {
		return new ArrayList<String>(); // FIX ME
	}

	/**
	 * Remove the given license plate from the driveway if it's in the driveway.
	 * Returns a log of the process
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> remove(int licensePlate) {
		return new ArrayList<String>(); // FIX ME
	}
}
