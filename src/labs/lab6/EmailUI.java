package labs.lab6;

import java.util.Scanner;

/**
 * A user interface for users to log in, send messages to other
 * users, read their own messages, and log out.
 */
public class EmailUI {
	private Scanner in;

	/**
	 * Constructs an EmailMenu object.
	 */
	public EmailUI() {
		in = new Scanner(System.in);
	}

	/**
	 * Runs the system.
	 * 
	 * @param system the email messaging system
	 */
	public void run(MessagingSystem system) {
		boolean more = true;
		String currentUser = null;

		while (more) {
			System.out.print("Log I)n  O)ut  S)end  R)ead  Q)uit: ");
			String command = in.nextLine().toUpperCase();

			if (command.equals("I")) {
				System.out.print("User name: ");
				currentUser = in.nextLine();
			} else if (command.equals("O")) {
				currentUser = null;
			} else if (command.equals("Q")) {
				more = false;
			} else if (command.equals("R")) {
				if (currentUser == null) {
					System.out.println("Log in first!");
				} else {
					System.out.println(system.getMessages(currentUser));
				}
			} else if (command.equals("S")) {
				if (currentUser == null) {
					System.out.println("Log in first!");
				} else {
					System.out.print("Mail to: ");
					String recipient = in.nextLine();
					StringBuffer text = new StringBuffer();
					System.out.println("Enter text, blank line to end:");
					while (true) {
						String line = in.nextLine();
						if (line.length() < 1) {
							break;
						} else {
							text.append(line + "\n");
						}
					}
					system.deliver(currentUser, recipient, text.toString());
				}
			}
		}
	}


	public static void main(String[] args) {
		new EmailUI().run(new MessagingSystem());
	}
}
