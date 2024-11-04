package labs.lab5;

/**
 * This class represents a student with a name and ID.
 */
public class Student implements Comparable {

	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Constructs a student object
	 * 
	 * @param name the student's name
	 * @param id   the student's id
	 */
	public Student(String name, int id) {
		// FILL IN
	}


	/**
	 * Gets the student's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return ""; // FIX ME
	}


	/**
	 * Gets the student's id
	 * 
	 * @return the name
	 */
	public int getId() {
		return -1; // FIX ME
	}


	@Override
	public String toString() {
		return ""; // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		return false; // FIX ME
	}


	/**
	 * Compares student objects first by name, then by id
	 * 
	 * @param other Other student against which to compare
	 * @return negative int if this students comes before, 0 if equal, positive int
	 *         if this student comes after
	 */
	public int compareTo(Object other) {
		return -1; // FIX ME
	}

}
