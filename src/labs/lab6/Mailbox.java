package labs.lab6;

import java.util.ArrayList;

/**
 * An email mailbox.
 */
public class Mailbox {
	private ArrayList<Message> messages;
	private String user;

	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param user the user
	 */
	public Mailbox(String user) {
		messages = new ArrayList<Message>();
		this.user = user;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Adds a message to the mailbox.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		messages.add(m);
	}

	/**
	 * Retrieves text of all messages, in the following format:
	 * -----
	 * [MESSAGE1]
	 * -----
	 * [MESSAGE2]
	 * 
	 * etc.
	 */
	public String getAllMessages() {
		String returnMe = "";
		for (int i = 0; i < messages.size(); ++i)
		{
			returnMe += " -----\n" + messages.get(i).toString();
		}
		
		return returnMe;
	}
}
