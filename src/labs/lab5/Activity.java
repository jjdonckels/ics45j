package labs.lab5;

public class Activity extends GameElement implements Doable {
	
	int duration;
		
	/**
	 * 
	 * @param name
	 * @param healthScore
	 * @param duration	in hours
	 */
	public Activity(String name, double healthScore, int duration) {
		super(name, healthScore);
		this.duration = duration;
	}
	
	
	/**
	 * For every this.healthScore point above 5, adds 0.05 to the player's health.
	 * For every this.healthScore point below 5, subtracts 0.05 from the player's health.
	 * If this.healthScore == 5, makes no change to the player's health
	 */
	@Override
	public String doIt(Player player) {
		if (super.getHealthScore() != 5)
		{
			double healthDifference = super.getHealthScore() - 5;
			
			double healthChange = healthDifference * 0.05;
			
			double newHealth = player.getHealth() + healthChange;
			
			player.setHealth(newHealth);
		}
		
		return player.getName() + " is doing " + super.getName() + " for " + duration + " hours";
	}
}