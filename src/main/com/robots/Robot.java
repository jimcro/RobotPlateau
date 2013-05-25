package com.robots;

/**
 * Class to hold the position and direction of a robot instance, with a reference to the plateau it is on.
 * 
 * @author jimc
 *
 */
public class Robot {
	private int x;
	private int y;
	private Direction d;
	private Plateau p;
	
	/**
	 * Constructor
	 * @param x Starting X position
	 * @param y Starting Y position
	 * @param d Starting direction
	 * @param p Plateau robot is on
	 */
	public Robot(final int x, final int y, final Direction d, Plateau p) {
		this.x=x;
		this.y=y;
		this.d=d;
		this.p=p;
	}
	
	public String toString() {
		return x  + " " + y +  " " + d;
	}
	
	/**
	 * Rotote the robot left 90 degrees
	 */
	public void rotateLeft() {
		this.d = d.rotateLeft();
	}
	
	/**
	 * Rotate the robot right 90 degrees
	 */
	public void rotateRight() {
		this.d = d.rotateRight();
	}
	
	/**
	 * Move and/or rotate the robot according to the instructions in 'directions'
	 * 
	 * @param directions List of instructions (e.g. LRM for left, right, move)
	 * 
	 * @throws Exception Thrown if attempting to move outside of plateau boundary
	 */
	public void move(String directions) throws Exception {		
		for (int p=0;p<directions.length();p++) {
			switch (directions.charAt(p)) {
				case 'L' : // Left spin
					rotateLeft();
					break;
				case 'R' : // Right spin
					rotateRight();
					break;
				case 'M' : // Move in current direction
					moveForward();
					break;					
			}
		}
	}
	
	/**
	 * Move forward in current direction.
	 * 
	 * Checks for plateaus boundaries
	 * @throws Exception Throws when robot attempts to move outside plateau
	 */
	private void moveForward() throws Exception {
		if (Direction.NORTH == d) {
			if (this.y == p.getHeight()) {
				throw new Exception("Cannot move robot any higher than " + this);
			}
			this.y++;
		}
		else if (Direction.SOUTH == d) {
			if (this.y == 0) {
				throw new Exception("Cannot move robot any lower than " + this);
			}
			this.y--;			
		}
		else if (Direction.EAST == d) {
			if (this.y == p.getWidth()) {
				throw new Exception("Cannot move robot any further right than " + this);
			}
			this.x++;
		}
		else if (Direction.WEST == d) {
			if (this.y == 0) {
				throw new Exception("Cannot move robot any further left than " + this);
			}
			this.x--;			
		}
	}
}
