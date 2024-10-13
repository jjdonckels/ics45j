package labs.lab2;

/**
 * A boat that floats in a 2D ocean
 */
public class Boat {

	private double x;
	private double y;
	private double direction;

	/**
	 * Creates a boat with an initial position and direction angle.
	 * 
	 * @param x     the x coordinate of the boat's initial position.
	 * @param y     the y coordinate of the boat's initial position.
	 * @param angle angle of the boat's direction (in degrees from x axis)
	 */
	public Boat(double x, double y, double angle) {
		this.x = x;
		this.y = y;
		direction = angle;
	}


	/**
	 * Retrieves the x coordinate of the boat's current position.
	 * 
	 * @return the x coordinate of the boat's position
	 */
	public double getX() {
		return x;
	}


	/**
	 * Retrieves the y coordinate of the boat's current position.
	 * 
	 * @return the y coordinate of the boat's position
	 */
	public double getY() {
		return y;
	}


	/**
	 * Retrieves the direction in which the boat is heading
	 * 
	 * @return the angle in which the boat is heading (in degrees)
	 */
	public double getDirection() {
		return direction;
	}


	/**
	 * Turns the boat by a specified angle.
	 * 
	 * @param degrees the number of degrees of the turn (positive angles are
	 *                counter-clockwise, negative ones are clockwise)
	 */
	public void turn(double degrees) {
		direction += degrees;
	}


	/**
	 * Moves the boat a specified distance in the direction it is heading.
	 * Assume all inputs are > 0.
	 * 
	 * @param distance the distance being traveled by the boat
	 */
	public void move(double distance) {
		double radDirection = direction * (Math.PI / 180.0); // convert direction from deg to rad
		x += distance * Math.cos(radDirection);
		y += distance * Math.sin(radDirection);
	}
}
