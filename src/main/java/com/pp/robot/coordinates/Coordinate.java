package com.pp.robot.coordinates;

import java.util.Objects;

/**
 * This class contains Position and Direction
 * of the robot.
 */
public class Coordinate {
    private Position position;
    private Direction direction;

    public Position getPosition() {
        return position;
    }

    public Coordinate setPosition(Position position) {
        this.position = position;
        return this;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return position.getX() == that.position.getX() && position.getY() == that.position.getY() &&
                direction == that.direction;
    }

    /**
     * This method returns the co-ordinates of robot in String format
     *
     * @return
     */
    @Override
    public String toString() {
        return position +
                direction.toString();
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinate setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public boolean isEmpty() {
        return position == null && direction == null;
    }
}
