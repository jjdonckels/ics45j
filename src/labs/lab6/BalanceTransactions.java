package labs.lab6;

/**
 * A utility class for validating the cash on hand amount at the end of the day with the 
 * amount recorded in a file
 */

public class BalanceTransactions {

	/**
	 * Given a starting balance (amount of cash at the beginning of the day) and an
	 * ending balance (amount of cash at the end of the day), checks whether the
	 * actual amount of cash at the end of the day equals the expected value (within
	 * an 1E-3 error margin)
	 * 
	 * @param startBalance amount of cash at the beginning of the day; assume always
	 *                     >= 0
	 * @param endBalance   amount of cash at the end of the day
	 * @param filename     name of file containing transactions
	 * 
	 * @return a string indicating whether the end of day total was balanced or not
	 *         (either "End of day total is properly balanced." or "End of day total
	 *         is not balanced."
	 */
	public static String balance(double startBalance, double endBalance, String filename) {
		return ""; // FIX ME
	}
}
