package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;


public class StudentTest {
	
	/**
	 * Tests that the constructor behaves as specified
	 */
	@Test
    public void testConstructor() {
		Student s1 = new Student("Jack");
		assertEquals(true, s1.getName().equals("Jack"));
		
		Student s2 = new Student("Jill");
		assertEquals(true, s2.getName().equals("Jill"));
    }

	
	/**
	 * Tests the getting and setting of the name field
	 */
	@Test
    public void testName() {
		Student s1 = new Student("Timothy");
		
		assertEquals(true, s1.getName().equals("Timothy"));
		
		s1.setName("Amanda");
		assertEquals(true, s1.getName().equals("Amanda"));
		
		s1.setName("");
		assertEquals(true, s1.getName().equals("Amanda"));
    }
	
	
	/**
	 * Tests the id generation/setting and getting the id
	 */
	@Test
    public void testId() {
		Student s1 = new Student("John");
		
		int prevId = s1.getId();
		
		Student s2 = new Student("Jacob");
		
		assertEquals(prevId + 1, s2.getId());
		
		prevId = s2.getId();
		
		Student s3 = new Student("Jamie");
		
		assertEquals(prevId + 1, s3.getId());
    }
	
	
	/**
	 * Tests the getting and setting of the GPA field
	 */
	@Test
    public void testGPA() {
		Student s1 = new Student("Rain man");
		
		assertEquals(true, s1.getGPA() == 0);
		
		s1.setGPA(3.3);
		
		assertEquals(true, s1.getGPA() == 3.3);
		
		s1.setGPA(7.3);
		
		assertEquals(true, s1.getGPA() == 3.3);
		
		s1.setGPA(4.0);
		
		assertEquals(true, s1.getGPA() == 4.0);
    }
	
	
	/**
	 * Tests the getting and setting of the honors status
	 */
	@Test
    public void testHonors() {
		Student s1 = new Student("Sheldon");
		
		s1.setGPA(3.4);
		assertEquals(false, s1.isHonorsStudent());
		
		s1.setGPA(3.5);
		assertEquals(true, s1.isHonorsStudent());
		
		s1.setGPA(4.0);
		assertEquals(true, s1.isHonorsStudent());
		
		s1.setGPA(2.0);
		assertEquals(false, s1.isHonorsStudent());
    }
}
