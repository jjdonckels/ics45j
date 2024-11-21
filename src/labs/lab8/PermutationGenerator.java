package labs.lab8;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates permutations of a string.
 */
public class PermutationGenerator<E> {

	private List<E> list;

	/**
	 * Constructs a permutation generator.
	 * 
	 * @param str the string to permute, must have length > 0
	 */
	public PermutationGenerator(List<E> list) {
		this.list = list;
	}


	/**
	 * Gets all permutations of the string.
	 */
	public List<List<E>> getPermutations() {
		List<List<E>> result = new ArrayList<>();
		
		return result;

//		// The empty string has a single permutation: itself
//		if (word.length() == 0) {
//			result.add(word);
//			return result;
//		}
//
//		// Loop through all character positions:
//		for (int i = 0; i < word.length(); i++) {
//			
//			// Form a shorter word by removing the ith character
//			String shorter = word.substring(0, i) + word.substring(i + 1);
//
//			// Generate all permutations of the simpler word
//			PermutationGenerator shorterPermutationGenerator = new PermutationGenerator(shorter);
//			List<String> shorterWordPermutations = shorterPermutationGenerator.getPermutations();
//
//			// Add the removed character to the front of
//			// each permutation of the simpler word:
//			for (String s : shorterWordPermutations) {
//				result.add(word.charAt(i) + s);
//			}
//		}
//		// Return all permutations:
//		return result;
	}


	public static void main(String[] args) {
//		PermutationGenerator generator = new PermutationGenerator("eat");
//		for (String s : generator.getPermutations()) {
//			System.out.println(s);
//		}
		/*
		 * Above prints out:
		 * eat
		 * eta
		 * aet
		 * ate
		 * tea
		 * tae
		 */
	}

}
