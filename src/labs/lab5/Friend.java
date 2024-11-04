package labs.lab5;

public class Friend extends Person implements Encourager {

	public Friend(String name, int age) {
		super(name, age);
	}


	@Override
	public String encourage() {
		return comeOverToHangOut() + " | " + bringSnacks();
	}


	private String comeOverToHangOut() {
		return "Come over to hang out";
	}


	private String bringSnacks() {
		return "Bring snacks";
	}

}