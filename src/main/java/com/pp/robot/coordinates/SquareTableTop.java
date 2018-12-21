package com.pp.robot.coordinates;

public class SquareTableTop implements TableTop {

    private Position finalPosition;
    private Position initialPosition;

    public SquareTableTop(int finalX, int finalY, int initialX, int initialY) {
        finalPosition = new Position(finalX, finalY);
        initialPosition = new Position(initialX, initialY);
    }

    public Position getFinalPosition() {
        return finalPosition;
    }


    public Position getInitialPosition() {
        return initialPosition;
    }

    @Override
    public boolean isValidPosition(Position nextPosition) {
        return !(nextPosition.getX() < initialPosition.getX() || nextPosition.getX() > finalPosition.getX()
                || nextPosition.getY() < initialPosition.getY() || nextPosition.getY() > finalPosition.getY());
    }

}
