package labs.lab5;

/**
 * Test class for Comparable Student objects.
 */
public class StudentFinder {

	/**
	 * Determines first student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return first Student
	 */
	public static Student firstStudent(Student[] students) {
		// return minimum student
		int minIndex = 0;
		
		for (int i = 1; i < students.length; i++)
		{
			if (students[i].compareTo(students[minIndex]) < 0)
				minIndex = i;
		}
		
		return students[minIndex];
	}


	/**
	 * Determines last student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return last Student
	 */
	public static Student lastStudent(Student[] students) {
		// return maximum student
		int maxIndex = 0;
		for (int i = 1; i < students.length; i++)
		{
			if (students[i].compareTo(students[maxIndex]) > 0)
				maxIndex = i;
		}
		
		return students[maxIndex];
	}

}
