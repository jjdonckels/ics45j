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
	 * Gets all permutations of the list.
	 */
	public List<List<E>> getPermutations() {
		List<List<E>> result = new ArrayList<>();
		
		// empty list has a single permutation: itself
		if (list.size() == 0)
		{
			result.add(list);
			return result;
		}
		
		// loop through all list elements
		for (int i = 0; i < list.size(); ++i)
		{
			List<E> shorter = new ArrayList<>();
			// form a shorter list by removing the ith element
			for (int j = 0; j < list.size(); ++j)
			{
				if (j != i) 
				{
					shorter.add(list.get(j));
				}
			}
			
			// DEBUG
			// System.out.println("original: " + list);
			// System.out.println("shorter: " + shorter);
			
			// generate all permutations of the shorter list
			PermutationGenerator<E> shorterPermutationGenerator = new PermutationGenerator(shorter);
			List<List<E>> shorterPermutations = shorterPermutationGenerator.getPermutations();
			
			// add the removed element to the front of each permutation of the shorter list:
			for (List<E> elmnt : shorterPermutations)
			{
				ArrayList<E> temp = new ArrayList<>();
				for (int p = 0; p < elmnt.size(); ++p)
				{
					temp.add(elmnt.get(p));
				}
				temp.add(0, list.get(i));
				result.add(temp);
			}
		}
		
		// return all permutations
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
