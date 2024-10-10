package labs.lab1.tests;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import labs.lab1.*;


public class Lab1Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals("Holle, Werld!", Main.problem1_switchEO("Hello, World!"));
		assertEquals("EEEEEEHHH...", Main.problem1_switchEO("OOOOOOHHH..."));
		assertEquals("Java is fun!", Main.problem1_switchEO("Java is fun!"));
	}
	
	@Test
	public void problem2() {
		assertTrue(Main.problem2_hasStr("lovely", "love"));
		assertTrue(Main.problem2_hasStr("Blovely", "love"));
		assertFalse(Main.problem2_hasStr("URlovely", "love"));
		assertFalse(Main.problem2_hasStr("Lovely", "love"));
		assertFalse(Main.problem2_hasStr("", "love"));
		assertFalse(Main.problem2_hasStr("hello", "love"));
		assertTrue(Main.problem2_hasStr("love", "love"));
		assertFalse(Main.problem2_hasStr("lovely", "lovelyy"));
		assertFalse(Main.problem2_hasStr("look", "love"));
		assertTrue(Main.problem2_hasStr("lovelovelovelove", "love"));
	}
	
	@Test
	public void problem3() {
		// numPics = 5:
		int numPics = 5;
		String numString = Main.problem3_slotMachine(numPics);
		Scanner s = new Scanner(numString);
		ArrayList<Integer> nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();

		// numPics = 3:
		numPics = 3;
		numString = Main.problem3_slotMachine(numPics);
		s = new Scanner(numString);
		nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();

		// numPics = 10:
		numPics = 10;
		numString = Main.problem3_slotMachine(numPics);
		s = new Scanner(numString);
		nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();

		// numPics = 3000:
		numPics = 3000;
		numString = Main.problem3_slotMachine(numPics);
		s = new Scanner(numString);
		nums = new ArrayList<>();
		while (s.hasNext()) {
			nums.add(s.nextInt());
		}

		// make sure it generated 4 numbers:
		assertEquals(4, nums.size());

		// make sure all nums are between the min and max:
		for (Integer num : nums) {
			assertTrue(num >= 1);
			assertTrue(num <= numPics);
		}
		s.close();
	}

	@Test
	public void problem4() {
		assertEquals(new BigInteger("23230572939574190285016132680582106822956386016021987551618623681"), 
				Main.problem4_bigPower(new BigInteger("12345678987654321")));
	}
	
	@Test
	public void problem5() {	
		assertEquals("SATURDAY",Main.problem5_getDayOfWeek(12, 25, 2021));
		assertEquals("FRIDAY", Main.problem5_getDayOfWeek(12, 18, 2020));
		assertEquals("MONDAY", Main.problem5_getDayOfWeek(4, 2, 1934));
	}
	
	@Test
	public void problem6() {
		Circuit wiring = new Circuit();
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(1, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());

		wiring.toggleSwitch(2);
		assertEquals(1, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(1, wiring.getLampState());

		wiring.toggleSwitch(1);
		assertEquals(0, wiring.getSwitchState(1));
		assertEquals(0, wiring.getSwitchState(2));
		assertEquals(0, wiring.getLampState());
	}
	
	@Test
	public void problem7() {
		Employee robert = new Employee("Robert Navarro", 100000);
		robert.raiseSalary(10);
		assertEquals(110000.0, robert.getSalary(), EPSILON);
		Employee george = new Employee("George Glass", 500);
		assertEquals(500.0, george.getSalary(), EPSILON);
		george.raiseSalary(0);
		assertEquals(500.0, george.getSalary(), EPSILON);
		george.raiseSalary(100);
		assertEquals(1000.0, george.getSalary(), EPSILON);
	}
	
	@Test
	public void problem8() {	
		AntPopulation ants = new AntPopulation(10);
		ants.breed();
		ants.spray(10.0);
		assertEquals(18, ants.getAnts());
		ants.breed();
		ants.spray(5.0);
		assertEquals(34, ants.getAnts());
	}
	
	@Test
	public void problem9() {
		Microwave appliance = new Microwave();
		appliance.increaseTime();
		appliance.increaseTime();
		appliance.increaseTime();
		appliance.switchPower();
		assertEquals("Cookingfor90secondsatlevel2",appliance.start().replaceAll("\\s",""));
		appliance.reset();
		appliance.increaseTime();
		appliance.switchPower();
		appliance.switchPower();
		assertEquals("Cookingfor30secondsatlevel1", appliance.start().replaceAll("\\s","")); // returns "Cooking for 30 seconds at level 1"		
	}
	
	@Test
	public void problem10() {
		Battery battery1 = new Battery(100.0);
		assertEquals(100.0, battery1.getRemainingCapacity(), EPSILON);
		battery1.drain(23.4);
		battery1.drain(9.7);
		assertEquals(66.9, battery1.getRemainingCapacity(), EPSILON);
		battery1.charge();
		assertEquals(100.0, battery1.getRemainingCapacity(), EPSILON);

		Battery battery2 = new Battery(55.75);
		assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
		battery2.drain(55.75);
		assertEquals(0.0, battery2.getRemainingCapacity(), EPSILON);
		battery2.charge();
		assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
		battery2.drain(1.0);
		assertEquals(54.75, battery2.getRemainingCapacity(), EPSILON);
		battery2.charge();
		assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
		battery2.charge();
		assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
		battery2.drain(0);
		assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
	}
}
