/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        double fullAngle = 360;
        return (180 - fullAngle/sides);
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        double fullAngle = 360;
        angle = 180 - angle;
        return (int) Math.round(fullAngle / angle);
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        double angle = 180 - calculateRegularPolygonAngle(sides);
        for(int i=0; i<sides; i++){
        	turtle.forward(sideLength);
        	turtle.turn(angle);
        }
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
    	double theta;
    	if(currentY == targetY){
    		if(currentX < targetX)
    			theta = 90;
    		else 
    			theta = 270;
    		
    	}else if (currentX == targetX){
    		if(currentY < targetY)
    			theta = 0;
    		else 
    			theta = 180;
    	}else{
    		theta = Math.atan2(targetX - currentX, targetY - currentY);
    		theta = theta / Math.PI * 180;
    	}
        if(theta < currentHeading){
        	System.out.println(360 - (currentHeading - theta));
        	return 360 - (currentHeading - theta);
        }else{
        	System.out.println(theta - currentHeading);
        	return theta - currentHeading;
        }
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        int size = xCoords.size();
        List<Double> angleList = new ArrayList<Double>();
        if(size ==0)
        	return angleList;
        int currentX = xCoords.get(0);
        int currentY = yCoords.get(0);
        double currentAngle = 0;
        for(int i=1; i<size; i++){
        	angleList.add(calculateHeadingToPoint(currentAngle, currentX, 
        										  currentY, xCoords.get(i), yCoords.get(i)));
        	currentAngle += angleList.get(i-1);
        	currentAngle %= 360;
        	currentX = xCoords.get(i);
        	currentY = yCoords.get(i);
        }
        return angleList;
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
    	List<Integer> xCoords = new ArrayList<>();
    	List<Integer> yCoords = new ArrayList<>();
    	xCoords.add(0);
    	xCoords.add(0);
    	xCoords.add(2);
    	xCoords.add(2);
    	xCoords.add(0);
    	yCoords.add(0);
    	yCoords.add(2);
    	yCoords.add(0);
    	yCoords.add(2);
    	yCoords.add(0);
    	List<Double> angleList = calculateHeadings(xCoords, yCoords);
		turtle.turn(angleList.get(0));
		turtle.forward(100);
		turtle.turn(angleList.get(1));
		turtle.forward(144);
		turtle.turn(angleList.get(2));
		turtle.forward(100);
		turtle.turn(angleList.get(3));
		turtle.forward(144);
    	
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        drawPersonalArt(turtle);

        // draw the window
        turtle.draw();
    }

}
