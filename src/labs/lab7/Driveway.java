package labs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
	private Stack<Integer> driveway; // represents cars in the driveway
	private Stack<Integer> street; // represents cars on the street
	
	private Map<Integer, Boolean> inDriveway;

	/**
	 * Constructor
	 */
	public Driveway() {
		driveway = new Stack<>();
		street = new Stack<>();
		inDriveway = new HashMap<>();
	}

	
	/**
	 * Returns a String representation of the driveway. For a driveway stack
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string
	 * returned by this method would be: "Driveway: 1 2 3 4"
	 * 
	 * @return	a String representation of this driveway
	 */
	public String getDriveway() {
		String returnMe = "Driveway:";
		
		if (driveway.size() == 0)
		{
			returnMe += " ";
			return returnMe;
		}
		
		ArrayList<Integer> temp = new ArrayList<>();
		while (driveway.size() > 0) 
			temp.add(driveway.pop());
		
		// go backwards through array list adding cars to the string
		for (int i = temp.size() - 1; i >= 0; --i)
		{
			returnMe += " " + temp.get(i); 
		}
		
		// put each element back in the stack from the array list from back to front
		while (temp.size() > 0)
			driveway.push(temp.remove(temp.size() - 1));
		
		return returnMe;
	}

	
	/**
	 * Returns a String representation of the street. For a street stack 
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string 
	 * returned by this method would be: "Street: 1 2 3 4"
	 * 
	 * @return	a String representation of the street
	 */
	public String getStreet() {
		String returnMe = "Street:";
		
		if (street.size() == 0)
		{
			returnMe += " ";
			return returnMe;
		}
		
		ArrayList<Integer> temp = new ArrayList<>();
		while (street.size() > 0) 
			temp.add(street.pop());
		
		// go backwards through array list adding cars to the string
		for (int i = temp.size() - 1; i >= 0; --i)
		{
			returnMe += " " + temp.get(i); 
		}
		
		// put each element back in the stack from the array list from back to front
		while (temp.size() > 0)
			street.push(temp.remove(temp.size() - 1));
		
		return returnMe;
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
		List<String> returnMe = new ArrayList<String>();
		
		// check if this car is already in driveway
		if (inDriveway.get(licensePlate) == null || !inDriveway.get(licensePlate))
		{
			// this branch is for when the car isn't already in the driveway and needs to be added
			inDriveway.put(licensePlate, true);
			driveway.push(licensePlate);
			
			returnMe.add(getDriveway());
			returnMe.add(getStreet());
		}
		else
		{
			// this is for when the car is already in the driveway
			returnMe.add("That car is already in the driveway.");
			
			// update driveway status
			inDriveway.put(licensePlate, true);
		}
		
		return returnMe;
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
		List<String> returnMe = new ArrayList<String>();
		
		// check if car is in driveway
		if (inDriveway.get(licensePlate) == true)
		{
			// branch for when car is in driveway and needs to be removed
			
			// check if car is at top of driveway stack
			if (driveway.peek() == licensePlate)
			{
				driveway.pop();
				inDriveway.put(licensePlate, false);
				
				returnMe.add(getDriveway());
				returnMe.add(getStreet());
				
				return returnMe;
			}
			
			// move cars from driveway to street until reaching the desired car
			while (driveway.peek() != licensePlate)
			{
				street.push(driveway.pop());
				
				returnMe.add(getDriveway());
				returnMe.add(getStreet());
			}
			
			// now desired car is at the top of the driveway stack, so we can pop it and remove it
			driveway.pop();
			
			// now put cars from street back in driveway
			while (street.size() > 0)
			{
				driveway.push(street.pop());
				
				returnMe.add(getDriveway());
				returnMe.add(getStreet());
			}
			
			// update driveway status
			inDriveway.put(licensePlate, false);
		}
		else 
		{
			// branch for when car isn't in driveway so nothing needs to be removed
			returnMe.add("That car is not in the driveway.");
			
		}
		
		return returnMe;
	}
}
