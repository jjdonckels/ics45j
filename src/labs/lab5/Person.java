package labs.lab5;

public abstract class Person implements Comparable {

	private String name;
	private int age;

	/**
	 * 
	 * @param name no validity checks necessary -- assume all valid input
	 * @param age  no validity checks necessary -- assume all valid input
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	/**
	 * compares first by name (use String.compareTo), then by age
	 */
	@Override
	public int compareTo(Object otherPerson) {
		Person other = (Person) otherPerson;
		int stringComp = name.compareTo(other.name);
		if (stringComp != 0)
			return stringComp;
		
		// at this point we compare by age
		if (age < other.age)
			return -1;
		else if (age > other.age)
			return 1;
		return 0;
	}


	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}

}