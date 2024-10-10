package labs.lab1;

/**
 * The class represents an ant population that may breed and that may be
 * controlled by insecticide.
 */
public class AntPopulation {
	private int population;
	
	/**
	 * Create an initial ant population with given size.
	 * 
	 * @param size initial population
	 */
	public AntPopulation(int size) {
		population = size;
	}

	/**
	 * Simulates a breeding period increasing the population.
	 */
	public void breed() {
		population *= 2;
	}

	/**
	 * Spray the population with insecticide.
	 * 
	 * Rounds number of ants eradicated to the nearest int before subtracting
	 * them from the population.
	 * 
	 * @param percent percent of population eradicated
	 */
	public void spray(double percent) {
		double numAntsEradicated = population * (percent / 100); 
		
		population -= Math.round(numAntsEradicated);
	}

	/**
	 * Returns the current population size.
	 * 
	 * @return current population size
	 */
	public int getAnts() {
		return population;
	}
}
