package labs.lab4;

/**
 * Represents a student and their relevant info
 */
public class Student {
	private static int idNum = 1;
	
	private int id;
	private String name;
	private double gpa;
	private boolean honors;
	
	
	/**
	 * Constructs a Student object with the given name, an automatically assigned ID,
	 * a GPA of 0.0, and an honors status of false
	 * 
	 * @param name	student name
	 */
	public Student(String name) {
		id = idNum++;
		this.name = name;
		gpa = 0.0;
		honors = false;
	}
	
	
	/**
	 * Returns the student name
	 * 
	 * @return	student name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Sets the name to the given name, as long as the given name is not an empty string
	 * 
	 * @param name	new name
	 */
	public void setName(String name) {
		if (!name.isEmpty())
			this.name = name;
	}
	
	/**
	 * Returns the student ID
	 * 
	 * @return	student ID
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Returns the student GPA
	 * 
	 * @return	student GPA
	 */
	public double getGPA() {
		return gpa;
	}
	
	
	/**
	 * Sets the GPA to the given GPA, as long as the given GPA is between 0.0 and 4.0,
	 * inclusive
	 * 
	 * @param gpa	new GPA
	 */
	public void setGPA(double gpa) {
		if (gpa >= 0 && gpa <= 4.0)
			this.gpa = gpa;
		else 
			return;
		
		// update honors status based on new gpa
		if (gpa >= 3.5)
			honors = true;
		else 
			honors = false;
	}
	
	
	/**
	 * Returns true if student's GPA is at least 3.5, false otherwise
	 * 
	 * @return	whether or not this student is an honors student
	 */
	public boolean isHonorsStudent() {
		return honors;
	}
}