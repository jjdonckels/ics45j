package labs.lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> List<T> append(List<T> a, List<T> b)
	{
		ArrayList<T> newList = new ArrayList<>();
		
		// loop through a and add elements to new list
		for (int i = 0; i < a.size(); ++i)
			newList.add(a.get(i));
		
		// loop through b and add elements to new list behind those from a
		for (int i = 0; i < b.size(); ++i)
			newList.add(b.get(i));
		
		return newList;
	}


	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 * 
	 * @return a new array containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> T[] append(T[] a, T[] b)
	{
		T[] newArr = Arrays.copyOf(a, a.length + b.length);
		
		// newArr was copied with the elements of a but the length of both a and b
		// so now we can append b to the back and return it
		
		for (int i = 0; i < b.length; ++i)
		{
			newArr[i + a.length] = b[i]; 
		}
		
		return newArr;
	}

}