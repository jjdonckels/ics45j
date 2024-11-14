package labs.lab7;

/**
 * Class representing a patient in a hospital emergency room
 */
public class Patient implements Comparable<Patient> {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Creates a new Patient object with the given injury and description
	 */
	public Patient(Injury injury, String description) {
		// FILL IN
	}


	public int getPriority() {
		return -1; // FIX ME
	}


	public Injury getInjury() {
		return Injury.SEIZURE; // FIX ME
	}


	public String getDescription() {
		return ""; // FIX ME
	}


	/**
	 * Compares patients by priority
	 */
	@Override
	public int compareTo(Patient p) {
		return -1; // FIX ME
	}
	
	
	/**
	 * Returns a string representation of this patient in the format:
	 * "Injury: [INJURY], Description: [DESCRIPTION]"
	 */
	@Override
	public String toString() {
		return ""; // FIX ME
	}

}