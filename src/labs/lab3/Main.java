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
		
		String returnMe = "";
		int currIndex = str.indexOf("are");
		int prevIndex = currIndex; // prevIndex will be used to note the last occurrence of "are" before getting the next one
		
		// case when "are" is not present in str
		if (currIndex == -1)
			return str;
		
		// case when str is exactly "are"
		if (str.equals("are"))
			return "are not";
		
		
		// case where "are" is at the very beginning of str
		if (currIndex == 0)
		{
			prevIndex = 3; // prevIndex moves to spot right after "are" to pick up after replacing
			
			// check char after "are" to see if it's in a word or not
			if (str.length() > 3 && !Character.isLetter(str.charAt(3)))
			{
				returnMe += "are not"; // replace
				currIndex = str.indexOf("are", currIndex + 3); // update currIndex to look for next occurrence of "are"
			}
			else 
				return str; // this branch is for when str is exactly 3 chars but not "are"
		}
		else 
			// add anything before first occurrence of "are" to be returned
			// ex: str is "we are"
			// this adds "we " to returnMe
			returnMe += str.substring(0, currIndex); 
		
		// this loop deals with any occurrences of "are" after appearing at index 0 or not at all
		while (currIndex > 0)
		{
			// case for "are" being right at the end of str
			if (currIndex == str.length() - 3 && !Character.isLetter(str.charAt(currIndex - 1)))
				return returnMe + str.substring(prevIndex, currIndex) + "are not";
				
			
			// true if there is a spot in str after the current occurrence of "are"
			// ex: true if str is "blah blah are blah" and false if str is "blah are"
			boolean roomInBack = currIndex + 3 <= str.length() - 1;
			
			// true if the char in front of the current occurrence of "are" is a letter
			boolean frontChar = Character.isLetter(str.charAt(currIndex - 1));
			
			boolean backChar = false;
			
			if (roomInBack)
				// true if the char after current occurrence of "are" is a letter
				backChar = Character.isLetter(str.charAt(currIndex + 3));
			
			if (!frontChar && !backChar)
			{
				// this branch means "are" is not in the middle of a word and can be replaced
				
				// add everything up to "are" and then replace "are" with "are not"
				returnMe += str.substring(prevIndex, currIndex) + "are not";
				
				// this moves prevIndex to right after the current occurrence of "are" to
				// continue traversing the string
				prevIndex = currIndex + 3;
			}
			
			// updates currIndex to look for next occurrence of "are" in str
			currIndex = str.indexOf("are", currIndex + 3);			
		}
		
		// at this point "are" should not occur in the string anymore 
		// so we can concatenate anything that's left after the last occurrence of "are"
		// and then we can return
		returnMe += str.substring(prevIndex);
		
		
		return returnMe;
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
//		Problem 1 test
//		System.out.println(problem1_replace("are test"));
//		System.out.println(problem1_replace("are-are"));
//		System.out.println(problem1_replace("These are right"));
//		System.out.println(problem1_replace("I love Java!"));
//		System.out.println(problem1_replace("My favorite numbers are3 and 5."));
//		System.out.println(problem1_replace("I dare you"));
//		System.out.println(problem1_replace("are"));
//		System.out.println(problem1_replace("9are9"));
//		System.out.println(problem1_replace("aare are arek"));
//		System.out.println(problem1_replace("aren't"));
		
	}
}