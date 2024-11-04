package labs.lab5;

public abstract class Person implements Comparable {

	// ADD INSTANCE VARIABLES HERE

	/**
	 * 
	 * @param name no validity checks necessary -- assume all valid input
	 * @param age  no validity checks necessary -- assume all valid input
	 */
	public Person(String name, int age) {
		// FILL IN
	}


	public String getName() {
		return ""; // FIX ME
	}


	public int getAge() {
		return -1; // FIX ME
	}


	/**
	 * compares first by name (use String.compareTo), then by age
	 */
	@Override
	public int compareTo(Object otherPerson) {
		return -1; // FIX ME
	}


	@Override
	public String toString() {
		return ""; // FIX ME
	}

}