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
		return false; // FIX ME
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
		return -1; // FIX ME
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
		return -1; // FIX ME
	}
}