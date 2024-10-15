package labs.lab3;

import java.util.Scanner;

public class Main {

	/**
	 * Takes a string as a parameter and returns a string where every appearance of
	 * the lowercase word "are" has been replaced with "are not". The word "are"
	 * should not be immediately preceded or followed by a letter -- so for example
	 * the "are" in "care" or "scared" does not count. (Note:
	 * Character.isLetter(char) tests if a char is a letter.)
	 * 
	 * @param str the string to replaces "are"s in
	 * @return the string with all "are"s replaced with "are not"s.
	 */
	public static String problem1_replace(String str) {
		return ""; // FIX ME
	}
	
	
	/**
	 * Given a string, returns the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * @param str the string to check for blocks
	 * 
	 * @return the length of the largest block in the string
	 */
	public static int problem2_maxBlock(String str) {
		return -1; // FIX ME
	}
	
	
	/**
	 * Given a string, return the longest substring that appears at both the
	 * beginning and end of the string without overlapping.
	 * 
	 * @param str the input string
	 * @return the longest substring that appears at both the beginning and end of
	 *         the string without overlapping.
	 */
	public static String problem3_sameEnds(String str) {
		return ""; // FIX ME
	}
	
	
	/**
	 * Manages crowd control in an office
	 * 
	 * @param in       the Scanner to be used for user input
	 * @param capacity of the office
	 * 
	 *                 To run this method using the keyboard for user input, call it
	 *                 like this: problem5_officeCrowdControl(new Scanner(System.in), 100);
	 */
	public static void problem5_officeCrowdControl(Scanner in, int capacity) {
		// WRITE YOUR CODE HERE
	}
	
	
	/**
	 * Given a non-empty array of ints, returns a new array containing the elements from
	 * the original array that come after the last occurrence of the number 3 in the original
	 * array
	 * 
	 * @param nums	the input array
	 * 
	 * @return	a new array containing the elements from the original array that come after 
	 * the last occurrence of the number 3 in the original array
	 * 
	 */
	public static int[] problem6_post3(int[] nums) {
		return null; // FIX ME
	}
	
	
	/**
	 * Given an integer n >= 0, returns an array with the pattern {1, 1, 2, 1, 2, 3,
	 * ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length
	 * of the array will be 1 + 2 + 3 ... + n, which is known to sun to exactly n*(n
	 * + 1)/2.
	 * 
	 * @param n input integer
	 * 
	 * @return patterned array
	 */
	public static int[] problem7_arrayPattern(int n) {
		return null; // FIX ME
	}
	
	public static void main(String[] args)
	{
		System.out.println("This is lab 3");
	}
}