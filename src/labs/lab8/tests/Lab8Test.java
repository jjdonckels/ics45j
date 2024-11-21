package labs.lab8.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import labs.lab8.*;

import org.junit.Test;


public class Lab8Test {

    @Test
    public void problem1() {
		List<String> strList = new ArrayList<>();
		strList.add("apple");
		strList.add("orange");
		strList.add("pear");
		strList.add("banana");
		List<String> expStrListRev = Arrays.asList("banana", "pear", "orange", "apple");
		assertEquals(expStrListRev, Main.problem1_reverse(strList));
		List<String> expStrList = Arrays.asList("apple", "orange", "pear", "banana");
		assertEquals(expStrList, strList);

		List<Integer> intList = new ArrayList<>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		List<Integer> expIntListRev = Arrays.asList(4, 3, 2, 1, 0);
		assertEquals(expIntListRev, Main.problem1_reverse(intList));
		List<Integer> expIntList = Arrays.asList(0, 1, 2, 3, 4);
		assertEquals(expIntList, intList);
		
		List<Double> dblList = new ArrayList<>();
		dblList.add(1.5);
		dblList.add(2.5);
		dblList.add(3.5);
		dblList.add(4.5);
		List<Double> expDblListRev = Arrays.asList(4.5, 3.5, 2.5, 1.5);
		assertEquals(expDblListRev, Main.problem1_reverse(dblList));
		List<Double> expDblList = Arrays.asList(1.5, 2.5, 3.5, 4.5);
		assertEquals(expDblList, dblList);
    }
    
    @Test
    public void problem2() {
        String sentence = "Mary had a little lamb";
        Iterable<String> it = Arrays.asList(sentence.split(" "));
        assertEquals("Mary, had, a, little, lamb", Main.problem2_getElements(it));
       
		assertEquals("3, 12, 78, 45, 44", Main.problem2_getElements(Arrays.asList(3, 12, 78, 45, 44)));
    }
    
	@Test
	public void problem3() {
		List<String> list = new ArrayList<>();
		list.add("e");
		list.add("a");
		list.add("t");
		PermutationGenerator<String> generator1 = new PermutationGenerator<>(list);
		List<List<String>> permutations1 = generator1.getPermutations();
		assertEquals(Arrays.asList(new String[] { "e", "a", "t" }), permutations1.get(0));
		assertEquals(Arrays.asList(new String[] { "e", "t", "a" }), permutations1.get(1));
		assertEquals(Arrays.asList(new String[] { "a", "e", "t" }), permutations1.get(2));
		assertEquals(6, permutations1.size());

		list = new ArrayList<>();
		list.add("Robert");
		list.add("is");
		list.add("the");
		list.add("best");
		generator1 = new PermutationGenerator<>(list);
		permutations1 = generator1.getPermutations();
		assertEquals(Arrays.asList(new String[] { "Robert", "best", "the", "is" }), permutations1.get(5));
		assertEquals(Arrays.asList(new String[] { "is", "the", "best", "Robert" }), permutations1.get(9));
		assertEquals(Arrays.asList(new String[] { "best", "the", "is", "Robert" }), permutations1.get(23));
		assertEquals(24, permutations1.size());

		List<Integer> nums1 = Arrays.asList(new Integer[] { 5, 0 });
		PermutationGenerator<Integer> generator2 = new PermutationGenerator<>(nums1);
		List<List<Integer>> permutations2 = generator2.getPermutations();
		assertEquals(Arrays.asList((new Integer[] { 5, 0 })), permutations2.get(0));
		assertEquals(Arrays.asList((new Integer[] { 0, 5 })), permutations2.get(1));
		assertEquals(2, permutations2.size());

		List<Integer> nums2 = Arrays.asList(new Integer[] { 5 });
		PermutationGenerator<Integer> generator3 = new PermutationGenerator<>(nums2);
		List<List<Integer>> permutations3 = generator3.getPermutations();
		assertEquals(Arrays.asList((new Integer[] { 5 })), permutations3.get(0));
		assertEquals(1, permutations3.size());

		List<Integer> nums3 = Arrays.asList(new Integer[] { 5, 10, 15, 20, 25, 30 });
		PermutationGenerator<Integer> generator4 = new PermutationGenerator<>(nums3);
		List<List<Integer>> permutations4 = generator4.getPermutations();
		assertEquals(Arrays.asList(new Integer[] { 5, 10, 15, 20, 25, 30 }), permutations4.get(0));
		assertEquals(Arrays.asList(new Integer[] { 5, 10, 15, 20, 30, 25 }), permutations4.get(1));
		assertEquals(Arrays.asList(new Integer[] { 5, 10, 15, 25, 20, 30 }), permutations4.get(2));
		assertEquals(720, permutations4.size());
	}
	
	@Test
	public void problem4() {
		String[] words = { "Mary", "had", "a", "little", "lamb" };
		SelectionSorter<String> strSorter = new SelectionSorter<String>(words);
		strSorter.sort();
		String[] expectedStrs = { "Mary", "a", "had", "lamb", "little" };
		assertTrue(Arrays.equals(expectedStrs, words));

		Integer[] ints = { 13, 18, 2, 9823, 998, 187, -298, 30, 0, -98, 1, 30, 18 };
		SelectionSorter<Integer> intSorter = new SelectionSorter<Integer>(ints);
		intSorter.sort();
		Integer[] expectedInts = { -298, -98, 0, 1, 2, 13, 18, 18, 30, 30, 187, 998, 9823 };
		assertTrue(Arrays.equals(expectedInts, ints));

		Double[] doubles = { 46.2, -88.032, 0.01, 0.02, 1.0, 18.0, -18.0, -46.2, 0.02, -18.0, 23.697 };
		SelectionSorter<Double> doubleSorter = new SelectionSorter<Double>(doubles);
		doubleSorter.sort();
		Double[] expectedDoubles = { -88.032, -46.2, -18.0, -18.0, 0.01, 0.02, 0.02, 1.0, 18.0, 23.697, 46.2 };
		assertTrue(Arrays.equals(expectedDoubles, doubles));
	}

	@Test
	public void problem5() {
		List<String> a = Arrays.asList("apple", "orange");
		List<String> b = Arrays.asList("pear", "banana");
		List<String> c = Appender.append(a, b);
		assertEquals(Arrays.asList("apple", "orange"), a);
		assertEquals(Arrays.asList("pear", "banana"), b);
		assertEquals(Arrays.asList("apple", "orange", "pear", "banana"), c);

		List<Integer> intList1 = Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0);
		List<Integer> intList2 = Arrays.asList(-8, 19, 4, 0, 20);
		List<Integer> intList3 = Appender.append(intList1, intList2);
		assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0), intList1);
		assertEquals(Arrays.asList(-8, 19, 4, 0, 20), intList2);
		assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4, 0, 20), intList3);

		List<Double> dblList1 = Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0);
		List<Double> dblList2 = Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0);
		List<Double> dblList3 = Appender.append(dblList1, dblList2);
		assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0), dblList1);
		assertEquals(Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0), dblList2);
		assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0),
				dblList3);

		String[] d = { "apple", "orange" };
		String[] e = { "pear", "banana" };
		String[] f = Appender.append(d, e);
		assertTrue(Arrays.equals(new String[] { "apple", "orange" }, d));
		assertTrue(Arrays.equals(new String[] { "pear", "banana" }, e));
		assertTrue(Arrays.equals(new String[] { "apple", "orange", "pear", "banana" }, f));

		Integer[] intArr1 = { 3, 13, 44, 18, 987, -29, -3, 0 };
		Integer[] intArr2 = { -8, 19, 4, 0, 20 };
		Integer[] intArr3 = Appender.append(intArr1, intArr2);
		assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0 }, intArr1));
		assertTrue(Arrays.equals(new Integer[] { -8, 19, 4, 0, 20 }, intArr2));
		assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4, 0, 20 }, intArr3));

		Double[] dblArr1 = { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0 };
		Double[] dblArr2 = { -0.0008, 1.9, 4.2, 0.0, 2.0 };
		Double[] dblArr3 = Appender.append(dblArr1, dblArr2);
		assertTrue(Arrays.equals(new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0 }, dblArr1));
		assertTrue(Arrays.equals(new Double[] { -0.0008, 1.9, 4.2, 0.0, 2.0 }, dblArr2));
		assertTrue(Arrays.equals(
				new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0 },
				dblArr3));

	}
}
