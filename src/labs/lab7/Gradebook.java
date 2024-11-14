package labs.lab7;

import java.util.Map;

/**
 * A program to add, remove, modify or print student names and grades.
 */
public class Gradebook {

	private Map<String, String> grades; // maps names to grades

	public Gradebook() {
		// FILL IN
	}


	/**
	 * Adds a new entry. If the name already exists in the gradebook, overwrites the
	 * old grade with the new one.
	 * 
	 * @param name  student name
	 * @param grade student grade
	 */
	public void addEntry(String name, String grade) {
		// FILL IN
	}


	/**
	 * Removes the entry for the given name if it exists
	 * 
	 * @param name student name to remove
	 */
	public void removeEntry(String name) {
		// FILL IN
	}


	/**
	 * Modifies the entry for the given name if it exists
	 * 
	 * @param name  student name
	 * @param grade new grade
	 */
	public void modifyEntry(String name, String grade) {
		// FILL IN
	}


	/**
	 * Returns an array of strings representing the gradebook, with
	 * each string in this format: [NAME] [GRADE]
	 * 
	 * The array must be sorted by name.
	 * 
	 * @return	an array of strings representing the gradebook
	 */
	public String[] getEntries() {
		return null; // FILL IN
	}

}