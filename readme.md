#Robot Controller

##Description
Basically it uses two classes - **com.robots.Plateau** to hold details of the Plateau size, and **com.robots.Robot** to hold details about a robot instance.

##Input
I've included a **com.robots.CommandLinePlateau** class, which allows you to run the application and provide plateau initialisation and robot movement data from the command line.

To run the CommandLinePlateau class you need the command line:

> java -cp plateau.jar com.robots.CommandLinePlateau X Y

Where X and Y are the width and height values for the plateau. Once running, you can either enter:

> X Y D

Where X Y D are the initial X, Y and direction values for a robot

> directions (LRM values)

To move the robot - its new value will be displayed on screen

> EXIT

Quits the command line
 

##Testing
Unit tests are in **src/tests/com/robots/TestPlateau** - there aren't many, but they cover the basics.

##Compiling
There's an Ant build file included to compile to a JAR, but I ran out of time to add in a manifest file to make the CommandLinePlateau the default class to run.
##TODO
Things I didn't have time to do:
* Add more unit tests
* Error handing - at the moment attempting to move outside the bounds of the plateau results in a fatal Exception. This could be handled more gracefully.
* Add the ability to feed in input data from a file
* Add the ability to have multiple robots on a plateau, and check that a robot is not already occupying a position when trying to move another robot to it.
* Class diagrams. I thought the solution was simple enough that it didn't really need them.


