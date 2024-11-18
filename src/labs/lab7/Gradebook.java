package labs.lab7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A program to add, remove, modify or print student names and grades.
 */
public class Gradebook {

	private Map<String, String> grades; // maps names to grades

	public Gradebook() {
		grades = new HashMap<>();
	}


	/**
	 * Adds a new entry. If the name already exists in the gradebook, overwrites the
	 * old grade with the new one.
	 * 
	 * @param name  student name
	 * @param grade student grade
	 */
	public void addEntry(String name, String grade) {
		grades.put(name, grade);
	}


	/**
	 * Removes the entry for the given name if it exists
	 * 
	 * @param name student name to remove
	 */
	public void removeEntry(String name) {
		grades.remove(name);
	}


	/**
	 * Modifies the entry for the given name if it exists
	 * 
	 * @param name  student name
	 * @param grade new grade
	 */
	public void modifyEntry(String name, String grade) {
		if (grades.containsKey(name))
			grades.put(name, grade);
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
		String[] returnMe = new String[grades.size()];
		
		if (returnMe.length == 0)
			return returnMe;
		
		Set<String> keySet = grades.keySet();
		
		int index = 0;
		
		for (String key : keySet)
		{
			String studentRecord = key + " " + grades.get(key);
			
			returnMe[index++] = studentRecord;
		}
		
		// sort array and return
		Arrays.sort(returnMe);
		
		return returnMe;
	}

}