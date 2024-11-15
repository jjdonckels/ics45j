package labs.lab6.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import labs.lab6.*;


public class Lab6Test {
	
	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, 55.55, "res/transactions1.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(10.05, 65.60, "res/transactions1.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(25, 55.55, "res/transactions1.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, 0, "res/transactionsBlank.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(0, 55.55, "res/transactionsBlank.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, -176.62, "res/transactions2.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(200, 23.38, "res/transactions2.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(100, 23.38, "res/transactions2.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(0, 190.79, "res/transactions3.txt"));

		assertEquals("End of day total is properly balanced.",
				BalanceTransactions.balance(10, 200.79, "res/transactions3.txt"));

		assertEquals("End of day total is not balanced.",
				BalanceTransactions.balance(100, 190.79, "res/transactions3.txt"));

		// test exception message is printed out:
		String nonExistentFileName = "doesnotexist.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		BalanceTransactions.balance(0, 55.55, nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	@Test
	public void problem2() {

		// words1.txt:
		WordFrequencyCounter counter1 = new WordFrequencyCounter("res/words1.txt");
		String expected1 = "robert: ******\n" + "java: ***\n" + "fun: **\n" + "is: **\n" + "agrees: *\n" + "so: *\n"
				+ "that: *\n";
		assertEquals(expected1, counter1.getFrequencyGraph());

		// words2.txt:
		WordFrequencyCounter counter2 = new WordFrequencyCounter("res/words2.txt");
		String expected2 = "of: ************\n" + "it: **********\n" + "the: **********\n" + "was: **********\n"
				+ "a: **\n" + "age: **\n" + "charles: **\n" + "dickens: **\n" + "epoch: **\n" + "i: **\n" + "read: **\n"
				+ "season: **\n" + "times: **\n" + "two: **\n" + "and: *\n" + "before: *\n" + "belief: *\n"
				+ "best: *\n" + "book: *\n" + "books: *\n" + "but: *\n" + "carol: *\n" + "christmas: *\n"
				+ "cities: *\n" + "darkness: *\n" + "despair: *\n" + "foolishness: *\n" + "have: *\n" + "havent: *\n"
				+ "hope: *\n" + "incredulity: *\n" + "its: *\n" + "light: *\n" + "list: *\n" + "my: *\n" + "oliver: *\n"
				+ "on: *\n" + "reading: *\n" + "spring: *\n" + "tale: *\n" + "this: *\n" + "twist: *\n" + "winter: *\n"
				+ "wisdom: *\n" + "worst: *\n";
		assertEquals(expected2, counter2.getFrequencyGraph());

		// words3.txt:
		WordFrequencyCounter counter3 = new WordFrequencyCounter("res/words3.txt");
		String expected3 = "the: **********\n" + "i: *********\n" + "and: *******\n" + "a: *****\n" + "it: *****\n"
				+ "me: *****\n" + "to: *****\n" + "in: ****\n" + "is: ****\n" + "my: ****\n" + "of: ****\n"
				+ "whenever: ****\n" + "about: **\n" + "as: **\n" + "find: **\n" + "get: **\n" + "little: **\n"
				+ "myself: **\n" + "nothing: **\n" + "off: **\n" + "or: **\n" + "some: **\n" + "this: **\n"
				+ "time: **\n" + "with: **\n" + "account: *\n" + "ago: *\n" + "all: *\n" + "almost: *\n" + "an: *\n"
				+ "ball: *\n" + "before: *\n" + "bringing: *\n" + "but: *\n" + "call: *\n" + "can: *\n" + "cato: *\n"
				+ "cherish: *\n" + "circulation: *\n" + "coffin: *\n" + "damp: *\n" + "degree: *\n"
				+ "deliberately: *\n" + "driving: *\n" + "drizzly: *\n" + "especially: *\n" + "every: *\n"
				+ "feelings: *\n" + "flourish: *\n" + "for: *\n" + "from: *\n" + "funeral: *\n" + "grim: *\n"
				+ "growing: *\n" + "hand: *\n" + "hats: *\n" + "have: *\n" + "having: *\n" + "high: *\n"
				+ "himself: *\n" + "his: *\n" + "how: *\n" + "hypos: *\n" + "if: *\n" + "interest: *\n" + "into: *\n"
				+ "involuntarily: *\n" + "ishmael: *\n" + "knew: *\n" + "knocking: *\n" + "long: *\n" + "meet: *\n"
				+ "men: *\n" + "methodically: *\n" + "mind: *\n" + "money: *\n" + "moral: *\n" + "mouth: *\n"
				+ "nearly: *\n" + "never: *\n" + "no: *\n" + "november: *\n" + "ocean: *\n" + "on: *\n" + "other: *\n"
				+ "part: *\n" + "particular: *\n" + "pausing: *\n" + "peoples: *\n" + "philosophical: *\n"
				+ "pistol: *\n" + "precisely: *\n" + "prevent: *\n" + "principle: *\n" + "purse: *\n" + "quietly: *\n"
				+ "rear: *\n" + "regulating: *\n" + "requires: *\n" + "sail: *\n" + "same: *\n" + "sea: *\n"
				+ "see: *\n" + "ship: *\n" + "shore: *\n" + "soon: *\n" + "soul: *\n" + "spleen: *\n" + "stepping: *\n"
				+ "street: *\n" + "strong: *\n" + "substitute: *\n" + "such: *\n" + "surprising: *\n" + "sword: *\n"
				+ "take: *\n" + "that: *\n" + "their: *\n" + "then: *\n" + "there: *\n" + "they: *\n" + "thought: *\n"
				+ "throws: *\n" + "towards: *\n" + "up: *\n" + "upon: *\n" + "upper: *\n" + "very: *\n" + "watery: *\n"
				+ "way: *\n" + "world: *\n" + "would: *\n" + "years: *\n";
		assertEquals(expected3, counter3.getFrequencyGraph());

		// blank.txt:
		WordFrequencyCounter counter4 = new WordFrequencyCounter("res/blank.txt");
		assertEquals("", counter4.getFrequencyGraph());

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		WordFrequencyCounter counter5 = new WordFrequencyCounter(nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	@Test
	public void problem3() {

		// success operations:
		Customer robert = new Customer(1, "Robert Navarro", 1);
		assertEquals(1, robert.getBalance(), EPSILON);

		robert.adjustBalance(300);
		assertEquals(301, robert.getBalance(), EPSILON);

		robert.adjustBalance(-100);
		assertEquals(201, robert.getBalance(), EPSILON);

		robert.adjustBalance(-201);
		assertEquals(0, robert.getBalance(), EPSILON);

		robert.adjustBalance(201);
		assertEquals(201, robert.getBalance(), EPSILON);

		// exception operations:

		// adjusting balance to negative amount:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			robert.adjustBalance(-300);
		});
		String expectedMessage = "Cannot adjust balance to negative amount";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		assertEquals(201, robert.getBalance(), EPSILON);

		// constructing new customer with negative ID:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer george = new Customer(-1, "George Glass", 30);
		});
		expectedMessage = "Customer ID cannot be negative";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		// constructing new customer with blank name:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer blank = new Customer(2, "", 30000);
		});
		expectedMessage = "Customer name cannot be blank";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer blank = new Customer(2, "  ", 30000);
		});
		expectedMessage = "Customer name cannot be blank";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		// constructing new customer with negative balance:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer george = new Customer(2, "George Glass", -30);
		});
		expectedMessage = "Customer balance cannot be negative";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void problem4() {
		Bank bank1 = new Bank("res/accounts1.dat");
		assertEquals(new BankAccount(2, 300.0), bank1.getLowestBalanceAccount());
		
		Bank bank2 = new Bank("res/accounts2.dat");
		assertEquals(new BankAccount(4, 4), bank2.getLowestBalanceAccount());
		
		Bank bank3 = new Bank("res/accounts3.dat");
		assertEquals(new BankAccount(9098, 0), bank3.getLowestBalanceAccount());
		
		Bank bank4 = new Bank("res/accounts4.dat");
		assertEquals(new BankAccount(10, 3), bank4.getLowestBalanceAccount());
		
		Bank bank5 = new Bank("res/blank.txt");
		assertNull(bank5.getLowestBalanceAccount());

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		Bank bank6 = new Bank(nonExistentFileName);

		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	@Test
	public void problem5() {
		// sales.txt:
		SalesTally st = new SalesTally("res/sales.txt");
		assertEquals(53.4, st.getCategoryTotal("Dinner"), EPSILON);
		assertEquals(499.0, st.getCategoryTotal("Conference"), EPSILON);
		assertEquals(0.0, st.getCategoryTotal("Lodging"), EPSILON);

		// blank file:
		SalesTally stBlank = new SalesTally("res/blank.txt");
		assertEquals(0, stBlank.getCategoryTotal("Dinner"), EPSILON);
		assertEquals(0, stBlank.getCategoryTotal("Conference"), EPSILON);
		assertEquals(0, stBlank.getCategoryTotal("Lodging"), EPSILON);

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		SalesTally st2 = new SalesTally(nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	@Test
	public void problems6through10() {
		MessagingSystem system = new MessagingSystem();
		system.deliver("Emily", "Robert", "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n");
		system.deliver("Emily", "45J Student", "Hey 45J Student,\n"
				+ "You are doing great!\n"
				+ "Keep up the good work.\n"
				+ "-Prof. Navarro\n");
		assertEquals(" -----\n"
				+ "From: Emily\n"
				+ "To: 45J Student\n"
				+ "Hey 45J Student,\n"
				+ "You are doing great!\n"
				+ "Keep up the good work.\n"
				+ "-Prof. Navarro\n", system.getMessages("45J Student"));
		system.deliver("45J Student", "Robert", "Robert, you are the best dog ever!!!\n");
		assertEquals(" -----\n"
				+ "From: Emily\n"
				+ "To: Robert\n"
				+ "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n"
				+ " -----\n"
				+ "From: 45J Student\n"
				+ "To: Robert\n"
				+ "Robert, you are the best dog ever!!!\n", system.getMessages("Robert"));

		Message message = new Message("Emily","Robert","Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n");
		assertEquals("Robert",message.getRecipient());
		assertEquals("From: Emily\n"
				+ "To: Robert\n"
				+ "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n",message.toString());
		
		Mailbox mailbox = new Mailbox("Robert");
		assertEquals("Robert", mailbox.getUser());
		Message message1 = new Message("Emily","Robert","Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n");
		Message message2 = new Message("45J Student","Robert","Robert, you are the best dog ever!!!\n");
		mailbox.addMessage(message1);
		mailbox.addMessage(message2);
		assertEquals(" -----\n"
				+ "From: Emily\n"
				+ "To: Robert\n"
				+ "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n"
				+ " -----\n"
				+ "From: 45J Student\n"
				+ "To: Robert\n"
				+ "Robert, you are the best dog ever!!!\n",mailbox.getAllMessages());
	}
	
	//10 points
		@Test
		public void problems6through10_4() {
		    MessagingSystem system = new MessagingSystem();

		    // Edge case: No messages for a user should return an empty string
		    assertEquals("", system.getMessages("UnknownUser"));

		    // Deliver a message to a user, then retrieve messages
		    system.deliver("Alice", "Bob", "Hello Bob,\n" +
		            "This is a reminder for our meeting tomorrow.\n" +
		            "Best regards,\n" +
		            "Alice\n");
		    assertEquals(" -----\n" +
		            "From: Alice\n" +
		            "To: Bob\n" +
		            "Hello Bob,\n" +
		            "This is a reminder for our meeting tomorrow.\n" +
		            "Best regards,\n" +
		            "Alice\n", system.getMessages("Bob"));

		    // Edge case: Another user who has not received any messages should return empty string
		    assertEquals("", system.getMessages("Charlie"));

		    // Testing the Message class with an empty message body
		    Message emptyMessage = new Message("Alice", "Bob", "");
		    assertEquals("Bob", emptyMessage.getRecipient());
		    assertEquals("From: Alice\nTo: Bob\n", emptyMessage.toString());

		    // Testing the Mailbox class with no messages added
		    Mailbox emptyMailbox = new Mailbox("Dana");
		    assertEquals("Dana", emptyMailbox.getUser());
		    assertEquals("", emptyMailbox.getAllMessages());

		    // Edge case:
		    Mailbox mailbox = new Mailbox("Eve");

		    // After clearing the mailbox, it should return an empty string
		    system = new MessagingSystem();
		    assertEquals("", mailbox.getAllMessages());
		}
}
