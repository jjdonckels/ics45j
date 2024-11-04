package labs.lab4.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab4.*;

import java.awt.Point;

public class Lab4Test {
	private final double EPSILON = 1e-13;
	
	@Test
	public void problem1() {
		// Test case 1:
		Robot robot = new Robot();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());

		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(0, 1))); 
		assertEquals("N", robot.getDirection());
		
		robot.turnRight(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(2, 1))); 
		assertEquals("E", robot.getDirection());
		
		robot.turnRight(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(2, -1))); 
		assertEquals("S", robot.getDirection());
		
		robot.turnLeft();
		assertTrue(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(3, -1))); 
		assertEquals("E", robot.getDirection());
		
		robot.turnRight();
		robot.turnRight();
		robot.turnRight();
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(3, 9))); 
		assertEquals("N", robot.getDirection());
		

		// Test case 2:
		Robot robot2 = new Robot();
		assertTrue(robot2.move()); 
		robot2.turnLeft(); 
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertFalse(robot2.move());
		assertFalse(robot2.move());
		assertEquals(true, robot2.getLocation().equals(new Point(-7, 1))); 
		assertEquals("W", robot2.getDirection());
	}
	
	@Test
	public void problem3() {
		// Test case 1:
		Student robert = new Student("Robert Navarro");
		assertEquals(1, robert.getId());
		robert.setGPA(4.0);
		assertEquals(true, robert.isHonorsStudent());
		robert.setGPA(3.2);
		assertEquals(false, robert.isHonorsStudent());
		
		// Test case 2:
		Student emily = new Student("Emily Navarro");
		assertEquals(2, emily.getId());
		
		// Test case 3:
		Student george = new Student("George Glass");
		assertEquals(3, george.getId());
		
		// Test case 4:
		Student amy = new Student("Amy Krishna");
		assertEquals(4, amy.getId());
	}
	
	@Test
	public void problem5() {
//		ComboLock lock = new ComboLock(38, 14, 7);
//		lock.turnRight(2);
//		lock.turnLeft(16);
//		lock.turnRight(7);
//		assertTrue(lock.open());
//		lock.reset();
//		lock.turnRight(2);
//		lock.turnLeft(21);
//		lock.turnRight(7);
//		assertFalse(lock.open());
//		
//		ComboLock lock2 = new ComboLock(38, 14, 7);
//		lock2.turnRight(42);
//		lock2.turnLeft(56);
//		lock2.turnRight(87);
//		assertTrue(lock2.open());
//		lock2.reset();
//		lock2.turnRight(3);
//		lock2.turnLeft(23);
//		lock2.turnRight(44);
//		assertFalse(lock2.open());
//		lock2.reset();
//		lock2.turnLeft(3);
//		lock2.turnRight(5);
//		lock2.turnLeft(16);
//		lock2.turnRight(7);
//		assertTrue(lock2.open());
//		lock2.reset();
//		lock2.turnRight(2);
//		lock2.turnLeft(16);
//		lock2.turnRight(8);
//		assertFalse(lock2.open());
		
		
		// official grade test 5_5
		ComboLock lock = new ComboLock(39, 5, 37);
        lock.turnRight(1);
        lock.turnLeft(6);
        lock.turnRight(8);
        assertTrue(lock.open());
        lock.reset();
        lock.turnRight(1);
        assertFalse(lock.open());
        lock.reset();
        lock.turnRight(1);
        lock.turnLeft(6);
        lock.turnRight(8);
        assertTrue(lock.open());
		
	}
	
	@Test
	public void problem6() {
		BankAccount account = new BasicAccount(100.0);
		account.withdraw(80.00);
		assertEquals(20.0, account.getBalance(), EPSILON);
		account.withdraw(50.00);
		assertEquals(20.0, account.getBalance(), EPSILON);
	}
	
	@Test
	public void problems7Thru10() {
		MerchandiseItem item1 = new StandardItem("Running socks", 34.99, 
				"A pack of 12 white running socks, fits women's size 9-11");
		MerchandiseItem item2 = new GroceryItem("Bananas", 2.00, "2021-12-28");
		MerchandiseItem item3 = new DigitalItem("Big Java: Early Objects, 7th Edition by Cay Horstmann", 
				112.50, DigitalItem.Format.EBOOK);
		MerchandiseItem item4 = new DigitalItem("Big Java: Early Objects, 7th Edition by Cay Horstmann", 
				112.50, DigitalItem.Format.EBOOK);
		MerchandiseItem item5 = new DigitalItem("Clueless starring Alicia Silverstone", 6.99, 
				DigitalItem.Format.VIDEO);
		MerchandiseItem item6 = new DigitalItem("Under Pressure by David Bowie", 0.99, 
				DigitalItem.Format.AUDIO);
		MerchandiseItem item7 = new StandardItem("AirPod Pros", 189.98, 
				"Apple AirPods Pro wireless ear buds");
		
		assertEquals(item1, item1);
		assertNotEquals(item3, item4);
		
		MerchandiseItem[] items = {item1, item2, item3, item4, item5, item6, item7};
		
		String[] stringReps = {
				", name: Running socks, price: 34.99, description: A pack of 12 white running socks, fits women's size 9-11",
				", name: Bananas, price: 2.0, expiration date: 2021-12-28",
				", name: Big Java: Early Objects, 7th Edition by Cay Horstmann, price: 112.5, format: EBOOK",
				", name: Big Java: Early Objects, 7th Edition by Cay Horstmann, price: 112.5, format: EBOOK",
				", name: Clueless starring Alicia Silverstone, price: 6.99, format: VIDEO",
				", name: Under Pressure by David Bowie, price: 0.99, format: AUDIO",
				", name: AirPod Pros, price: 189.98, description: Apple AirPods Pro wireless ear buds" 
				};
		
		String[] shipDatesSun = {
				"2021-09-03",
				"2021-08-30",
				"2021-08-29",
				"2021-08-29",
				"2021-08-29",
				"2021-08-29",
				"2021-09-03"
				};
		
		String[] shipDatesMon = {
				"2021-09-06",
				"2021-08-31",
				"2021-08-30",
				"2021-08-30",
				"2021-08-30",
				"2021-08-30",
				"2021-09-06"
				};
		
		String[] shipDatesTues = {
				"2021-09-07",
				"2021-09-01",
				"2021-08-31",
				"2021-08-31",
				"2021-08-31",
				"2021-08-31",
				"2021-09-07"
				};
		
		String[] shipDatesWed = {
				"2021-09-08",
				"2021-09-02",
				"2021-09-01",
				"2021-09-01",
				"2021-09-01",
				"2021-09-01",
				"2021-09-08"
				};
		
		String[] shipDatesThurs = {
				"2021-09-09",
				"2021-09-03",
				"2021-09-02",
				"2021-09-02",
				"2021-09-02",
				"2021-09-02",
				"2021-09-09"
				};
		
		String[] shipDatesFri = {
				"2021-09-10",
				"2021-09-06",
				"2021-09-03",
				"2021-09-03",
				"2021-09-03",
				"2021-09-03",
				"2021-09-10"
				};
		
		String[] shipDatesSat = {
				"2021-09-10",
				"2021-09-06",
				"2021-09-04",
				"2021-09-04",
				"2021-09-04",
				"2021-09-04",
				"2021-09-10"
				};
	
		for (int i=0; i<items.length; i++) {
			assertTrue(items[i].toString().endsWith(stringReps[i]));
			
			assertEquals(shipDatesSun[i], items[i].purchase("2021-08-29")); // Sunday
			assertEquals(shipDatesMon[i], items[i].purchase("2021-08-30")); // Monday
			assertEquals(shipDatesTues[i], items[i].purchase("2021-08-31")); // Tuesday
			assertEquals(shipDatesWed[i], items[i].purchase("2021-09-01")); // Wednesday
			assertEquals(shipDatesThurs[i], items[i].purchase("2021-09-02")); // Thursday
			assertEquals(shipDatesFri[i], items[i].purchase("2021-09-03")); // Friday
			assertEquals(shipDatesSat[i], items[i].purchase("2021-09-04")); // Saturday
		}
	}
}