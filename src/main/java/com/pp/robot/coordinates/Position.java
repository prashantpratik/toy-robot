package com.pp.robot.coordinates;

import java.util.Objects;

/**
 * This class represents position of robot in two dimension
 * It contains initial position and fina position
 * These values are used to determine initial position
 * and maximum position allowed for robot to move
 */
public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public static Position getFinalPosition() {
//        return finalPosition;
//    }
//
//    public static Position getInitialPosition() {
//        return initialPosition;
//    }

    ;

//    /**
//     * This method initializes the robot with initial and maximum allowed positions
//     *
//     * @param finalX
//     * @param finalY
//     * @param initialX
//     * @param initialY
//     */
//    public static void initPosition(int finalX, int finalY, int initialX, int initialY) {
//        finalPosition = new Position(finalX, finalY);
//        initialPosition = new Position(initialX, initialY);
//    }

    /**
     * This method returns the position of robot in String format.
     *
     * @return
     */
    @Override
    public String toString() {
        return Integer.toString(x) + "," + Integer.toString(y) + ",";
    }

    public int getX() {
        return x;
    }

    public Position setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Position setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
