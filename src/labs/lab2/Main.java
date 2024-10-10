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
		return ""; // FIX ME
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
		// WRITE YOUR CODE HERE
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
		// WRITE YOUR CODE HERE
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
		// WRITE YOUR CODE HERE
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
		return ""; // FIX ME
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
		return -1; // FIX ME
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
		return ""; // FIX ME
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
		// WRITE YOUR CODE HERE
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Hello there!");
	}
}
