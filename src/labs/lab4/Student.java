package labs.lab4;

/**
 * Represents a student and their relevant info
 */
public class Student {
	// ADD YOUR INSTANCE VARIABLES HERE
	
	
	/**
	 * Constructs a Student object with the given name, an automatically assigned ID,
	 * a GPA of 0.0, and an honors status of false
	 * 
	 * @param name	student name
	 */
	public Student(String name) {
		// FILL IN
	}
	
	
	/**
	 * Returns the student name
	 * 
	 * @return	student name
	 */
	public String getName() {
		return ""; // FIX ME
	}
	
	
	/**
	 * Sets the name to the given name, as long as the given name is not an empty string
	 * 
	 * @param name	new name
	 */
	public void setName(String name) {
		// FILL IN
	}
	
	/**
	 * Returns the student ID
	 * 
	 * @return	student ID
	 */
	public int getId() {
		return -1; // FIX ME
	}
	
	
	/**
	 * Returns the student GPA
	 * 
	 * @return	student GPA
	 */
	public double getGPA() {
		return -1.0; // FIX ME
	}
	
	
	/**
	 * Sets the GPA to the given GPA, as long as the given GPA is between 0.0 and 4.0,
	 * inclusive
	 * 
	 * @param gpa	new GPA
	 */
	public void setGPA(double gpa) {
		// FILL IN
	}
	
	
	/**
	 * Returns true if student's GPA is at least 3.5, false otherwise
	 * 
	 * @return	whether or not this student is an honors student
	 */
	public boolean isHonorsStudent() {
		return false; // FIX ME
	}
}