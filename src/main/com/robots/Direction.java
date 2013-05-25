package com.robots;

/**
 * Class to encapsulate the handling of direction (north, east, south, west)
 * @author jimc
 *
 */
public class Direction {
	protected enum direction {N,E,S,W};
	private direction d;
	
	/** 4 static instance of direction objects */
	public static Direction NORTH = new Direction(direction.N);
	public static Direction EAST = new Direction(direction.E);
	public static Direction SOUTH = new Direction(direction.S);
	public static Direction WEST = new Direction(direction.W);
	
	/**
	 * Private constructor 
	 * 
	 * @param d
	 */
	private Direction(direction d) {
		this.d = d;
	}
	
	/**
	 * Public method for clients to obtain an instance
	 * 
	 * @param d character N,E,S or W
	 * @return NORTH,EAST,SOUTH,WEST instance
	 * @throws Exception
	 */
	public static Direction fromString(char d) throws Exception {
		switch (d) {
			case 'N': return NORTH;
			case 'E' : return EAST;
			case 'S' : return SOUTH;
			case 'W' : return WEST;
			default : throw new Exception("Cannot convert direction " + d);
		}
	}
	
	public String toString() {
		String result = "";
		switch (d) {
			case N : result = "N";
				break;
			case E: result = "E";
				break;		
			case S : result = "S";		
				break;		
			case W : result = "W";
				break;
		}
		return result;
	}
	
	/**
	 * Return new direction after rotating current direction right 90 degrees
	 * @return Direction
	 */
	public Direction rotateRight() {
		Direction result = null;
		switch (d) {
			case N : result = EAST;
				break;
			case E: result = SOUTH;
				break;
			case S : result = WEST;
				break;
			case W : result = NORTH;
				break;
		}
		return result;
	}

	/**
	 * Return new direction after rotating current direction left 90 degrees
	 * @return Direction
	 */
	public Direction rotateLeft() {
		Direction result = null;
		switch (d) {
			case N : result = WEST;
				break;
			case E: result = NORTH;
				break;
			case S : result = EAST;
				break;
			case W : result = SOUTH;
				break;
		}
		return result;
	}
}
