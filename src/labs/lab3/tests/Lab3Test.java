package labs.lab3.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import labs.lab3.*;


public class Lab3Test {
	
	private final double EPSILON = 1e-2;
	
	@Test
	public void problem1() {
		assertEquals("are not tests", Main.problem1_replace("are tests"));
		assertEquals("These are not tests.", Main.problem1_replace("These are tests."));
		assertEquals("These are not not tests.", Main.problem1_replace("These are not tests."));
		assertEquals("are not-are not", Main.problem1_replace("are-are"));
		assertEquals("These are not right", Main.problem1_replace("These are right"));
		assertEquals("I love Java!", Main.problem1_replace("I love Java!"));
		assertEquals("My favorite numbers are not3 and 5.", Main.problem1_replace("My favorite numbers are3 and 5."));
		assertEquals("I dare you", Main.problem1_replace("I dare you"));
		assertEquals("Double dare", Main.problem1_replace("Double dare"));
		assertEquals("area 51", Main.problem1_replace("area 51"));
		assertEquals("I cared too much!", Main.problem1_replace("I cared too much!"));
		assertEquals("", Main.problem1_replace(""));
		assertEquals("a r e scare are not dare share are not mare stare stared ared a ar re are not",
				Main.problem1_replace("a r e scare are dare share are mare stare stared ared a ar re are"));
		assertEquals("car", Main.problem1_replace("car"));
	}

    @Test
    public void problem2() {
        assertEquals(2, Main.problem2_maxBlock("hoopla"));
        assertEquals(3, Main.problem2_maxBlock("abbCCCddBBBxx"));
        assertEquals(1, Main.problem2_maxBlock("xyz"));
        assertEquals(2, Main.problem2_maxBlock("xxyz"));
        assertEquals(2, Main.problem2_maxBlock("xyzz"));
        assertEquals(3, Main.problem2_maxBlock("abbbcbbbxbbbx"));
        assertEquals(3, Main.problem2_maxBlock("XXBBBbbxx"));
        assertEquals(4, Main.problem2_maxBlock("XXBBBBbbxx"));
        assertEquals(4, Main.problem2_maxBlock("XXBBBbbxxXXXX"));
        assertEquals(4, Main.problem2_maxBlock("XX2222BBBbbXX2222"));
        assertEquals(0, Main.problem2_maxBlock(""));
    }
    
    @Test
    public void problem3() {
        assertEquals("ab", Main.problem3_sameEnds("abXYab"));
        assertEquals("x", Main.problem3_sameEnds("xx"));
        assertEquals("x", Main.problem3_sameEnds("xxx"));
        assertEquals("", Main.problem3_sameEnds("Robert"));
        assertEquals("", Main.problem3_sameEnds("Robertr"));
        assertEquals("R", Main.problem3_sameEnds("RobertR"));
    }
    
    @Test
    public void problem4() {
        DataSet data = new DataSet();
        data.add(40);
        data.add(12.5);
        data.add(-280.887);
        data.add(9);

        assertEquals(-219.387, data.getSum(), EPSILON);
        assertEquals(-54.84675, data.getAverage(), EPSILON);
        assertEquals(-280.887, data.getSmallest(), EPSILON);
        assertEquals(40, data.getLargest(), EPSILON);
        assertEquals(320.887, data.getRange(), EPSILON);
        assertEquals(4, data.getCount(), EPSILON);
        assertEquals(-280.887, data.getSmallest(), EPSILON);
        assertEquals(-280.887, data.getSmallest(), EPSILON);

        data.add(10);
        assertEquals(-209.387, data.getSum(), EPSILON);
        assertEquals(5, data.getCount(), EPSILON);
    }
    
	@Test
	public void problem5() {
		// Test case 1
		String input = "10\n5\n3\n2\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 20);
		
		String result = output.toString();
		assertEquals("People entering or leaving: " + "People in office: 10 | People entering or leaving: " +
				"People in office: 15 | People entering or leaving: " + "People in office: 18 | People entering or leaving: " +
				"People in office: 20 | Office is full", result);
		
		
		// Test case 2
		input = "3\n-2\n-2\n-5\n-1\n-1\n15\n-2\n8\n-8\n16\n14\n-1\n2\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 20);

		result = output.toString();
		assertEquals("People entering or leaving: " + 
				"People in office: 3 | People entering or leaving: "
				+ "People in office: 1 | People entering or leaving: "
				+ "People in office: 1 | People entering or leaving: "
				+ "People in office: 1 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 15 | People entering or leaving: "
				+ "People in office: 13 | People entering or leaving: "
				+ "People in office: 13 | People entering or leaving: "
				+ "People in office: 5 | People entering or leaving: "
				+ "People in office: 5 | People entering or leaving: "
				+ "People in office: 19 | People entering or leaving: "
				+ "People in office: 18 | People entering or leaving: "
				+ "People in office: 20 | Office is full",
				result);
		
		
		// Test case 3
		input = "500\n3000\n2583\n-60\n280\n10\n6\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 3309);

		result = output.toString();
		assertEquals("People entering or leaving: "
				+ "People in office: 500 | People entering or leaving: "
				+ "People in office: 500 | People entering or leaving: "
				+ "People in office: 3083 | People entering or leaving: "
				+ "People in office: 3023 | People entering or leaving: "
				+ "People in office: 3303 | People entering or leaving: "
				+ "People in office: 3303 | People entering or leaving: "
				+ "People in office: 3309 | Office is full",
				result);
		
		
		// Test case 4
		input = "5\n-5\n-2\n15\n7\n1\n0\n4\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 20);

		result = output.toString();
		assertEquals("People entering or leaving: "
				+ "People in office: 5 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 15 | People entering or leaving: "
				+ "People in office: 15 | People entering or leaving: "
				+ "People in office: 16 | People entering or leaving: "
				+ "People in office: 16 | People entering or leaving: "
				+ "People in office: 20 | Office is full",
				result);
	}
	
    @Test
    public void problem6() {
        assertArrayEquals(new int[]{1, 2}, Main.problem6_post3(new int[]{2, 3, 1, 2}));
        assertArrayEquals(new int[]{2}, Main.problem6_post3(new int[]{3, 1, 3, 2}));
        assertArrayEquals(new int[]{1, 2, 4}, Main.problem6_post3(new int[]{3, 3, 1, 2, 4}));
        assertArrayEquals(new int[]{}, Main.problem6_post3(new int[]{1, 3, 3}));
    }
    
	@Test
	public void problem7() {
		assertEquals("[1, 1, 2, 1, 2, 3]", Arrays.toString(Main.problem7_arrayPattern(3)));
		assertEquals("[1, 1, 2, 1, 2, 3, 1, 2, 3, 4]", Arrays.toString(Main.problem7_arrayPattern(4)));
		assertEquals("[1, 1, 2]", Arrays.toString(Main.problem7_arrayPattern(2)));
		assertEquals("[1]", Arrays.toString(Main.problem7_arrayPattern(1)));
		assertEquals("[]", Arrays.toString(Main.problem7_arrayPattern(0)));
		assertEquals("[1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6]", 
				Arrays.toString(Main.problem7_arrayPattern(6)));
	}
	
	@Test
	public void problem8() {
		
		// test case 1:
		double[][] heights1 = { 
				{ 0, 1, 2 },
				{ 2, 5, 6 },
				{ 3, -2, 0 }
		};
		Terrain terrain = new Terrain(heights1);
		char[][] floodMap1 = {
				{ '*', '*', '-' },
				{ '-', '-', '-' },
				{ '-', '*', '*' }
		};
		assertTrue(Arrays.deepEquals(floodMap1, terrain.getFloodMap(2)));
		
		
		// test case 2:
		char[][] floodMap2 = {
				{ '-', '-', '-' },
				{ '-', '-', '-' },
				{ '-', '*', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap2, terrain.getFloodMap(0)));

		
		// test case 3:
		char[][] floodMap3 = {
				{ '*', '*', '*' },
				{ '*', '*', '*' },
				{ '*', '*', '*' }
		};
		assertTrue(Arrays.deepEquals(floodMap3, terrain.getFloodMap(9)));

		
		// test case 4:
		char[][] floodMap4 = {
				{ '-', '-', '-' },
				{ '-', '-', '-' },
				{ '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap4, terrain.getFloodMap(-3)));
		
		
		// test case 5:
		double[][] heights2 = { 
				{ 0.3, 1.88, 2.0, 8.8 },
				{ 2, 0.005, 6.3, 8.2 },
				{ -68.34, -2, 0.0, -3.4 },
				{ 0, 4, 6.0, 9 }
		};
		terrain = new Terrain(heights2);
		char[][] floodMap5 = {
				{ '*', '*', '-', '-' },
				{ '-', '*', '-', '-' },
				{ '*', '*', '*', '*' },
				{ '*', '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap5, terrain.getFloodMap(2)));
		
		
		// test case 6:
		char[][] floodMap6 = {
				{ '-', '-', '-', '-' },
				{ '-', '-', '-', '-' },
				{ '*', '*', '-', '*' },
				{ '-', '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap6, terrain.getFloodMap(-0.02)));
		
		
		// test case 7:
		char[][] floodMap7 = {
				{ '*', '-', '-', '-' },
				{ '-', '*', '-', '-' },
				{ '*', '*', '*', '*' },
				{ '*', '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap7, terrain.getFloodMap(1.87)));
	}
	
	@Test
	public void problem9() {
		DailySalesTally tally = new DailySalesTally();
		tally.addPurchase(new Purchase("Day care", "Fluffy", 25.0, false));
		tally.addPurchase(new Purchase("Bow tie collar", "Carl", 15.75, true));
		assertEquals(25.0, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(14.96, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(0, tally.getTotalForClient("carl"), EPSILON);
		assertEquals(0, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(39.96, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Bath and blow dry", "Fluffy", 39.95, false));
		tally.addPurchase(new Purchase("Dog biscuits", "Carl", 6.25, true));
		assertEquals(60.96, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(20.3, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(81.26, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Nail trim", "Abby", 12.25, false));
		tally.addPurchase(new Purchase("Argyle sweater", "Roger", 99.99, true));
		assertEquals(188.5, tally.getGrandTotal(), EPSILON);
		assertEquals(60.96, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(20.3, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(12.25, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(94.99, tally.getTotalForClient("Roger"), EPSILON);
		assertEquals(188.5, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Bath and blow dry", "Carl", 39.95, false));
		tally.addPurchase(new Purchase("Dog booties", "Fluffy", 27.13, true));
		assertEquals(84.15, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(247.65, tally.getGrandTotal(), EPSILON);
		assertEquals(56.26, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(12.25, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(94.99, tally.getTotalForClient("Roger"), EPSILON);
		assertEquals(247.65, tally.getGrandTotal(), EPSILON);
		tally.addPurchase(new Purchase("Bowl of water", "Carl", 0, false));
		tally.addPurchase(new Purchase("Free treats", "Fluffy", 0, true));
		assertEquals(84.15, tally.getTotalForClient("Fluffy"), EPSILON);
		assertEquals(56.26, tally.getTotalForClient("Carl"), EPSILON);
		assertEquals(12.25, tally.getTotalForClient("Abby"), EPSILON);
		assertEquals(94.99, tally.getTotalForClient("Roger"), EPSILON);
		assertEquals(247.65, tally.getGrandTotal(), EPSILON);
	}
	
	@Test
	public void problem9_3() {
	    DailySalesTally tally = new DailySalesTally();
	    tally.addPurchase(new Purchase("Dog treats", "Lucy", 0.0, true));
	    tally.addPurchase(new Purchase("Day care", "Oscar", 25.0, false));
	    tally.addPurchase(new Purchase("Bow tie", "Lucy", 10.0, true));
	    tally.addPurchase(new Purchase("Grooming", "Oscar", 50.0, false));

	    assertEquals(8.55, tally.getTotalForClient("Lucy"), EPSILON);
	    assertEquals(70.0, tally.getTotalForClient("Oscar"), EPSILON);
	    assertEquals(78.55, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Free consultation", "Lucy", 0.0, false));
	    tally.addPurchase(new Purchase("Boutique toy", "Oscar", 15.0, true));

	    assertEquals(8.55, tally.getTotalForClient("Lucy"), EPSILON);
	    assertEquals(82.825, tally.getTotalForClient("Oscar"), EPSILON);
	    assertEquals(91.375, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Premium leash", "Lucy", 30.0, true));

	    assertEquals(34.2, tally.getTotalForClient("Lucy"), EPSILON);
	    assertEquals(117.025, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Nail trim", "Oscar", 15.0, false));

	    assertEquals(96.325, tally.getTotalForClient("Oscar"), EPSILON);
	    assertEquals(130.525, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Dog food", "Lucy", 25.0, false));

	    assertEquals(56.7, tally.getTotalForClient("Lucy"), EPSILON);
	    assertEquals(153.025, tally.getGrandTotal(), EPSILON);
	}
	
	@Test
	public void problem9_5() {
	    DailySalesTally tally = new DailySalesTally();
	    tally.addPurchase(new Purchase("Free collar", "Rocky", 0.0, true));
	    tally.addPurchase(new Purchase("Spa treatment", "Duke", 100.0, false));
	    tally.addPurchase(new Purchase("Boutique dog bed", "Rocky", 50.0, true));
	    tally.addPurchase(new Purchase("Dog biscuits", "Duke", 5.0, true));

	    assertEquals(42.75, tally.getTotalForClient("Rocky"), EPSILON);
	    assertEquals(104.275, tally.getTotalForClient("Duke"), EPSILON);
	    assertEquals(147.025, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Nail trim", "Rocky", 25.0, false));

	    assertEquals(65.25, tally.getTotalForClient("Rocky"), EPSILON);
	    assertEquals(169.525, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Free dog food", "Duke", 0.0, false));

	    assertEquals(104.275, tally.getTotalForClient("Duke"), EPSILON);
	    assertEquals(169.525, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Dog bandana", "Rocky", 15.0, true));

	    assertEquals(78.075, tally.getTotalForClient("Rocky"), EPSILON);
	    assertEquals(182.35, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Grooming", "Rocky", 40.0, false));

	    assertEquals(114.075, tally.getTotalForClient("Rocky"), EPSILON);
	    assertEquals(218.35, tally.getGrandTotal(), EPSILON);

	    tally.addPurchase(new Purchase("Dog toy", "Duke", 20.0, false));

	    assertEquals(122.275, tally.getTotalForClient("Duke"), EPSILON);
	    assertEquals(236.35, tally.getGrandTotal(), EPSILON);
	}
	
	@Test
	public void problem10() {
		Inventory inventory = new Inventory();
		assertEquals("No items under-stocked", inventory.getUnderstockReport());
		assertEquals("No items over-stocked", inventory.getOverstockReport());

		inventory.addOrUpdateItem(new Item("plaid bow tie collar", 10, 9));
		inventory.addOrUpdateItem(new Item("blue dog booties", 20, 20));
		inventory.addOrUpdateItem(new Item("pink dog booties", 20, 25));
		inventory.addOrUpdateItem(new Item("multi-colored leash", 5, 0));
		inventory.addOrUpdateItem(new Item("beige dog bed, x-large", 4, 0));
		inventory.addOrUpdateItem(new Item("rawhide bone, small", 50, 50));
		inventory.addOrUpdateItem(new Item("stuffed squirrel", 12, 16));
		assertEquals(
				"Order 1 more of plaid bow tie collar | Order 5 more of multi-colored leash | Order 4 more of beige dog bed, x-large",
				inventory.getUnderstockReport());
		assertEquals("pink dog booties over-stocked by 5 items | stuffed squirrel over-stocked by 4 items",
				inventory.getOverstockReport());

		inventory.removeItemWithDescription("multi-colored leash");
		inventory.removeItemWithDescription("purple harness");
		inventory.removeItemWithDescription("stuffed squirrel");
		assertEquals("Order 1 more of plaid bow tie collar | Order 4 more of beige dog bed, x-large",
				inventory.getUnderstockReport());
		assertEquals("pink dog booties over-stocked by 5 items", inventory.getOverstockReport());

		inventory.addOrUpdateItem(new Item("pink dog booties", 15, 15));
		inventory.addOrUpdateItem(new Item("plaid bow tie collar", 9, 10));
		inventory.addOrUpdateItem(new Item("beige dog bed, x-large", 1, 4));
		assertEquals("No items under-stocked", inventory.getUnderstockReport());
		assertEquals("plaid bow tie collar over-stocked by 1 items | beige dog bed, x-large over-stocked by 3 items",
				inventory.getOverstockReport());
	}
}
