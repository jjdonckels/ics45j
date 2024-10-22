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
		// str is empty
		if (str.isEmpty())
			return 0;
		
		int maxBlockLen = 0;
		int currBlockLen = 0;
		int currIndex = 0;
		
		// traverse each index of str, keeping track of current block length
		// when that block is finished, update max
		while (currIndex <= str.length() - 1)
		{
			char currChar = str.charAt(currIndex);
			currBlockLen = 1; // represents start of currChar block
			// step to next index until different char is encountered
			while (currIndex < str.length() - 1 && str.charAt(currIndex + 1) == currChar)
			{
				currBlockLen++;
				currIndex++;
			}
			
			// update max block length
			if (currBlockLen > maxBlockLen)
				maxBlockLen = currBlockLen;
			
			currIndex++; // move to next char
		}
		
		return maxBlockLen;
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
		if (str.length() <= 1)
			return "";
		
		int mid = str.length() / 2;
		
		int currIndex = mid;
		int maxLen = 0;
		
		// work from the middle of the string to the end,
		// checking if an identical substring starts at the beginning at each 
		// successive index, keeping track of the longest one to return
		while (currIndex < str.length())
		{ 
			String currSuffix = str.substring(currIndex);
			
			int testIndex = str.indexOf(currSuffix);
			
			if (testIndex == 0)
			{
				// this means currSuffix occurs at the beginning of the string 
				
				int currSuffixLen = currSuffix.length();
				// update maxLen 
				if (currSuffixLen > maxLen && currSuffixLen <= str.length() / 2)
					maxLen = currSuffixLen;
				
			}
			
			// move one index closer to the end of str
			currIndex++;
		}
		
		return str.substring(0, maxLen);
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
		int population = 0;
		System.out.print("People entering or leaving: ");
		int inputNum = in.nextInt();
		if (inputNum > 0)
			population += inputNum;
		
		while (population < capacity)
		{
			System.out.print("People in office: " + population + " | People entering or leaving: ");
			inputNum = in.nextInt();
			if (population + inputNum >= 0 && population + inputNum <= capacity)
				population += inputNum;			
		}
		
		System.out.print("People in office: " + population + " | Office is full");
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
		// find last occurrence of 3 in nums
		int targetIndex = nums.length - 1;
		while (nums[targetIndex] != 3)
			targetIndex--;
		
		// now target Index is at the 3 closest to the end of nums 
		int newSize = nums.length - 1 - targetIndex;
		
		int[] returnMe = new int[newSize];
		
		// fill up new array with all numbers after the last 3
		for (int i = targetIndex + 1; i < nums.length; i++)
		{
			returnMe[i - (targetIndex + 1)] = nums[i];
		}
		
		return returnMe;
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
		int[] returnMe = new int[n * (n + 1) / 2];
		int currIndex = 0;
		for (int i = 1; i <= n; ++i)
		{
			for (int j = 1; j <= i; ++j)
			{
				returnMe[currIndex++] = j;
			}
		}
		
		return returnMe;
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
		
//		Problem 2 test
//		System.out.println(problem2_maxBlock("hoopla"));
//		System.out.println(problem2_maxBlock("abbCCCddBBBxx"));
//		System.out.println(problem2_maxBlock(""));
//		System.out.println(problem2_maxBlock("abcdef"));
//		System.out.println(problem2_maxBlock("aaaabcdef"));
//		System.out.println(problem2_maxBlock("abcdefffff"));
//		System.out.println(problem2_maxBlock("aaabcdeffffff"));
//		System.out.println(problem2_maxBlock("aaaaaabcdeffff"));
//		System.out.println(problem2_maxBlock("111abcdef222233444444"));
//		System.out.println(problem2_maxBlock("word----------word again"));
		
//		Problem 3 test
//		System.out.println("abXYab " + problem3_sameEnds("abXYab"));
//		System.out.println("xx " + problem3_sameEnds("xx"));
//		System.out.println("xxx " + problem3_sameEnds("xxx"));
//		System.out.println("Robert " + problem3_sameEnds("Robert"));
//		System.out.println("Robertr " + problem3_sameEnds("Robertr"));
//		System.out.println("RobertR " + problem3_sameEnds("RobertR"));
//		System.out.println("    four     " + problem3_sameEnds("    four     ").length());
		
//		Problem 4 Test
//		DataSet data = new DataSet();
//		data.add(40);
//		data.add(12.5);
//		data.add(-280.887);
//		data.add(9);
//		System.out.println(data.getSum());
//		System.out.println(data.getAverage());
//		System.out.println(data.getSmallest());
//		System.out.println(data.getLargest());
//		System.out.println(data.getRange());
//		System.out.println(data.getCount());
//		data.add(10); 
//		System.out.println(data.getSum());
//		System.out.println(data.getCount());
		
//		Problem 5 test
//		problem5_officeCrowdControl(new Scanner(System.in), 20);
		
//		Problem 6 test
//		printArr(problem6_post3(new int[] {2, 3, 1, 2}));
//		printArr(problem6_post3(new int[] {3, 1, 3, 2}));
//		printArr(problem6_post3(new int[] {3, 3, 1, 2, 4}));
//		printArr(problem6_post3(new int[] {1, 3, 3}));
//		printArr(problem6_post3(new int[] {3, 0, 0, 1, 2, 2, 4}));
		
//		Problem 7 test
//		printArr(problem7_arrayPattern(3));
//		printArr(problem7_arrayPattern(4));
//		printArr(problem7_arrayPattern(2));
		
//		Problem 8 test
		double [][] heights1 = {
				{0, 1, 2}, 
				{2, 5, 6}, 
				{3, -2, 0}
		};
		
		Terrain map = new Terrain(heights1);
		print2D(map.getFloodMap(2));
		System.out.println();
		print2D(map.getFloodMap(0));
		System.out.println();
		print2D(map.getFloodMap(9));
		System.out.println();
		print2D(map.getFloodMap(-3));
		
		
		
		
		
	}
	
	private static void printArr(int[] arr)
	{
		if (arr.length == 0)
		{
			System.out.println("empty array");
			return;
		}
		for (int n : arr)
			System.out.print(n + " ");
		System.out.println();
	}
	
	private static void print2D(char[][] arr)
	{
		for (int i = 0; i < arr.length; ++i)
		{
			for (int j = 0; j < arr[0].length; ++j)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}