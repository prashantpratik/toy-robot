package com.pp.robot.impl;

import com.pp.robot.coordinates.Coordinate;

/**
 * This interface declares base method required for Robot
 */
public class Robot {
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isRobotPlaced() {
        return !(null == this.getCoordinate());
    }
}
