package labs.lab5;

public class Dog implements Encourager {

	@Override
	public String encourage() {
		return giveWetSloppyKisses() + " | " + layOnYourFeet();
	}


	private String giveWetSloppyKisses() {
		return "Give wet sloppy kisses";
	}


	private String layOnYourFeet() {
		return "Lay on your feet";
	}

}