package labs.lab7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for simulating a queue for a theme park attraction.
 */
public class ThemeParkQueue {

	private Queue<String> premium;
	private Queue<String> standard;

	/**
	 * Constructor
	 */
	public ThemeParkQueue() {
		premium = new LinkedList<String>();
		standard = new LinkedList<String>();
	}


	/**
	 * Adds a person to the standard line
	 * 
	 * @param guestName name of the guest
	 */
	public void addStandardGuest(String guestName) {
		standard.add(guestName);
	}


	/**
	 * Adds a person to the premium line
	 * 
	 * @param guestName name of the guest
	 */
	public void addPremiumGuest(String guestName) {
		premium.add(guestName);
	}


	/**
	 * Handles the next action and returns a string indicating what that next action
	 * is, in the format: "[GUEST_NAME] entering from [PREMIUM/STANDARD] line"
	 * 
	 * @return a string indicating the next action
	 */
	public String handleNextAction() {
		// premium line gets priority
		if (premium.size() > 0)
		{
			String name = premium.remove();
			
			return name + " entering from premium line";
		}
		else if (standard.size() > 0)
		{
			String name = standard.remove();
			
			return name + " entering from standard line";
		}
		
		return "";
	}

}
