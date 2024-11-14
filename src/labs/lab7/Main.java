package labs.lab7;

public class Main {

	/**
	 * Given a string and a non-empty substring (sub), computes recursively if at least n copies of sub 
	 * appear in the string somewhere, possibly with overlapping.
	 * 
	 * @param str	the string to check for copies
	 * @param sub	the substring to look for in the string
	 * @param n		the number of copies to look for in the string (will always be non-negative)
	 * @return		true if at least n copies of sub appear in the string somewhere, with overlapping
	 */
	public static boolean problem1_countCopies(String str, String sub, int n) {
		// base case empty string and no substrings found
		if (str.isEmpty()) return false;
		
		// base case n == 0 and substring not expected in str
		if (n == 0) return true;
		
		
		int subIndex = str.indexOf(sub);
		if (subIndex >= 0)
		{
			// base case at least one substring found
			if (n == 1) return true;
			
			return problem1_countCopies(str.substring(subIndex + 1), sub, n - 1);
		}
		
		return false;
		
		
		
	}
	
	
	/**
	 * Given a string, compute recursively the number of times lowercase "hi"
	 * appears in the string, however do not count "hi"s that have an 'x' immedately
	 * before them.
	 * 
	 * @param str the string in which to count occurrences of "hi"
	 * 
	 * @return the number of times lowercase "hi" (without an 'x' immediately before
	 *         it) appears in the string, however do
	 */	
	public static int problem2_countHis(String str) {
		// base case empty string or not enough characters to write "hi"
		if (str.length() <= 1) return 0;
		
		int targetIndex = str.indexOf("hi");
		
		if (targetIndex < 0) return 0;
		
		if (targetIndex > 0 && str.charAt(targetIndex - 1) == 'x')
		{
			// check out of bounds (no hi's left to find)
			if (targetIndex + 2 > str.length() - 1) return 0;
			
			return 0 + problem2_countHis(str.substring(targetIndex + 2));
		}
			
		// we found a "hi" without 'x' in front so we count it 
		// check out of bounds (no hi's left to find)
		if (targetIndex + 2 > str.length() - 1) return 1;
		
		return 1 + problem2_countHis(str.substring(targetIndex + 2));
	}
	
	
	/**
	 * Given an array of ints, compute recursively the number of times that the
	 * value 11 appears in the array. We'll use the convention of considering only
	 * the part of the array that begins at the given index. In this way, a
	 * recursive call can pass index+1 to move down the array. The initial call will
	 * pass in index as 0.
	 * 
	 * @param nums  the array of ints
	 * @param index starting index at which to consider the part of the array
	 * 
	 * @return the number of times the value 11 appears in the array
	 */
	public static int problem3_countElevens(int[] nums, int index) {
		// base case
		if (index == nums.length) return 0;
		
		if (nums[index] == 11) return 1 + problem3_countElevens(nums, index + 1);
		
		return problem3_countElevens(nums, index + 1);
	}
	
	public static void main(String[] args) 
	{
//		Problem 1 test
//		System.out.println(problem1_countCopies("catcowcat", "cat", 2));
//		System.out.println(problem1_countCopies("catcowcat", "cow", 2));
//		System.out.println(problem1_countCopies("catcowcat", "cat", 1));
		
//		Problem 2 test
		System.out.println(problem2_countHis("ahixhi"));
		System.out.println(problem2_countHis("ahibhi"));
		System.out.println(problem2_countHis("xhixhi"));
		
	}
}