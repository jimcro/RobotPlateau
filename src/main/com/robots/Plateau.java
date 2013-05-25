package com.robots;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to encapsulate a plateau of fixed size with robots
 * 
 * @author jimc
 *
 */
public class Plateau {
	private int xSize, ySize;
	private List<Robot> robots = new ArrayList<Robot>(); // to track robot(s) on plateau

	/**
	 * Constructor
	 * 
	 * @param xSize Width of plateau
	 * @param ySize Height of plateau
	 */
	public Plateau (final int xSize,final int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	/**
	 * Add a robot to this plateau
	 * 
	 * @param x Robot starting X position
	 * @param y Robot starting Y position
	 * @param d Robot starting direction
	 * @return Robot instance
	 */
	public Robot addRobot(final int x, final int y, final Direction d) {
		Robot r = new Robot(x,y,d,this);
		robots.add(r);
		return r;
	}
	
	/**
	 * Return width of plateau
	 * 
	 * @return width
	 */
	public int getWidth() {
		return xSize;
	}
	
	/**
	 * Return height of plateau
	 * 
	 * @return height
	 */
	public int getHeight() {
		return ySize;
	}
}
