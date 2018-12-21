package com.pp.robot.integration;

import com.pp.robot.RobotService;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RobotIntegrationTest {
    OutputStream os;

    @Before
    public void setup() {
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    @Test
    public void testMain1() {
        System.setIn(new ByteArrayInputStream("src/test/resources/test1.txt".getBytes()));
        RobotService.main(new String[]{});
        assertEquals("Please input a file name to read commands:Processing command: PLACE 0,0,NORTH\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "0,1,NORTH\n", os.toString());
    }

    @Test
    public void testMain2() {
        System.setIn(new ByteArrayInputStream("src/test/resources/test2.txt".getBytes()));
        RobotService.main(new String[]{});
        assertEquals("Please input a file name to read commands:Processing command: PLACE 1,2,EAST\n" +
                "Processing command: MOVE\n" +
                "Processing command: MOVE\n" +
                "Processing command: LEFT\n" +
                "Processing command: MOVE\n" +
                "Processing command: REPORT\n" +
                "3,3,NORTH\n", os.toString());
    }

    @Test
    public void testMain3() {
        System.setIn(new ByteArrayInputStream("src/test/resources/test3.txt".getBytes()));
        RobotService.main(new String[]{});
        assertEquals("Please input a file name to read commands:Processing command: PLACE 0,0,NORTH\n" +
                "Processing command: LEFT\n" +
                "Processing command: REPORT\n" +
                "0,0,WEST\n", os.toString());
    }

    @Test
    public void testMainFail() {
        System.setIn(new ByteArrayInputStream("abc".getBytes()));
        RobotService.main(new String[]{});
        assertEquals("Please input a file name to read commands:Unable to read file: abc\n", os.toString());
    }
}
