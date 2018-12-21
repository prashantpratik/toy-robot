package com.pp.robot.factory;

import com.pp.robot.commands.BaseCommand;
import com.pp.robot.commands.Command;
import com.pp.robot.coordinates.Coordinate;
import com.pp.robot.coordinates.Direction;
import com.pp.robot.coordinates.Position;
import com.pp.robot.coordinates.TableTop;
import com.pp.robot.helper.CommandHelper;
import com.pp.robot.impl.Robot;
import com.pp.robot.impl.RobotException;

import java.util.logging.Logger;

/**
 * This is a factory class to get instances of Commands issued
 * Lambda expression are used to implement functional interface
 * Only PlaceCommand has got it's own implementation of setCoordinate
 */
public class CommandFactory {
    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class.getName());

    /**
     * This method returns the Command instance
     *
     * @param command
     * @return
     */
    public static BaseCommand getCommandInstance(Command command) {
        switch (command.getCommand()) {
            case "LEFT":
                return ((robot, tableTop) -> {
                    if (robot.isRobotPlaced())
                        executeDirection(robot, robot.getCoordinate().getDirection().left());
                    else
                        throw new RobotException("Robot is not placed yet");
                });
            case "RIGHT":
                return ((robot, tableTop) -> {
                    if (robot.isRobotPlaced())
                        executeDirection(robot, robot.getCoordinate().getDirection().right());
                    else
                        throw new RobotException("Robot is not placed yet");
                });
            case "MOVE":
                return ((robot, tableTop) -> {
                    if (robot.isRobotPlaced())
                        executeMoveCommand(robot, tableTop);
                    else
                        throw new RobotException("Robot is not placed yet");
                });
            case "REPORT":
                return ((robot, tableTop) -> printReport(robot));
            case "PLACE":
                return ((robot, tableTop) -> executePlaceCommand(robot, tableTop, command));
            default:
                return ((robot, tableTop) -> {
                    throw new RobotException("Unknown Command");
                });
        }

    }

    /**
     * This method defines the behavior of REPORT command
     *
     * @return
     */
    private static void printReport(Robot robot) {
        System.out.println(robot.getCoordinate());
    }

    /**
     * This method defines the behavior of LEFT or RIGHT commands
     *
     * @param direction
     * @return
     */
    private static void executeDirection(Robot robot, Direction direction) {
        robot.getCoordinate().setDirection(direction);
    }

    /**
     * This method defines the behavior of MOVE command
     * Each move is checked against initial or final
     * allowed position based on direction
     * If it satisfies the condition, move happens
     * else the command is ignored
     *
     * @return
     */
    private static void executeMoveCommand(Robot robot, TableTop tableTop) {
        Position nextPosition = CommandHelper.getPosition(robot);
        if (tableTop.isValidPosition(nextPosition))
            robot.getCoordinate().setPosition(nextPosition);
    }

    private static void executePlaceCommand(Robot robot, TableTop tableTop, Command command) throws RobotException {
        Position newPosition = new Position(Integer.parseInt(command.getParams().get(0)), Integer.parseInt(command.getParams().get(1)));
        if (tableTop.isValidPosition(newPosition)) {
            if (null == robot.getCoordinate()) {
                robot.setCoordinate(new Coordinate());
            }
            robot.getCoordinate().setPosition(newPosition);
            robot.getCoordinate().setDirection(Direction.valueOf(command.getParams().get(2)));
        } else
            throw new RobotException("Robot placement now allowed at :" + command.getParams().get(0) + ", " + command.getParams().get(1));
    }
}
