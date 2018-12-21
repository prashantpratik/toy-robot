package com.pp.robot.helper;

import com.pp.robot.commands.Command;
import com.pp.robot.coordinates.Position;
import com.pp.robot.impl.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandHelper {
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";

    public static Position getPosition(Robot robot) {
        switch (robot.getCoordinate().getDirection()) {
            case NORTH:
                return new Position(robot.getCoordinate().getPosition().getX(), robot.getCoordinate().getPosition().getY() + 1);
            case SOUTH:
                return new Position(robot.getCoordinate().getPosition().getX(), robot.getCoordinate().getPosition().getY() - 1);
            case EAST:
                return new Position(robot.getCoordinate().getPosition().getX() + 1, robot.getCoordinate().getPosition().getY());
            case WEST:
                return new Position(robot.getCoordinate().getPosition().getX() - 1, robot.getCoordinate().getPosition().getY());
            default:
                return null;
        }
    }

    public static List<Command> getCommands(List<String> commandListString) {
        List<Command> commandList = new ArrayList<>();
        commandListString.forEach(command -> {
            System.out.println("Processing command: " + command);
                    List<String> tokenList = Pattern.compile(SPACE)
                            .splitAsStream(command)
                            .collect(Collectors.toList());
                    Command newCommand = new Command(tokenList.get(0));
                    if (tokenList.size() > 1) {
                        newCommand.setParams(Pattern.compile(DELIMITER).splitAsStream(tokenList.get(1)).collect(Collectors.toList()));
                    }
                    commandList.add(newCommand);
                }
        );
        return commandList;
    }
}
