package labs.lab5;

public class Nature implements Encourager {

	@Override
	public String encourage() {
		return shineSun() + " | " + blowGentleBreeze();
	}


	private String shineSun() {
		return "Shine sun";
	}


	private String blowGentleBreeze() {
		return "Blow gentle breeze";
	}

}