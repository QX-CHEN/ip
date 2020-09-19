package ui;

import commands.Command;
import common.Messages;
import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import parser.Parser;

import java.util.Scanner;

public class Ui {
    private static boolean running;

    public static void run(TaskList tasks) {
        Scanner scanner = new Scanner(System.in);
        Messages.greet();
        running = true;
        while (running) {
            try {
                Command command = Parser.processInput(scanner.nextLine());
                command.execute(tasks);
            }  catch (NumberFormatException e) {
                System.out.println("\tInvalid task number!");
            } catch (UnknownCommandException | InvalidCommandException e) {
                System.out.println(e);
            }
        }
    }

    public static void stop() {
        running = false;
    }
}
