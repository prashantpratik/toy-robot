//package com.anz.robot.commands;
//
//import Coordinate;
//import Direction;
//import Position;
//import RobotException;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class CommandsTest {
//    private Coordinate coordinate;
//    private Position position;
//    private Direction direction;
//
//    @Before
//    public void setUp() {
//        position = new Position(0, 0);
//        Position.initPosition(5, 5, 0, 0);
//        direction = Direction.NORTH;
//        coordinate = new Coordinate();
//        coordinate.setDirection(direction);
//        coordinate.setPosition(position);
//    }
//
//    @Test
//    public void testPlaceCommand() throws RobotException {
//        Coordinate myCoordinate = PlaceCommand.getInstance().setCoordinate(coordinate, "2", "1", "SOUTH");
//        assertEquals(2, myCoordinate.getPosition().getX());
//        assertEquals(1, myCoordinate.getPosition().getY());
//        assertEquals(Direction.SOUTH, myCoordinate.getDirection());
//    }
//
//    @Test(expected = RobotException.class)
//    public void testPlaceCommandExecute() throws RobotException {
//        PlaceCommand.getInstance().execute(coordinate);
//    }
//
//}
