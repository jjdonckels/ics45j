package labs.lab4;

/**
 * Represents a downloadable item like a movie, song, etc
 */
public class DigitalItem extends MerchandiseItem {

	private Format format;

	/*
	 * Note: This may be the first time you see an enum, but it is the perfect
	 * construct for a situation like this, where you want a set of predefined
	 * constants. The textbook explains enums in Special Topic 5.4 on pages 155-156.
	 * You can also google "Java enum" and read about them online.
	 */
	public static enum Format {
		VIDEO, AUDIO, EBOOK
	};

	/**
	 * Constructor
	 * 
	 * @param name   name of the item
	 * @param price  price of the item
	 * @param format format of the item
	 */
	public DigitalItem(String name, double price, Format format) {
		super(name, price);
		this.format = format;
	}


	/**
	 * Returns the format of the item
	 * 
	 * @return format of the item
	 */
	public Format getFormat() {
		return format;
	}


	/**
	 * Sets the format of the item
	 * 
	 * @param f new format
	 */
	public void setFormat(Format f) {
		format = f;
	}


	@Override
	public String purchase(String purchaseDate) {
		// since this is a digital item, the date purchased is the same as the date
		// received since it arrives immediately
		return purchaseDate;
	}


	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof DigitalItem)
		{
			DigitalItem other = (DigitalItem) otherObject;
			return super.equals(other) && format == other.format;
		}
		return false;
	}


	@Override
	public String toString() {
		String returnMe = super.toString() + ", format: ";
		
		if (format == Format.VIDEO)
			returnMe += "VIDEO";
		else if (format == Format.AUDIO)
			returnMe += "AUDIO";
		else
			returnMe += "EBOOK";
		
		return returnMe;
	}

}