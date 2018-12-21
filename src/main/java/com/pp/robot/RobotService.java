package com.pp.robot;

import com.pp.robot.coordinates.SquareTableTop;
import com.pp.robot.coordinates.TableTop;
import com.pp.robot.impl.RobotController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RobotService {
    /**
     * Main method which accepts file as input
     * Commands are trimmed and converted to uppercase
     * and then passed to RobotController for processing
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        while (true) {
            System.out.print("Please input a file name to read commands:");
            fileName = scanner.nextLine();
            if (fileName == null || fileName.isEmpty())
                System.out.println("File name not specified. Please specify a file name to execute commands");
            else
                break;
        }
        List<String> commandList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {// try with resource
            commandList = stream.map(String::trim).map(String::toUpperCase).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("Unable to read file: " + fileName);
        }
        TableTop squareTableTop = new SquareTableTop(5, 5, 0, 0);
        RobotController controller = new RobotController(squareTableTop);
        controller.execute(commandList);
    }
}
