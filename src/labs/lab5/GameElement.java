package labs.lab5;

public abstract class GameElement {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	
	/**
	 * 
	 * @param name
	 * @param healthScore	from 0 (least healthy) to 10 (most healthy)
	 * 						(If below 0, sets it to 0; if above 10, sets it to 10)
	 */						
	public GameElement(String name, double healthScore) {
		// FILL IN
	}
	
	
	public String getName() {
		return ""; // FIX ME
	}
	
	
	public double getHealthScore() {
		return -1.0; // FIX ME
	}
}