package labs.lab7;

import java.util.Scanner;

/**
 * Exercising a theme park attraction line
 */
public class ThemeParkQueueUI {

	public static void main(String[] args) {
		ThemeParkQueue queue = new ThemeParkQueue();

		Scanner in = new Scanner(System.in);
		boolean done = false;
		System.out.println("Theme Park Queue Menu");
		System.out.println("-----------------------------------------------");
		System.out.println(" > standard/premium followed by the guest name");
		System.out.println(" > next to perform next action");
		System.out.println(" > quit to quit program");
		System.out.println();

		while (!done) {
			System.out.print(" > ");
			String action = in.next();
			if (action.equals("standard")) {
				String guestName = in.next();
				queue.addStandardGuest(guestName);
			} else if (action.equals("premium")) {
				String guestName = in.next();
				queue.addPremiumGuest(guestName);
			} else if (action.equals("next")) {
				System.out.println(queue.handleNextAction());
			} else if (action.equals("quit")) {
				done = true;
			}
		}
		System.out.println();
		System.out.println(" -- Thank you --");
	}

}
