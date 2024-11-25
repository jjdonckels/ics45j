package labs.lab8;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * Takes a generic list, and returns the reverse of the list, without modifying
	 * the original list.
	 * 
	 * @param <T> the type of element in the list
	 * @param a   the list to reverse
	 * 
	 * @return the reverse of the list
	 */
	// WRITE PROBLEM 1 METHOD HERE
	public static <T> List<T> problem1_reverse(List<T> a)
	{
		if (a.isEmpty()) return a;
		
		ArrayList<T> returnMe = new ArrayList<>();
		for (int i = a.size() - 1; i >= 0; --i)
			returnMe.add(a.get(i));
		
		return returnMe;
	}
	
	/**
	 * Takes as a parameter any object that implements the Iterable<E> interface, and 
	 * returns a  String containing its elements (whatever is returned by that 
	 * element's toString method), each one separated by a comma and a space. 
	 * 
	 * @param <T>		type of the iterable parameter
	 * @param <E>
	 * @param <E>		type of the elements contained in T
	 * @param iterable	object to get elements from
	 * 
	 * @return	a String containing iterable's elements (whatever is returned by that 
	 * element's toString method), each one separated by a comma and a space
	 */
	// WRITE PROBLEM 2 METHOD HERE
	public static <E, T extends Iterable<E>> String problem2_getElements(T iterable)
	{
		return "";
	}
}
