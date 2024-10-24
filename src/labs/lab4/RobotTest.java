package labs.lab4;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class RobotTest {

	@Test
    public void testConstructor() {
		Robot r1 = new Robot();
		assertEquals(true, r1.getLocation().equals(new Point(0, 0)));
		assertEquals(true, r1.getDirection().equals("N"));
    }

	@Test
    public void testTurnLeft() {
		Robot r1 = new Robot();
		r1.turnLeft();
		assertEquals(true, r1.getDirection().equals("W"));
		r1.turnLeft();
		assertEquals(true, r1.getDirection().equals("S"));
		r1.turnLeft();
		assertEquals(true, r1.getDirection().equals("E"));
		r1.turnLeft();
		assertEquals(true, r1.getDirection().equals("N"));
    }
	
	@Test
    public void testTurnRight() {
		Robot r1 = new Robot();
		r1.turnRight();
		assertEquals(true, r1.getDirection().equals("E"));
		r1.turnRight();
		assertEquals(true, r1.getDirection().equals("S"));
		r1.turnRight();
		assertEquals(true, r1.getDirection().equals("W"));
		r1.turnRight();
		assertEquals(true, r1.getDirection().equals("N"));
    }
	
	@Test
    public void testMove() {
		Robot r1 = new Robot();
		
		boolean inBounds = false;
		
		for (int i = 1; i <= 5; ++i)
			inBounds = r1.move();
		
		assertEquals(true, r1.getLocation().equals(new Point(0, 5)));
		assertEquals(true, inBounds);
		
		inBounds = r1.move();
		assertEquals(true, r1.getLocation().equals(new Point(0, 6)));
		assertEquals(false, inBounds);
		
		r1.turnLeft(); // now facing W
		for (int i = 1; i <= 6; ++i)
			inBounds = r1.move();
		
		assertEquals(true, r1.getLocation().equals(new Point(-6, 6)));
		assertEquals(false, inBounds);
		
		r1.turnLeft(); // now facing S
		inBounds = r1.move();
		
		assertEquals(true, r1.getLocation().equals(new Point(-6, 5)));
		assertEquals(false, inBounds);
		
		r1.turnLeft(); // now facing E
		inBounds = r1.move();
		
		assertEquals(true, r1.getLocation().equals(new Point(-5, 5)));
		assertEquals(true, inBounds);
		
    }
}
