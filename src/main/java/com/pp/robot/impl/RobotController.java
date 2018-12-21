package com.pp.robot.impl;

import com.pp.robot.coordinates.TableTop;
import com.pp.robot.factory.CommandFactory;
import com.pp.robot.helper.CommandHelper;

import java.util.List;

/**
 * This class defines run implementation for Robot
 */
public class RobotController {

    private TableTop tableTop;
    private Robot robot;

    public RobotController(TableTop tableTop) {
        this.tableTop = tableTop;
        robot = new Robot();
    }

    /**
     * The run method loops over the list of command issued
     * Each command instance is fetched using CommandFactory
     *
     * @param commandList
     */
    public void execute(List<String> commandList) {
        CommandHelper.getCommands(commandList).forEach(command -> {
            try {
                CommandFactory.getCommandInstance(command).execute(robot, tableTop);
            } catch (RobotException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

}