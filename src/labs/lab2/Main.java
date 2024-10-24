package labs.lab2;

import java.util.Scanner;

public class Main {

	/**
	 * Extracts the dollars and cents from an amount of money given as a 
	 * floating-point value. For example, an amount 2.95 yields values 2 
	 * and 95 for the dollars the cents. 
	 * 
	 * You may assume that the input is always a valid non-negative monetary 
	 * amount.
	 * 
	 * @param amount amount of money
	 * 
	 * @return	a string representing the dollars and cents in the format 
	 * "dollars: ..., cents: ..."
	 */
	public static String problem1_getDollarsAndCents(double amount) {
		/* METHOD 1
		int numDollars = 0;
		int numCents = 0;
		
		// check zero
		if (amount != 0.0)
		{
			while (amount >= 1)
			{
				// take a dollar from the amount and add it to the dollar counter
				amount--;
				numDollars++;
				
				System.out.println("amount: " + amount + "\ndollars: " + numDollars);
			}
			
			System.out.println("amount after dollars: " + amount);
			// add all the cents to the cent counter
			// round to nearest int to account for imperfect floating point precision
			numCents = Math.round((float) amount * 100);
		}
		
		return "dollars: " + numDollars + ", cents: " + numCents;
		*/
		
		/* METHOD 2
		int dollarCount = 0;
		int centCount = 0;
		
		// check zero 
		if (amount > 0.0)
		{
			// decrement by 1 cent until hitting floor(amount)
			while (amount - (int)amount > 0.01)
			{
				centCount++;
				amount -= 0.01;
			}
			
			dollarCount = (int)amount;
		}
		
		return "dollars: " + dollarCount + ", cents: " + centCount;
		*/
		
		
		// METHOD 3
		// multiply amount by 100, and use / and % to get appropriate digits in proper spots
		long dollarCount = 0;
		long centCount = 0;
		if (amount > 0.0)
		{
			long newAmount = (long) (amount * 100);
			
			// DEBUG
			// System.out.println("\nnew amount: " + newAmount);
		
			// now newAmount contains just the number of total cents in the amount of money there was
			
			centCount = newAmount % 100;
			
			dollarCount = newAmount / 100;
		}
		
		return "dollars: " + dollarCount + ", cents: " + centCount;
	}
	
	
	/**
	 * Reads a ten-digit number from the user and prints it as a more readable
	 * string with parentheses and dashes. Specifically:
	 * 
	 * 1. Take the first three characters and surround them with "(" and ")". This
	 * is the area code. 2. Concatenate the area code, a single space, the next
	 * three characters, a hyphen, and the last four characters. This is the
	 * formatted number.
	 * 
	 * When you print the formatted number, use print instead of println.
	 * 
	 * Assume all input will be valid ten-digit numbers.
	 * 
	 * To run this method using the keyboard for user input, call it like this:
	 * problem2_formatPhoneNumber(new Scanner(System.in));
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 */
	public static void problem2_formatPhoneNumber(Scanner in) {
		System.out.print("Please enter a ten-digit phone number: ");
		String unformattedNum = in.next();
		
		// build a new string with proper formatting
		String formattedNum = "(";
		formattedNum += unformattedNum.substring(0, 3) + ") "; // area code "(***) "
		formattedNum += unformattedNum.substring(3, 6) + "-"; // middle digits to get to "(***) ***-
		formattedNum += unformattedNum.substring(6); // last 4 digits to get "(***) ***-****"
		
		System.out.print(formattedNum);
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem3_calculateTotal(new Scanner(System.in));
	 */
	public static void problem3_calculateTotal(Scanner in) {
		final double TAX_RATE = 0.1;
		final double SHIPPING_COST_PER_STICKER = 0.15;
		System.out.print("Enter price per sticker: ");
		double stickerPrice = in.nextDouble();
		
		System.out.print("Enter the number of stickers: ");
		int stickerCount = in.nextInt();
		
		double totalStickerPrice = stickerPrice * stickerCount;
		double tax = totalStickerPrice * TAX_RATE;
		double shippingCost = stickerCount * SHIPPING_COST_PER_STICKER;
		
		double orderPrice = totalStickerPrice + tax + shippingCost;
		
		System.out.printf("Your total is: $%.2f", orderPrice);
		
	}
	
	
	/**
	 * Computes the number of months it will take to pay off a credit card balance, based
	 * on the balance, APR, and monthly payment which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem4_creditCardPayoff(new Scanner(System.in));
	 */
	public static void problem4_creditCardPayoff(Scanner in) {
		double balance = 0;
		System.out.print("What is your balance? ");
		balance = in.nextDouble();
		
		double apr = 0;
		System.out.print("What is the APR on the card? ");
		apr = in.nextDouble();
		// put apr into percentage
		apr = apr / 100.0;
		
//		DEBUG
//		System.out.println("DEBUG APR DECIMAL: " + apr);
		
		double monthlyPayment = 0;
		System.out.print("What is the monthly payment you can make? ");
		monthlyPayment = in.nextDouble();
		
		double i = apr / 365.0; // daily rate
		
		double denom = Math.log(1 + i);
		
		double exponent = Math.pow(1 + i,  30);
		double exponentExpression = 1 - exponent;
		
		double scaledExponentExpression = (balance / monthlyPayment) * exponentExpression;
		
		double numer = Math.log(1 + scaledExponentExpression);
		
		double complexFraction = numer / denom;
		
		double numberOfMonths = (-1.0 / 30.0) * complexFraction;
		
		int roundedNumberOfMonths = (int) Math.ceil(numberOfMonths);
		
		System.out.print("It will take you " + roundedNumberOfMonths + " months to pay off this card.");
	}
	
	
	/**
	 * If one or both of the first 2 chars in the given string is the char 'x' 
	 * (lower case only), returns the string without those 'x' chars. Otherwise, 
	 * returns the string unchanged. 
	 * 
	 * @param str	the string to change
	 * 
	 * @return	the changed string
	 */
	public static String problem6_withoutX2(String str) {
		boolean firstIsX = false;
		boolean secondIsX = false;
		
		// edge case empty string
		if (str.isEmpty())
			return "";
		
		// when str length is 1
		if (str.length() == 1)
		{
			if (str.charAt(0) == 'x')
				return "";
			else 
				return str;
		}
		
		// string will have at least length 2 so 
		// we can check both of first two chars for 'x'
		if (str.charAt(0) == 'x')
			firstIsX = true;
		if (str.charAt(1) == 'x')
			secondIsX = true;
		
		// when str length is 2
		if (str.length() == 2)
		{			
			// remove any x's 
			String toReturn = "";
			if (firstIsX && secondIsX)
				return "";
			else if (firstIsX)
				toReturn += str.substring(1);
			else if (secondIsX)
				toReturn += str.substring(0, 1);
			else 
				toReturn += str;
			
			return toReturn;	
				
		}
		
		// when str length is more than 2
		String returnMe = "";
		if (firstIsX && secondIsX)
			returnMe += str.substring(2);
		else if (firstIsX)
			returnMe += str.substring(1);
		else if (secondIsX)
			returnMe += str.substring(0, 1) + str.substring(2);
		else 
			returnMe += str;
		
		return returnMe;
	}
	
	
	/**
	 * Given 2 integer values greater than 0, return whichever value is nearest to
	 * 21 without going over. If they both go over, return 0.
	 * 
	 * @param a the first value
	 * @param b the second value
	 * 
	 * @return whichever value is nearest to 21 without going over; if they both go
	 *         over, return 0
	 */
	public static int problem7_playBlackjack(int a, int b) {
		final int LIMIT = 21;
		// both go over
		if (a > LIMIT && b > LIMIT)
			return 0;
		if (a > LIMIT && b <= LIMIT)
			return b;
		if (b > LIMIT && a <= LIMIT)
			return a;
		
		if (a == LIMIT || b == LIMIT)
			return LIMIT;
		
		// reaching this spot means a and b are both < LIMIT
		if (a > b)
			return a;
		else
			return b;
	}
	
	
	/**
	 * Assesses the strength of a password based on these rules:
	 * 
	 * * A very weak password contains only digits and is fewer than eight characters
	 * * A weak password contains only letters and is fewer than eight characters
	 * * A strong password contains at least one letter and at least one digit and is at least
	 * eight characters
	 * * A very strong password contains at least one letter, at least one digit, and at least
	 * one special character (non letter or digit) and is at least eight characters
	 * * All other passwords are medium strength
	 * 
	 * Assume all input strings will have length >= 1
	 * 
	 * @param password	the password to assess
	 * @return	a string describing its strength
	 */
	public static String problem8_assessPasswordStrength(String password) {
		String returnMe = "";
		boolean onlyDigits = true;
		boolean hasDigit = false;
		boolean onlyLetters = true;
		boolean hasLetter = false;
		boolean hasSpecialChar = false;
		
		// go through password and analyze chars
		for (int i = 0; i < password.length(); i++)
		{
			char currChar = password.charAt(i);
			
			if (Character.isLetter(currChar))
			{
				onlyDigits = false;
				hasLetter = true;
			}
			if (Character.isDigit(currChar))
			{
				onlyLetters = false;
				hasDigit = true;
			}
			if (!Character.isLetter(currChar) && !Character.isDigit(currChar))
			{
				hasSpecialChar = true;
				onlyDigits = false;
				onlyLetters = false;
			}
		}
		
//		boolean mixedChars = !onlyDigits && !onlyLetters && !hasSpecialChar;
		
		int len = password.length();
		
		if (onlyDigits && len < 8)
			returnMe += "very weak";
		else if (onlyLetters && len < 8)
			returnMe += "weak";
		else if (hasLetter && hasDigit && !hasSpecialChar&& len >= 8)
			returnMe += "strong";
		else if (hasLetter && hasDigit && hasSpecialChar && len >= 8)
			returnMe += "very strong";
		else 
			returnMe += "medium";
		
		
		return returnMe;
	}
	
	
	/**
	 * Walk the user through troubleshooting issues with a car.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem9_troubleshootCarIssues(new Scanner(System.in));
	 */
	public static void problem9_troubleshootCarIssues(Scanner in) {
//		final int INVALID = 0;
		final int YES = 1;
		final int NO = 2;
		System.out.print("Is the car silent when you turn the key? ");
		
		String input = in.nextLine();
		
		int inputNum = analyzeInput(input);
		
		if (inputNum == YES)
		{
			System.out.print("Are the battery terminals corroded? ");
			
			input = in.nextLine();
			inputNum = analyzeInput(input);
			
			if (inputNum == YES)
			{
				System.out.print("Clean terminals and try starting again.");
				return;
			}
			else if (inputNum == NO)
			{
				System.out.print("Replace cables and try again.");
				return;
			}
			else 
			{
				System.out.print("Invalid input. Exiting.");
				return;
			}
		}
		else if (inputNum == NO)
		{
			System.out.print("Does the car make a clicking noise? ");
			
			input = in.nextLine();
			inputNum = analyzeInput(input);
			
			if (inputNum == YES)
			{
				System.out.print("Replace the battery.");
				return;
			}
			else if (inputNum == NO)
			{
				System.out.print("Does the car crank up but fail to start? ");
				
				input = in.nextLine();
				inputNum = analyzeInput(input);
				
				if (inputNum == YES)
				{
					System.out.print("Check spark plug connections.");
					return;
				}
				else if (inputNum == NO)
				{
					System.out.print("Does the engine start and then die? ");
					
					input = in.nextLine();
					inputNum = analyzeInput(input);
					
					if (inputNum == YES)
					{
						System.out.print("Does your car have fuel injection? ");
						
						input = in.nextLine();
						inputNum = analyzeInput(input);
						
						if (inputNum == YES)
						{
							System.out.print("Get it in for service.");
							return;
						}
						else if (inputNum == NO)
						{
							System.out.print("Check to ensure the choke is opening and closing.");
							return;
						}
						else 
						{
							System.out.print("Invalid input. Exiting.");
							return;
						}
					}
					else if (inputNum == NO)
					{
						System.out.print("Get it in for service.");
						return;
					}
					else 
					{
						System.out.print("Invalid input. Exiting.");
						return;
					}
				}
				else 
				{
					System.out.print("Invalid input. Exiting.");
					return;
				}
			}
			else 
			{
				System.out.print("Invalid input. Exiting.");
				return;
			}
		}
		else 
		{
			System.out.print("Invalid input. Exiting.");
			return;
		}
		
		
	}
	
	private static int analyzeInput(String str)
	{
		if (!str.isEmpty())
		{
			if (str.substring(0, 1).toLowerCase().equals("y"))
				return 1;
			else if (str.substring(0, 1).toLowerCase().equals("n"))
				return 2;
		}
		return 0;
	}
	
	
	public static void main(String[] args)
	{
//		Problem 1 tests
//		System.out.println(problem1_getDollarsAndCents(2.95));
//		System.out.println(problem1_getDollarsAndCents(0));
//		System.out.println(problem1_getDollarsAndCents(0.95));
//		System.out.println(problem1_getDollarsAndCents(11.13));
//		System.out.println(problem1_getDollarsAndCents(6998));
//		System.out.println(problem1_getDollarsAndCents(4.34));
//		System.out.println(problem1_getDollarsAndCents(12345678910987.2));
		
//		Problem 2 tests
//		problem2_formatPhoneNumber(new Scanner(System.in));
		
//		Problem 3 tests
//		problem3_calculateTotal(new Scanner(System.in));
		
//		int rate = 17;
//		
//		double d = rate / 100.0;
//		
//		System.out.println(d);
		
//		Problem 4 test
//		problem4_creditCardPayoff(new Scanner(System.in));
		
//		Problem 5 test
//		Boat b = new Boat(0, 0, 0);
//		b.move(50);
//
//		System.out.println(b.getX()); // returns 50.0
//		System.out.println(b.getY()); // returns 0.0
//		System.out.println(b.getDirection()); // returns 0.0
//
//		b.turn(360);
//		b.move(10);
//		System.out.println(b.getX()); // returns 60.0
//		System.out.println(b.getY()); // returns 0.0
//		System.out.println(b.getDirection()); // returns 360.0
//
//		b.turn(-2);
//		System.out.println(b.getX()); // returns 60.0
//		System.out.println(b.getY()); // returns 0.0
//		System.out.println(b.getDirection()); // returns 358.0
//
//		b.turn(-440);
//		b.move(255.3);
//		System.out.println(b.getX()); // returns 95.53089267510472
//		System.out.println(b.getY()); // returns -252.81543794972293
//		System.out.println(b.getDirection()); // returns -82.0
		
//		Problem 6 test
//		System.out.println(problem6_withoutX2("xHi"));
//		System.out.println(problem6_withoutX2("Hxi"));
//		System.out.println(problem6_withoutX2("Hi"));
//		System.out.println(problem6_withoutX2("XHi"));
//		System.out.println(problem6_withoutX2("").length());
//		System.out.println(problem6_withoutX2("x").length());
//		System.out.println(problem6_withoutX2("xx").length());
//		System.out.println(problem6_withoutX2("xa"));
//		System.out.println(problem6_withoutX2("ax"));
//		System.out.println(problem6_withoutX2("xxa"));
//		System.out.println(problem6_withoutX2("axx"));
//		System.out.println(problem6_withoutX2("Xx"));
//		System.out.println(problem6_withoutX2("xX"));
//		System.out.println(problem6_withoutX2("XXx"));
		
//		Problem 7 test
//		System.out.println(problem7_playBlackjack(21, 19));
//		System.out.println(problem7_playBlackjack(19, 22));
//		System.out.println(problem7_playBlackjack(22, 22));
//		System.out.println(problem7_playBlackjack(21, 21));
		
//		Problem 8 test
//		System.out.println(problem8_assessPasswordStrength("12345"));
//		System.out.println(problem8_assessPasswordStrength("abcdef"));
//		System.out.println(problem8_assessPasswordStrength("abc123xyz"));
//		System.out.println(problem8_assessPasswordStrength("1337h@xor"));
//		System.out.println(problem8_assessPasswordStrength("1337h xor"));
//		System.out.println(problem8_assessPasswordStrength("123abc"));
		
//		Problem 9 test
		problem9_troubleshootCarIssues(new Scanner(System.in));
		
//		Problem 10 test
//		GroceryBill bill1 = new GroceryBill(100); 
//		System.out.println(bill1.getDiscount()); // returns 10
//		System.out.println(bill1.getAmountOwed() + "\n"); // returns 99
//		
//		GroceryBill bill2 = new GroceryBill(85572.34);
//		System.out.println(bill2.getDiscount()); // returns 20
//		System.out.println(bill2.getAmountOwed()); // returns 75303.66
		
		
	}
}
