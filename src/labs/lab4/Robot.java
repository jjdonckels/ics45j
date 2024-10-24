package labs.lab4;

import java.awt.Point;

/**
 * A class for simulating a robot wandering on a 10 x 10 plane.
 */
public class Robot {
	private static final int BOUNDARY = 5;
	
	private Point pos;
	private String direction;

	
	/**
	 * Creates a Robot at location (0, 0), which is in the center of the plane,
	 * and facing north
	 */
	public Robot() {
		pos = new Point();
		direction = "N";
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnLeft() {
		if (direction.equals("N"))
			direction = "W";
		else if (direction.equals("W"))
			direction = "S";
		else if (direction.equals("S"))
			direction = "E";
		else if (direction.equals("E"))
			direction = "N";
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnRight() {
		if (direction.equals("N"))
			direction = "E";
		else if (direction.equals("E"))
			direction = "S";
		else if (direction.equals("S"))
			direction = "W";
		else if (direction.equals("W"))
			direction = "N";
	}

	
	/**
	 * Moves the robot by one unit in the direction it is facing. Returns true if the
	 * robot is still on the plane, or false if it has fallen off.
	 * 
	 * Note 1: In coordinate terms, |x| must be <= 5 and |y| must be <= 5 for the robot
	 * to stay on the plane (see below example).
	 * 
	 * Note 2: This method can still be called on a robot that has fallen off the plane,
	 * and its location should be updated as if it was still on the plane.
	 * 
	 * @return	true if the robot is still on the plane, false otherwise
	 */
	public boolean move() {
		if (direction.equals("N"))
			pos.translate(0,  1);
		else if (direction.equals("W"))
			pos.translate(-1, 0);
		else if (direction.equals("S"))
			pos.translate(0, -1);
		else if (direction.equals("E"))
			pos.translate(1, 0);
		
		boolean validX = ((int) Math.abs(pos.getX())) <= BOUNDARY;
		boolean validY = ((int) Math.abs(pos.getY())) <= BOUNDARY;
		
		return validX && validY;		
	}

	
	/**
	 * Returns the robot's current location on the plane
	 * 
	 * @return	robot's current location
	 */
	public Point getLocation() {
		return pos;
	}

	
	/**
	 * Returns "N", "E", "S", or "W" (for north, east, south, or west, respectively)
	 * 
	 * @return	the robot's direction
	 */
	public String getDirection() {
		return direction;
	}
}
