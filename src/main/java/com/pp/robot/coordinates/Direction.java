package com.pp.robot.coordinates;

/**
 * Enum which defines direction of the robot
 */
public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    /**
     * This method will change the direction of the robot
     * to left based on it's current direction
     *
     * @return
     */
    public Direction left() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                return null;
        }
    }

    /**
     * This method will change the direction of the robot
     * to right based on it's current direction
     *
     * @return
     */
    public Direction right() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return null;
        }
    }


}
