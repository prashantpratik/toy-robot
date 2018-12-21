package com.pp.robot.factory;

import com.pp.robot.commands.BaseCommand;
import com.pp.robot.commands.Command;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandFactoryTest {

    @Test
    public void testPlaceCommand() {
        assertTrue(CommandFactory.getCommandInstance(new Command("PLACE")) instanceof BaseCommand);
    }

    @Test
    public void testLeftCommand() {
        assertTrue(CommandFactory.getCommandInstance(new Command("LEFT")) instanceof BaseCommand);
    }

    @Test
    public void testRightCommand() {
        assertTrue(CommandFactory.getCommandInstance(new Command("RIGHT")) instanceof BaseCommand);
    }

    @Test
    public void testMoveCommand() {
        assertTrue(CommandFactory.getCommandInstance(new Command("MOVE")) instanceof BaseCommand);
    }
}
