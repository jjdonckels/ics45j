package labs.lab5;

public class Parent extends Person implements Encourager {

	public Parent(String name, int age) {
		super(name, age);
	}


	@Override
	public String encourage() {
		return ""; // FIX ME (you should call the below private methods)
	}


	private String callOnThePhone() {
		return "Call on the phone";
	}


	private String sayYoureTheirFavoriteChild() {
		return "Say you're their favorite child";
	}

}