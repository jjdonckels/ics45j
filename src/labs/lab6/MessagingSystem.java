package labs.lab6;

import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	private ArrayList<Mailbox> mailboxes;

	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		mailboxes = new ArrayList<Mailbox>();
	}


	/**
	 * Delivers a message to the recipient
	 * 
	 * @param sender		message sender
	 * @param recipient		message recipient
	 * @param text			text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		int senderIndex = searchIndex(sender);
		int recipientIndex = searchIndex(recipient);
		
		// make a mailbox for sender if one doesn't exist
		if (senderIndex < 0)
		{
			mailboxes.add(new Mailbox(sender));
		}
		
		// make a mailbox for recipient if one doesn't exist
		if (recipientIndex < 0)
		{
			mailboxes.add(new Mailbox(recipient));
			int newRecipientIndex = searchIndex(recipient);
			
			// if this is the recipient's first message, their mailbox was just created so 
			// the recipient index needs to be updated
			// add the message to the recipient's mailbox		
			mailboxes.get(newRecipientIndex).addMessage(new Message(sender, recipient, text));
			return;
		}
		
		// add the message to the recipient's mailbox		
		mailboxes.get(recipientIndex).addMessage(new Message(sender, recipient, text));
	}
	
	// return index of the mailbox belonging to the given user, -1 if not found
	private int searchIndex(String user)
	{
		for (int i = 0; i < mailboxes.size(); ++i)
		{
			if (mailboxes.get(i).getUser().equals(user))
				return i;
		}
		
		return -1;
	}

	
	/**
	 * Retrieves the messages for a user
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		int userIndex = searchIndex(user);
		if (userIndex < 0)
			return "" + user + " does not have a mailbox";
		return mailboxes.get(userIndex).getAllMessages();
	}
}
