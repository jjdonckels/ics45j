package labs.lab1;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

public class Main {
	
	/**
	 * Given a string, return a new string where all the "e" letters and "o" letters,
	 *  as well as all the "E" letters and "O" letters have been switched, by 
	 *  calling the replace method. (Hint: You will have to call replace more than 
	 *  once.)
	 *  
	 * @param str	the input string
	 * 
	 * @return	a new string where all the "e" letters and "o" letters,
	 *  as well as all the "E" letters and "O" letters have been switched
	 */
	public static String problem1_switchEO(String str) {
		if (str.isEmpty())
			return str;
		
		String newStr = "";
		
		/* !! without replace method
		// go through str, concatenating it to newStr char by char, 
		// replacing the appropriate letters along the way
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == 'e')	
				newStr += "o";
			else if (str.charAt(i) == 'o')
				newStr += "e";
			else if (str.charAt(i) == 'O')
				newStr += "E";
			else if (str.charAt(i) == 'E')
				newStr += "O";
			else 
				newStr += str.charAt(i);
		} */
		
		// with replace method
		String littleEToO = str.replace('e', 'o');
		String littleOtoE = str.replace('o', 'e');
		
		// need to combine the replaced strings appropriately to account for overlap from 
		// single calls of the replace method
		for (int i = 0; i < str.length(); i++)
		{
			char original = str.charAt(i);
			char eToO = littleEToO.charAt(i);
			char oToE = littleOtoE.charAt(i);
			
			// if all chars are the same, that wasn't a character that was replaced
			// chars that were replaced are the odd one out and only two should match
			if (original == eToO && original == oToE)
				newStr += original;
			else if (original == eToO)
				newStr += oToE;
			else if (original == oToE)
				newStr += eToO;
		}
		
		// do the same thing above but continued with upper case E and O
		String newStr2 = "";
		String bigEToO = newStr.replace('E', 'O');
		String bigOtoE = newStr.replace('O', 'E');
		
		// need to combine the replaced strings appropriately to account for overlap from 
		// single calls of the replace method
		for (int i = 0; i < newStr.length(); i++)
		{
			char original = newStr.charAt(i);
			char eToO = bigEToO.charAt(i);
			char oToE = bigOtoE.charAt(i);
			
			// if all chars are the same, that wasn't a character that was replaced
			// chars that were replaced are the odd one out and only two should match
			if (original == eToO && original == oToE)
				newStr2 += original;
			else if (original == eToO)
				newStr2 += oToE;
			else if (original == oToE)
				newStr2 += eToO;
		}
		
		
		return newStr2;
	}
	
	
	/**
	 * Given two strings, a and b, return true if b appears (in its entirety, 
	 * case-sensitive) starting at index 0 or 1 in a. String a may be any length, 
	 * including 0. String b's length will be at least 1. 
	 * 
	 * @param a	the first input string
	 * @param b	the second input string
	 * 
	 * @return	true if b appears (in its entirety, case-sensitive) starting at 
	 * index 0 or 1 in a
	 */
	public static boolean problem2_hasStr(String a, String b) {
		// case for empty a
		if (a.isEmpty())
			return false;
		
		int bIndex = a.indexOf(b);
		if (bIndex == 0 || bIndex == 1)
			return true;
		
		return false;
	}
	
	
	/**
	 * A slot machine has 4 reels and a number of possible pictures for each 
	 * reel. Most modern slot machines operate based on a random number 
	 * generator that determines which picture to show for each reel. Write a method 
	 * that generates random numbers for 4-reel slot machines. This method takes as 
	 * input numPics, and returns 4 numbers (indicating which picture to show in each
	 * reel) as a string, with each number separated by a space.
	 * 
	 * Construct an object of the Random class (see the Java API docs) and invoke an 
	 * appropriate method to generate each number. 
	 * 
	 * As an example, imagine you have a machine that has 3 possible pictures: 
	 * cherries (picture #1), bananas (picture #2), or money (picture #3).
	 * In this case, the result should contain 4 numbers between 1 and 3. For instance,
	 * "3 2 1 1", which would translate to:
	 * 
	 * Reel 1: money
	 * Reel 2: bananas
	 * Reel 3: cherries
	 * Reel 4: cherries
	 * 
	 * But all you have to return is a string with the numbers in it. The example
	 * with actual pictures of things is just for context.
	 * 
	 * Assume numPics will always be > 0.
	 * 
	 * @param numPics	the number of possible pictures per reel
	 * @return			a string that indicates which picture to show in each reel (4 numbers 
	 * 					separated by a single space
	 */
	public static String problem3_slotMachine(int numPics) {
		Random randomNumGenerator = new Random();
		String newStr = "";
		final int NUM_SLOTS = 4;
		
		for (int i = 0; i < NUM_SLOTS; i++)
		{
			int currSlot = randomNumGenerator.nextInt(numPics) + 1;
			newStr += currSlot + " ";
		}
		
		return newStr.trim();
	}
	
	
	/**
	 * Given a BigInteger object, return a BigInteger that is equal to the original 
	 * BigInteger to the fourth power.
	 * 
	 * @param bigInt	the input BigInteger
	 * 
	 * @return	a BigInteger that is equal to the input BigInteger to the fourth power
	 */
	public static BigInteger problem4_bigPower(BigInteger bigInt) {
		final int EXPONENT = 4;
		
		return bigInt.pow(EXPONENT);
	}
	
	
	/**
	 * Given three integers representing a date (month, day, and year), return a string
	 * indicating what day of the week that day falls on, in all upper case. The month,
	 * day, and year inputs will always represent a valid date.
	 * 
	 * Hint: See the LocalDate class in the Java API docs.
	 * 
	 * @param month	month of input date
	 * @param day	day of input date
	 * @param year	year of input date
	 * 
	 * @return	a string indicating what day of the week that day falls on, in all
	 * upper case
	 */
	public static String problem5_getDayOfWeek(int month, int day, int year) {
		LocalDate thisDate = LocalDate.of(year, month, day);
		
		DayOfWeek thisDay = thisDate.getDayOfWeek();
		
		
		return thisDay.toString();
	}
	
	public static void main(String[] args)
	{
//		String str = "Java is fun!";
//		System.out.println("Original: " + str);
//		System.out.println("New: " + problem1_switchEO(str));
		
//		System.out.println(problem2_hasStr("lovely", "love"));
//		System.out.println(problem2_hasStr("Blovely", "love"));
//		System.out.println(problem2_hasStr("URlovely", "love"));
//		System.out.println(problem2_hasStr("Lovely", "love"));
//		System.out.println(problem2_hasStr("", "love"));
//		System.out.println(problem2_hasStr("hello", "love"));
//		System.out.println(problem2_hasStr("love", "love"));
		
//		System.out.println(problem3_slotMachine(3));
//		System.out.println(problem3_slotMachine(5));
//		System.out.println(problem3_slotMachine(10));
		
//		System.out.println(problem4_bigPower(new BigInteger("12345678987654321")));
//		System.out.println(problem4_bigPower(new BigInteger("999999998888888")));
//		System.out.println("999999995555552007407419253777018382857935068069867401383936");
		
//		System.out.println(problem5_getDayOfWeek(12, 25, 2021));
//		System.out.println(problem5_getDayOfWeek(12, 18, 2020));
//		System.out.println(problem5_getDayOfWeek(4, 2, 1934));
		
//		Circuit wiring = new Circuit();
//		System.out.println(wiring.getSwitchState(1));
//		System.out.println(wiring.getSwitchState(2));
//		System.out.println(wiring.getLampState());
//		System.out.println();
//		
//		wiring.toggleSwitch(1);
//		System.out.println(wiring.getSwitchState(1));
//		System.out.println(wiring.getSwitchState(2));
//		System.out.println(wiring.getLampState());
//		System.out.println();
//		
//		wiring.toggleSwitch(2);
//		System.out.println(wiring.getSwitchState(1));
//		System.out.println(wiring.getSwitchState(2));
//		System.out.println(wiring.getLampState());
//		System.out.println();
//		
//		wiring.toggleSwitch(1);
//		System.out.println(wiring.getSwitchState(1));
//		System.out.println(wiring.getSwitchState(2));
//		System.out.println(wiring.getLampState());
//		System.out.println();
		
//		Employee robert = new Employee("Robert Navarro", 100000);
//		robert.raiseSalary(10); // Robert gets a 10% raise
//		System.out.println(robert.getSalary()); // should print 110000.0
		
//		AntPopulation ants = new AntPopulation(10);
//		ants.breed(); // population doubles
//		ants.spray(10.0); // 10% of population is eradicated
//		System.out.println(ants.getAnts()); // returns 18
		
//		Microwave appliance = new Microwave();
//		appliance.increaseTime();
//		appliance.increaseTime();
//		appliance.increaseTime();
//		appliance.switchPower();
//		System.out.println(appliance.start()); // returns "Cooking for 90 seconds at level 2"
//		appliance.reset();
//		appliance.increaseTime();
//		appliance.switchPower();
//		appliance.switchPower();
//		System.out.println(appliance.start()); // returns "Cooking for 30 seconds at level 1"
		
		Battery battery = new Battery(100.0);
		System.out.println(battery.getRemainingCapacity()); // returns 100.0

		battery.drain(23.4);
		battery.drain(9.7);
		System.out.println(battery.getRemainingCapacity()); // returns 66.9

		battery.charge();
		System.out.println(battery.getRemainingCapacity()); // returns 100.0
		
	}
	
}
