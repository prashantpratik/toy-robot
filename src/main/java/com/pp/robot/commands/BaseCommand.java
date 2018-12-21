package com.pp.robot.commands;

import com.pp.robot.coordinates.TableTop;
import com.pp.robot.impl.Robot;
import com.pp.robot.impl.RobotException;

/**
 * Base command interface
 * Contains one abstract method
 */
@FunctionalInterface
public interface BaseCommand {
    void execute(Robot robot, TableTop tableTop) throws RobotException;
}
