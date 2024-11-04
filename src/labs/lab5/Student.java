package labs.lab5;

/**
 * This class represents a student with a name and ID.
 */
public class Student implements Comparable {

	private String name;
	private int id;

	/**
	 * Constructs a student object
	 * 
	 * @param name the student's name
	 * @param id   the student's id
	 */
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}


	/**
	 * Gets the student's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets the student's id
	 * 
	 * @return the name
	 */
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return name + ", " + id;
	}


	@Override
	public boolean equals(Object otherObject) {
		Student other = (Student) otherObject;
		
		return name.equals(other.name) && id == other.id; 
	}


	/**
	 * Compares student objects first by name, then by id
	 * 
	 * @param other Other student against which to compare
	 * @return negative int if this students comes before, 0 if equal, positive int
	 *         if this student comes after
	 */
	public int compareTo(Object other) {
		Student rhs = (Student) other;
		
		int nameComp = name.compareTo(rhs.name);
		
//		DEBUG
//		System.out.println("Comparing " + name + " and " + rhs.name);
//		System.out.println("name comparison: " + nameComp + "\n");
		
		if (nameComp != 0)
			return nameComp;
		
		// if we get here the names are equal and we need to compare id numbers
		if (id < rhs.id)
			return -1;
		else if (id > rhs.id)
			return 1;
		return 0;
	}

}
