package com.pp.robot.impl;

import com.pp.robot.coordinates.SquareTableTop;
import com.pp.robot.coordinates.TableTop;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RobotControllerTest {
    private RobotController controller;
    private OutputStream os;

    @Before
    public void setUp() {
        TableTop tableTop = new SquareTableTop(5, 5, 0, 0);
        controller = new RobotController(tableTop);
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    @Test
    public void testRun() {
        List<String> commandList = Arrays.asList("PLACE 0,0,NORTH",
                "LEFT",
                "MOVE", "REPORT");
        controller.execute(commandList);
        assertEquals("Processing command: PLACE 0,0,NORTH\n" +
                "Processing command: LEFT\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "0,0,WEST\n", os.toString());
    }

    @Test
    public void testRobotNotFallUp() {
        List<String> commandList = Arrays.asList("PLACE 4,4,EAST",
                "LEFT",
                "MOVE", "MOVE", "MOVE", "MOVE", "REPORT");
        controller.execute(commandList);
        assertEquals("Processing command: PLACE 4,4,EAST\n" +
                "Processing command: LEFT\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "4,5,NORTH\n", os.toString());
    }

    @Test
    public void testRobotNotFallRight() {
        List<String> commandList = Arrays.asList("PLACE 4,2,NORTH",
                "RIGHT",
                "MOVE", "MOVE", "MOVE", "MOVE", "REPORT");
        controller.execute(commandList);
        assertEquals("Processing command: PLACE 4,2,NORTH\n" +
                "Processing command: RIGHT\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "5,2,EAST\n", os.toString());
    }

    @Test
    public void testRobotNotFallLeft() {
        List<String> commandList = Arrays.asList("PLACE 0,0,NORTH",
                "LEFT",
                "MOVE", "MOVE", "MOVE", "MOVE", "REPORT");
        controller.execute(commandList);
        assertEquals("Processing command: PLACE 0,0,NORTH\n" +
                "Processing command: LEFT\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "0,0,WEST\n", os.toString());
    }

    @Test
    public void testRobotNotFallDown() {
        List<String> commandList = Arrays.asList("PLACE 0,0,WEST",
                "LEFT",
                "MOVE", "MOVE", "MOVE", "MOVE", "REPORT");
        controller.execute(commandList);
        assertEquals("Processing command: PLACE 0,0,WEST\n" +
                "Processing command: LEFT\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "0,0,SOUTH\n", os.toString());
    }

    @Test
    public void testRobotException() {
        List<String> commandList = Arrays.asList("PLACE 0,0,WEST",
                "LEFT",
                "MOVE", "MOVE", "MOVE", "MOVE", "SOMETHING");
        controller.execute(commandList);
        assertEquals("Processing command: PLACE 0,0,WEST\n" +
                "Processing command: LEFT\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: SOMETHING\n" +
                "Unknown Command\n", os.toString());
    }
}
