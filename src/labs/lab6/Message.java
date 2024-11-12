package labs.lab6;

/**
 * An email message.
 */
public class Message {
	private String sender;
	private String recipient;
	private String text;

	/**
	 * Constructs a Message object.
	 * 
	 * @param from 	the sender of the message
	 * @param to	the recipient of the message
	 * @param text	the text of the message
	 */
	public Message(String from, String to, String text) {
		sender = from;
		recipient = to;
		this.text = text;
	}

	/**
	 * Gets the recipient.
	 * 
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * Formats the email message in the following format:
	 * From: [SENDER]
	 * To: [RECIPIENT]
	 * [TEXT]
	 */
	public String toString() {
		String returnMe = "From: " + sender + "\n";
		returnMe += "To: " + recipient + "\n";
		returnMe += text;
		
		return returnMe;
	}
}
