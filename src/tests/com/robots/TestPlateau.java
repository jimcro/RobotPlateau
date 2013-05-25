package com.robots;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class TestPlateau {

	@Test
	public void testPlateauSize() {
		Plateau p = new Plateau(5, 10);
		assertEquals(10, p.getHeight());
		assertEquals(5, p.getWidth());
	}
	
	@Test
	public void testSimpleMove() {
		Plateau p = new Plateau(5, 5);
		assertEquals(5, p.getHeight());
		assertEquals(5, p.getWidth());
		
		try {
			Robot r = p.addRobot(1, 2, Direction.fromString('N'));
			r.move("LMLMLMLMM");
			assertEquals("1 3 N", r.toString());
		}
		catch (Exception e) {
			fail("Shouldn't have exception");
		}
		
	}
	
	@Test
	public void testBoundary() {
		Plateau p = new Plateau(5, 5);
		assertEquals(5, p.getHeight());
		assertEquals(5, p.getWidth());
		
		try {
			Robot r = p.addRobot(3, 3, Direction.fromString('N'));
			r.move("MMM");
			fail("Exception expected");
		}
		catch (Exception e) {
			// Ignore - we expect an exception
		}
	}

}
