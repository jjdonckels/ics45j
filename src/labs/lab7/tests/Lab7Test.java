package labs.lab7.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import labs.lab7.*;


public class Lab7Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertTrue(Main.problem1_countCopies("catcowcat", "cat", 2));
		assertFalse(Main.problem1_countCopies("catcowcat", "cow", 2));
		assertTrue(Main.problem1_countCopies("catcowcat", "cow", 1));
		assertTrue(Main.problem1_countCopies("iiijjj", "i", 3));
		assertFalse(Main.problem1_countCopies("iiijjj", "i", 4));
		assertTrue(Main.problem1_countCopies("iiijjj", "ii", 2));
		assertFalse(Main.problem1_countCopies("iiijjj", "ii", 3));
		assertFalse(Main.problem1_countCopies("iiijjj", "x", 3));
		assertTrue(Main.problem1_countCopies("iiijjj", "x", 0));
		assertTrue(Main.problem1_countCopies("iiiiij", "iii", 3));
		assertFalse(Main.problem1_countCopies("iiiiij", "iii", 4));
		assertTrue(Main.problem1_countCopies("ijiiiiij", "iiii", 2));
		assertFalse(Main.problem1_countCopies("ijiiiiij", "iiii", 3));
		assertTrue(Main.problem1_countCopies("dogcatdogcat", "dog", 2));
	}

	@Test
	public void problem2() {
		assertEquals(1, Main.problem2_countHis("ahixhi"));
		assertEquals(2, Main.problem2_countHis("ahibhi"));
		assertEquals(0, Main.problem2_countHis("xhixhi"));
		assertEquals(1, Main.problem2_countHis("hixhi"));
		assertEquals(2, Main.problem2_countHis("hixhhi"));
		assertEquals(3, Main.problem2_countHis("hihihi"));
		assertEquals(3, Main.problem2_countHis("hihihix"));
		assertEquals(2, Main.problem2_countHis("xhihihix"));
		assertEquals(0, Main.problem2_countHis("xxhi"));
		assertEquals(1, Main.problem2_countHis("hixxhi"));
		assertEquals(1, Main.problem2_countHis("hi"));
		assertEquals(0, Main.problem2_countHis("xxxx"));
		assertEquals(0, Main.problem2_countHis("h"));
		assertEquals(0, Main.problem2_countHis("x"));
		assertEquals(0, Main.problem2_countHis(""));
		assertEquals(1, Main.problem2_countHis("Hellohi"));
	}
	
	@Test
	public void problem3() {
		assertEquals(1, Main.problem3_countElevens(new int[] { 1, 2, 11 }, 0));
		assertEquals(2, Main.problem3_countElevens(new int[] { 11, 11 }, 0));
		assertEquals(0, Main.problem3_countElevens(new int[] { 1, 2, 3, 4 }, 0));
		assertEquals(3, Main.problem3_countElevens(new int[] { 1, 11, 3, 11, 11 }, 0));
		assertEquals(1, Main.problem3_countElevens(new int[] { 11 }, 0));
		assertEquals(0, Main.problem3_countElevens(new int[] { 1 }, 0));
		assertEquals(0, Main.problem3_countElevens(new int[] {}, 0));
		assertEquals(2, Main.problem3_countElevens(new int[] { 11, 2, 3, 4, 11, 5 }, 0));
		assertEquals(2, Main.problem3_countElevens(new int[] { 11, 5, 11 }, 0));
	}
	
	@Test
	public void problems4Through5() {
		PurchaseHistory history = new PurchaseHistory();
		history.addPurchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00);
		history.addPurchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99);
		history.addPurchase(LocalDate.of(2021, 12, 31), "Champagne", 18.50);
		history.addPurchase(LocalDate.of(2022, 1, 2), "Takeout food", 57.89);
		history.addPurchase(LocalDate.of(2022, 1, 2), "Takeout food", 7.89);
		history.addPurchase(LocalDate.of(2022, 1, 2), "Takeout food", 98.17);
		history.addPurchase(LocalDate.of(2021, 3, 1), "Cable/Internet bill", 243.00);
		history.addPurchase(LocalDate.of(2021, 2, 19), "Cell phone bill", 78.53);
		history.addPurchase(LocalDate.of(2021, 7, 28), "Rent", 2000.00);
		history.addPurchase(LocalDate.of(2022, 4, 18), "Gas", 74.33);
		history.addPurchase(LocalDate.of(2022, 4, 18), "Gas", 74.33);
		history.addPurchase(LocalDate.of(2022, 4, 18), "Takeout food", 196.31);
		history.addPurchase(LocalDate.of(2021, 11, 23), "New running shoes", 72.10);
		history.addPurchase(LocalDate.of(2021, 9, 19), "Life insurance", 110.00);
		history.addPurchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99);
		history.addPurchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.00);

		// PurchaseHistory.toString():
		String expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 57.89, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		// removing purchases:
		assertEquals(1, history.removePurchase(LocalDate.of(2022, 1, 2), "Takeout food", 57.89));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		assertEquals(0, history.removePurchase(LocalDate.of(2022, 4, 19), "Gas", 74.33));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		assertEquals(0, history.removePurchase(LocalDate.of(2022, 4, 18), "Gas", 74.34));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31, 2022-04-18 Gas 74.33, 2022-04-18 Gas 74.33";
		assertEquals(expectedPHStr, history.toString());

		assertEquals(2, history.removePurchase(LocalDate.of(2022, 4, 18), "Gas", 74.33));
		expectedPHStr = "2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-04-18 Takeout food 196.31";
		assertEquals(expectedPHStr, history.toString());

		// getting all purchases in a date range:
		List<Purchase> expList2020 = Arrays.asList(
				new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.0),
				new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99));
		List<Purchase> actualList2020 = history.getPurchasesInDateRange(LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 12, 31));
		assertEquals(expList2020, actualList2020);

		List<Purchase> expListDec2021 = Arrays.asList(
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00),
				new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 18.5));
		List<Purchase> actualListDec2021 = history.getPurchasesInDateRange(LocalDate.of(2021, 12, 1),
				LocalDate.of(2021, 12, 31));
		assertEquals(expListDec2021, actualListDec2021);

		List<Purchase> expListDec19_2021 = Arrays.asList(
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00));
		List<Purchase> actualListDec19_2021 = history.getPurchasesInDateRange(LocalDate.of(2021, 12, 19),
				LocalDate.of(2021, 12, 19));
		assertEquals(expListDec19_2021, actualListDec19_2021);

		List<Purchase> expListMay2022 = Arrays.asList();
		List<Purchase> actualListMay2022 = history.getPurchasesInDateRange(LocalDate.of(2022, 5, 1),
				LocalDate.of(2022, 5, 31));
		assertEquals(expListMay2022, actualListMay2022);

		// add a couple of more purchases:
		history.addPurchase(LocalDate.of(2021, 12, 19), "Christmas tree", 64.00);
		history.addPurchase(LocalDate.of(2021, 12, 31), "Champagne", 1358.44);
		history.addPurchase(LocalDate.of(2019, 1, 19), "Movies", 36.12);
		history.addPurchase(LocalDate.of(2022, 2, 1), "boba", 4.95);
		history.addPurchase(LocalDate.of(2022, 2, 28), "boba", 4.95);
		expectedPHStr = "2019-01-19 Movies 36.12, 2020-08-22 Church charitable gift 100.0, 2020-09-30 Pet insurance 44.99, 2021-02-19 Cell phone bill 78.53, 2021-03-01 Cable/Internet bill 243.0, 2021-07-28 Rent 2000.0, 2021-09-19 Life insurance 110.0, 2021-11-23 New running shoes 72.1, 2021-12-19 Christmas tree 64.0, 2021-12-19 Christmas jammies for Robert 19.99, 2021-12-19 Christmas pillow for Robert 10.0, 2021-12-31 Champagne 1358.44, 2021-12-31 Champagne 18.5, 2022-01-02 Takeout food 98.17, 2022-01-02 Takeout food 7.89, 2022-02-01 boba 4.95, 2022-02-28 boba 4.95, 2022-04-18 Takeout food 196.31";
		assertEquals(expectedPHStr, history.toString());

		// getting purchase total in date range:
		assertEquals(9.9, history.getPurchaseTotalInDateRange(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 28)),
				EPSILON);
		assertEquals(36.12, history.getPurchaseTotalInDateRange(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 6, 30)),
				EPSILON);
		assertEquals(1470.93,
				history.getPurchaseTotalInDateRange(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31)), EPSILON);
		assertEquals(0, history.getPurchaseTotalInDateRange(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 12, 31)),
				EPSILON);
		assertEquals(4467.94, history.getPurchaseTotalInDateRange(LocalDate.of(2019, 1, 1), LocalDate.of(2023, 12, 31)),
				EPSILON);

		// getting purchases matching description:
		history.addPurchase(LocalDate.of(2022, 2, 1), "boba", 8.95);
		List<Purchase> expList = Arrays.asList(new Purchase(LocalDate.of(2022, 2, 1), "boba", 8.95),
				new Purchase(LocalDate.of(2022, 2, 1), "boba", 4.95),
				new Purchase(LocalDate.of(2022, 2, 28), "boba", 4.95));
		assertEquals(expList, history.getPurchasesMatchingDescription("boba"));

		assertEquals(new ArrayList<Purchase>(), history.getPurchasesMatchingDescription("Home Depot stuff"));

		expList = Arrays.asList(new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99));
		assertEquals(expList, history.getPurchasesMatchingDescription("Pet insurance"));

		// getting purchase total matching description:
		history.removePurchase(LocalDate.of(2022, 2, 1), "boba", 4.95);
		assertEquals(13.9, history.getPurchaseTotalMatchingDescription("boba"), EPSILON);
		assertEquals(78.53, history.getPurchaseTotalMatchingDescription("Cell phone bill"), EPSILON);
		assertEquals(302.37, history.getPurchaseTotalMatchingDescription("Takeout food"), EPSILON);
		assertEquals(0.0, history.getPurchaseTotalMatchingDescription("Groceries"), EPSILON);

		// getting all purchases in an amount range:
		List<Purchase> cheapPurchasesExp = Arrays.asList(
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas jammies for Robert", 19.99),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00),
				new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 18.5),
				new Purchase(LocalDate.of(2022, 1, 2), "Takeout food", 7.89),
				new Purchase(LocalDate.of(2022, 2, 1), "boba", 8.95),
				new Purchase(LocalDate.of(2022, 2, 28), "boba", 4.95));
		List<Purchase> cheapPurchasesActual = history.getPurchasesInAmountRange(1, 20);
		assertEquals(cheapPurchasesExp, cheapPurchasesActual);

		List<Purchase> mediumPurchasesExp = Arrays.asList(new Purchase(LocalDate.of(2019, 1, 19), "Movies", 36.12),
				new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.00),
				new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99),
				new Purchase(LocalDate.of(2021, 2, 19), "Cell phone bill", 78.53),
				new Purchase(LocalDate.of(2021, 11, 23), "New running shoes", 72.10),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas tree", 64.00),
				new Purchase(LocalDate.of(2022, 1, 2), "Takeout food", 98.17));
		List<Purchase> mediumPurchasesActual = history.getPurchasesInAmountRange(20, 100);
		assertEquals(mediumPurchasesExp, mediumPurchasesActual);

		List<Purchase> expensivePurchasesExp = Arrays.asList(
				new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.00),
				new Purchase(LocalDate.of(2021, 3, 1), "Cable/Internet bill", 243.00),
				new Purchase(LocalDate.of(2021, 7, 28), "Rent", 2000.00),
				new Purchase(LocalDate.of(2021, 9, 19), "Life insurance", 110.00),
				new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 1358.44),
				new Purchase(LocalDate.of(2022, 4, 18), "Takeout food", 196.31));
		List<Purchase> expensivePurchasesActual = history.getPurchasesInAmountRange(100, 2000);
		assertEquals(expensivePurchasesExp, expensivePurchasesActual);

		assertEquals(new ArrayList<Purchase>(), history.getPurchasesInAmountRange(2000.01, 100000));

		// getting purchase totals in an amount range:
		assertEquals(70.28, history.getPurchaseTotalInAmountRange(1, 20), EPSILON);
		assertEquals(493.91, history.getPurchaseTotalInAmountRange(20, 100), EPSILON);
		assertEquals(4007.75, history.getPurchaseTotalInAmountRange(100, 2000), EPSILON);
		assertEquals(0, history.getPurchaseTotalInAmountRange(2000.01, 100000), EPSILON);
		assertEquals(36.12, history.getPurchaseTotalInAmountRange(36.12, 36.12), EPSILON);

		// getting max purchase in date range:
		expList = Arrays.asList(new Purchase(LocalDate.of(2020, 8, 22), "Church charitable gift", 100.0));
		List<Purchase> actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 12, 31));
		assertEquals(expList, actualList);

		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 31), "Champagne", 1358.44));
		actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31));
		assertEquals(expList, actualList);

		history.addPurchase(LocalDate.of(2021, 12, 19), "Canidae dog food for Robert", 64.00);
		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 19), "Canidae dog food for Robert", 64.00),
				new Purchase(LocalDate.of(2021, 12, 19), "Christmas tree", 64.00));
		actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2021, 12, 19), LocalDate.of(2021, 12, 19));
		assertEquals(expList, actualList);

		actualList = history.getMaxPurchaseInDateRange(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 31));
		assertEquals(new ArrayList<Purchase>(), actualList);

		// getting min purchase in date range:
		expList = Arrays.asList(new Purchase(LocalDate.of(2020, 9, 30), "Pet insurance", 44.99));
		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31));
		assertEquals(expList, actualList);

		history.addPurchase(LocalDate.of(2021, 12, 2), "mints", 0.5);
		history.addPurchase(LocalDate.of(2021, 12, 1), "gum", 0.5);
		history.addPurchase(LocalDate.of(2021, 12, 2), "gum", 0.5);

		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 1), "gum", 0.5),
				new Purchase(LocalDate.of(2021, 12, 2), "gum", 0.5),
				new Purchase(LocalDate.of(2021, 12, 2), "mints", 0.5));
		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 31));
		assertEquals(expList, actualList);

		expList = Arrays.asList(new Purchase(LocalDate.of(2021, 12, 19), "Christmas pillow for Robert", 10.00));
		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2021, 12, 19), LocalDate.of(2021, 12, 19));
		assertEquals(expList, actualList);

		actualList = history.getMinPurchaseInDateRange(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 31));
		assertEquals(new ArrayList<Purchase>(), actualList);
	}
	
	@Test
	public void problems6and7() {
		Driveway driveway = new Driveway();
		assertEquals(Arrays.asList("Driveway: 1", "Street: "), driveway.add(1));
		assertEquals(Arrays.asList("Driveway: 1 2", "Street: "), driveway.add(2));
		assertEquals(Arrays.asList("Driveway: 1 2 3", "Street: "), driveway.add(3));
		assertEquals(Arrays.asList("That car is already in the driveway."), driveway.add(3));
		assertEquals(Arrays.asList("Driveway: 1 2 3 4", "Street: "), driveway.add(4));
		assertEquals(Arrays.asList("Driveway: 1 2 3", "Street: 4", "Driveway: 1 2", "Street: 4 3", "Driveway: 1 3",
				"Street: 4", "Driveway: 1 3 4", "Street: "), driveway.remove(2));
		assertEquals(Arrays.asList("Driveway: 1 3", "Street: "), driveway.remove(4));
		assertEquals(Arrays.asList("Driveway: 1 3 5", "Street: "), driveway.add(5));
		assertEquals(Arrays.asList("Driveway: 1 3 5 6", "Street: "), driveway.add(6));
		assertEquals(Arrays.asList("Driveway: 1 3 5", "Street: 6", "Driveway: 1 3", "Street: 6 5", "Driveway: 1",
				"Street: 6 5 3", "Driveway: 3", "Street: 6 5", "Driveway: 3 5", "Street: 6", "Driveway: 3 5 6",
				"Street: "), driveway.remove(1));
		assertEquals(Arrays.asList("That car is not in the driveway."), driveway.remove(1));
	}
	
	@Test
	public void problem8() {
		EmergencyRoom er = new EmergencyRoom();

		er.addPatient(Injury.ABDOMINAL_PAIN, "18 year old says stomach hurts");
		er.addPatient(Injury.BURN, "Person burned hand while cooking dinner");
		er.addPatient(Injury.CHEST_PAIN, "63 year old has chest pain");
		er.addPatient(Injury.FRACTURE, "10 year old hurt knee while playing soccer, possible fracture");
		er.addPatient(Injury.HEMORRHAGE, "23 year old complaining of paper cut");
		er.addPatient(Injury.OTHER, "UCI student with a hangnail");

		assertEquals(Injury.HEMORRHAGE, er.nextPatient().getInjury());

		Patient p = er.nextPatient();
		assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

		p = er.nextPatient();
		assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

		p = er.nextPatient();
		assertTrue(p.getInjury().equals(Injury.FRACTURE) || p.getInjury().equals(Injury.ABDOMINAL_PAIN));

		p = er.nextPatient();
		assertTrue(p.getInjury().equals(Injury.FRACTURE) || p.getInjury().equals(Injury.ABDOMINAL_PAIN));

		assertEquals(Injury.OTHER, er.nextPatient().getInjury());

		assertNull(er.nextPatient());

		er.addPatient(Injury.OTHER, "45 year old complains of a runny nose");
		er.addPatient(Injury.SEIZURE, "person having a seizure");
		er.addPatient(Injury.ABDOMINAL_PAIN,
				"UCI student complains of stomach pain after participating in a hot dog eating contest");
		er.addPatient(Injury.SEIZURE, "person having a seizure");

		assertEquals(Injury.SEIZURE, er.nextPatient().getInjury());
		assertEquals(Injury.SEIZURE, er.nextPatient().getInjury());
		assertEquals(Injury.ABDOMINAL_PAIN, er.nextPatient().getInjury());

		er.addPatient(Injury.FRACTURE, "person says pinky toe hurts, possible fracture");
		er.addPatient(Injury.CHEST_PAIN, "heart patient complaining of chest pain");
		er.addPatient(Injury.BURN, "person stayed at the beach too long and forgot sunscreen");

		p = er.nextPatient();
		assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

		p = er.nextPatient();
		assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

		er.addPatient(Injury.OTHER, "Stubbed toe");

		assertEquals(Injury.FRACTURE, er.nextPatient().getInjury());
		assertEquals(Injury.OTHER, er.nextPatient().getInjury());
		assertEquals(Injury.OTHER, er.nextPatient().getInjury());
		assertNull(er.nextPatient());
		assertNull(er.nextPatient());
	}
	
	@Test
	public void problem9() {
		ThemeParkQueue queue = new ThemeParkQueue();
		queue.addStandardGuest("person1");
		queue.addStandardGuest("person2");
		queue.addStandardGuest("person3");
		queue.addPremiumGuest("person4");
		queue.addPremiumGuest("person5");
		assertEquals("person4 entering from premium line", queue.handleNextAction());
		assertEquals("person5 entering from premium line", queue.handleNextAction());
		assertEquals("person1 entering from standard line", queue.handleNextAction());
		assertEquals("person2 entering from standard line", queue.handleNextAction());
		assertEquals("person3 entering from standard line", queue.handleNextAction());
		assertEquals("", queue.handleNextAction());

		queue.addPremiumGuest("personA");
		queue.addPremiumGuest("personB");
		queue.addStandardGuest("personC");
		queue.addStandardGuest("personD");
		queue.addStandardGuest("personE");
		assertEquals("personA entering from premium line", queue.handleNextAction());
		assertEquals("personB entering from premium line", queue.handleNextAction());

		queue.addPremiumGuest("personF");
		queue.addStandardGuest("personG");
		queue.addPremiumGuest("personH");
		queue.addStandardGuest("personI");
		assertEquals("personF entering from premium line", queue.handleNextAction());
		assertEquals("personH entering from premium line", queue.handleNextAction());
		assertEquals("personC entering from standard line", queue.handleNextAction());
		assertEquals("personD entering from standard line", queue.handleNextAction());
		assertEquals("personE entering from standard line", queue.handleNextAction());
		assertEquals("personG entering from standard line", queue.handleNextAction());

		queue.addPremiumGuest("personJ");
		assertEquals("personJ entering from premium line", queue.handleNextAction());
		assertEquals("personI entering from standard line", queue.handleNextAction());
		assertEquals("", queue.handleNextAction());
		assertEquals("", queue.handleNextAction());
	}
	
	@Test
	public void problem10() {
		Gradebook gb = new Gradebook();
		gb.addEntry("Robert", "A+");
		gb.addEntry("Emily", "B");
		gb.addEntry("Max", "D");
		String[] expArr1 = new String[] { "Emily B", "Max D", "Robert A+" };
		String[] actualArr1 = gb.getEntries();
		assertArrayEquals(expArr1, actualArr1);
		gb.modifyEntry("Max", "C");
		gb.removeEntry("Emily");

		String[] expArr2 = new String[] { "Max C", "Robert A+" };
		String[] actualArr2 = gb.getEntries();
		assertArrayEquals(expArr2, actualArr2);
	}
}
