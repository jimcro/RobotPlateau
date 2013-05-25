package com.robots;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Simple class to allow user to enter individual robot movement commands on the command line
 * 
 * @author jimc
 *
 */
public class CommandLinePlateau {

	/**
	 * Presume program takes 2 integer arguments - width x height
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.out.println("Usage: CommandLinePlateau <width> <height>");
			System.exit(1);
		}
		else {
			
			// Initialise plateau
			final int width = Integer.parseInt(args[0]);
			final int height = Integer.parseInt(args[1]);
			Plateau p = new Plateau(width, height);
			System.out.println("Initialised plateau to " + width + ", " + height);
			Robot r = null;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean active = true;
			String input = null;
			System.out.println("Ready for input...");
			while (active) {
				input = br.readLine();
				if ((input != null) && (input.length() > 0)) {
					if (input.equalsIgnoreCase("EXIT")) {
						active = false;
					}
					else {
						// Assume if input starts with a number we're assigning the starting position of a robot
						if (Character.isDigit(input.charAt(0))) {
							// Start a robot - input can be space or , separated
							String delims = "[ ,]";
							String[] tokens = input.split(delims);
							if (tokens.length != 3) {
								System.out.println("Invalid starting position of " + input + " - expecting X Y D");
							}
							else {
								r = p.addRobot(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Direction.fromString(tokens[2].charAt(0)));
								System.out.println("Robot initialised to " + r.toString());
							}
						}
						else {
							// presume anything else is directions (e.g. LMRMLMRM)
							if (null == r) {
								// we haven't started a robot yet - default to 0 0 N
								r = p.addRobot(0, 0, Direction.fromString('N'));
								System.out.println("Directions received before robot initialised - defaulting robot to 0,0,N");
							}
							r.move(input);
							System.out.println("Moved robot to " + r.toString());
						}
					}
				}
			}
		}

	}

}
