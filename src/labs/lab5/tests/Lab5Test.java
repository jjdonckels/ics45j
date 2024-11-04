package labs.lab5.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab5.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lab5Test {

	private final double EPSILON = 1e-3;

	@Test
	public void problems1through5() {
		Player robert = new Player("Robert");
		assertEquals(0.5, robert.getHealth(), EPSILON);
		
		Ingestible broccoli = new Food("broccoli", 10);
		Ingestible cheetos = new Food("cheetos", 0);
		Ingestible water = new Drink("water", 100);
		Ingestible wine = new Drink("wine", 5);
		Ingestible vitamins = new Pills("vitamins", 9);
		Ingestible illegalDrugs = new Pills("illegal drugs", -100);
		
		Doable work = new Activity("work", 3, 8);
		Doable sleep = new Activity("sleep", 10, 7);
		Doable play = new Activity("play", 8, 1);
		Doable study = new Activity("study", 4, 3);
		
		assertEquals("Robert is eating broccoli", broccoli.ingest(robert));
		assertEquals(1.0, robert.getHealth(), EPSILON);
		assertEquals("Robert is eating broccoli", broccoli.ingest(robert));
		assertEquals(1.0, robert.getHealth(), EPSILON);
		assertEquals("Robert is eating cheetos", cheetos.ingest(robert));
		assertEquals(0.5, robert.getHealth(), EPSILON);
		assertEquals("Robert is drinking water", water.ingest(robert));
		assertEquals(0.75, robert.getHealth(), EPSILON);
		assertEquals("Robert is drinking wine", wine.ingest(robert));
		assertEquals(0.75, robert.getHealth(), EPSILON);
		assertEquals("Robert is taking illegal drugs", illegalDrugs.ingest(robert));
		assertEquals(0.25, robert.getHealth(), EPSILON);
		assertEquals("Robert is taking vitamins", vitamins.ingest(robert));
		assertEquals(0.65, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing work for 8 hours", work.doIt(robert));
		assertEquals(0.55, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing sleep for 7 hours", sleep.doIt(robert));
		assertEquals(0.8, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing play for 1 hours", play.doIt(robert));
		assertEquals(0.95, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing study for 3 hours", study.doIt(robert));
		assertEquals(0.9, robert.getHealth(), EPSILON);
		assertEquals("Robert is taking illegal drugs", illegalDrugs.ingest(robert));
		assertEquals(0.4, robert.getHealth(), EPSILON);
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		assertEquals("Robert is taking illegal drugs", illegalDrugs.ingest(robert));
		
		String result = output.toString();
		assertEquals("Robert died!", result);
		
		assertEquals(0.0, robert.getHealth(), EPSILON);
		
		
		Player emily = new Player("Emily");
		
		Ingestible boba = new Drink("boba", 2);
		
		assertEquals("Emily is drinking boba", boba.ingest(emily));
		assertEquals(0.35, emily.getHealth(), EPSILON);
		assertEquals("Emily is doing play for 1 hours", play.doIt(emily));
		assertEquals(0.5, emily.getHealth(), EPSILON);
		assertEquals("Emily is eating broccoli", broccoli.ingest(emily));
		assertEquals(1.0, emily.getHealth(), EPSILON);
		assertEquals("Emily is taking vitamins", vitamins.ingest(emily));
		assertEquals(1.0, emily.getHealth(), EPSILON);
	}
	
	@Test
	public void problems6Through7() {
		Encourager dog = new Dog(); 
		assertEquals("Give wet sloppy kisses | Lay on your feet", dog.encourage());
		
		Encourager friend1 = new Friend("Jing", 20);
		assertEquals("Come over to hang out | Bring snacks", friend1.encourage());
		
		Encourager friend2 = new Friend("Aly", 21);
		assertEquals("Come over to hang out | Bring snacks", friend2.encourage());
		
		Encourager nature = new Nature();
		assertEquals("Shine sun | Blow gentle breeze", nature.encourage());
		
		Encourager mom = new Parent("Mom", 50);
		assertEquals("Call on the phone | Say you're their favorite child", mom.encourage());
		
		Encourager dad = new Parent("Dad", 51);
		assertEquals("Call on the phone | Say you're their favorite child", dad.encourage());

			
		Person[] people = {
			new Friend("Jing", 20),
			new Friend("Aly", 21),
			new Friend("Aly", 18),
			new Friend("Aly", 35),
			new Parent("Mom", 50),
			new Parent("Dad", 51)
		};
			
		Arrays.sort(people);
		
		assertEquals("Name: Aly, Age: 18", people[0].toString());
		assertEquals("Name: Aly, Age: 21", people[1].toString());
		assertEquals("Name: Aly, Age: 35", people[2].toString());
		assertEquals("Name: Dad, Age: 51", people[3].toString());
		assertEquals("Name: Jing, Age: 20", people[4].toString());
		assertEquals("Name: Mom, Age: 50", people[5].toString());
	}
	
	@Test
	public void problem8() {
		Coin coin1 = new Coin(.25, "Quarter");
		Coin coin2 = new Coin(.10, "Dime");
		Coin coin3 = new Coin(.10, "Dime");
		Coin coin4 = new Coin(.10, "My Dime");
		Coin coin5 = new Coin(.01, "Penny");
		Coin coin6 = new Coin(.01, "Different Penny");
		Coin coin7 = new Coin(.05, "NICKEL");
		Coin coin8 = new Coin(.05, "nickel");
		Coin coin9 = new Coin(.05, "Nickel");

		assertTrue(coin1.compareTo(coin2) > 0);
		assertEquals(0, coin2.compareTo(coin3));
		assertTrue(coin3.compareTo(coin1) < 0);
		assertTrue(coin3.compareTo(coin4) < 0);
		assertTrue(coin4.compareTo(coin3) > 0);
		assertTrue(coin2.equals(coin3));
		assertFalse(coin2.equals(coin4));

		assertEquals("Value: 0.25, Name: Quarter", coin1.toString());
		assertEquals("Value: 0.1, Name: Dime", coin2.toString());
		assertEquals("Value: 0.1, Name: Dime", coin3.toString());
		assertEquals("Value: 0.1, Name: My Dime", coin4.toString());
		assertEquals("Value: 0.01, Name: Penny", coin5.toString());
		assertEquals("Value: 0.01, Name: Different Penny", coin6.toString());
		assertEquals("Value: 0.05, Name: NICKEL", coin7.toString());
		assertEquals("Value: 0.05, Name: nickel", coin8.toString());
		assertEquals("Value: 0.05, Name: Nickel", coin9.toString());

		List<Coin> coins = new ArrayList<>();
		coins.add(coin1);
		coins.add(coin2);
		coins.add(coin3);
		coins.add(coin4);
		coins.add(coin5);
		coins.add(coin6);
		coins.add(coin7);
		coins.add(coin8);
		coins.add(coin9);

		Collections.sort(coins);

		assertEquals(coin6, coins.get(0));
		assertEquals(coin5, coins.get(1));
		assertEquals(coin7, coins.get(2));
		assertEquals(coin9, coins.get(3));
		assertEquals(coin8, coins.get(4));
		assertEquals(coin2, coins.get(5));
		assertEquals(coin3, coins.get(6));
		assertEquals(coin4, coins.get(7));
		assertEquals(coin1, coins.get(8));
	}
	
	@Test
	public void problem9() {
		Student[] students = new Student[] { new Student("Robert", 1234), new Student("Emily", 4321),
				new Student("Harry", 1111), new Student("Kelly", 18), new Student("Mike", 18), new Student("Mike", 18),
				new Student("Robert", 50000), new Student("Emily", 9832), new Student("Emily", 19),
				new Student("ROBERT", 7778) };

		// test toString:
		assertEquals("Robert, 1234", students[0].toString());
		assertEquals("Mike, 18", students[4].toString());
		assertEquals("ROBERT, 7778", students[9].toString());

		// test compareTo:
		assertTrue(students[8].compareTo(students[7]) < 0);
		assertTrue(students[1].compareTo(students[8]) > 0);
		assertTrue(students[4].compareTo(students[5]) == 0);

		// test equals:
		assertTrue(students[4].equals(students[5]));
		assertFalse(students[7].equals(students[8]));
		assertFalse(students[3].equals(students[4]));

		// test StudentFinder methods:
		assertEquals(students[8], StudentFinder.firstStudent(students));
		assertEquals(students[6], StudentFinder.lastStudent(students));

		students = new Student[] { new Student("Robert", 0) };

		assertEquals(students[0], StudentFinder.firstStudent(students));
		assertEquals(students[0], StudentFinder.lastStudent(students));
	}
	
}
