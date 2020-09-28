package ui;

import commands.CommandResult;
import data.TaskList;
import tasks.Task;

import static common.Message.GREET_MESSAGE;
import static common.Message.HORIZONTAL_LINE;

/**
 * Ui class handles printing of messages.
 */
public class Ui {
    /**
     * Prints a dash line.
     */
    public static void printHorizontalLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Prints a message in between two dash lines.
     *
     * @param message message to be printed in between the lines.
     */
    public static void printMessageWithHorizontalLines(String message) {
        printHorizontalLine();
        System.out.println(message);
        printHorizontalLine();
    }

    /**
     * Prints greeting message.
     */
    public static void greet() {
        printMessageWithHorizontalLines(GREET_MESSAGE);
    }

    public static void printCommandResult(CommandResult commandResult) {
        printHorizontalLine();
        System.out.println(commandResult.getMessage());
        TaskList tasks = commandResult.getTasks();
        Task task = commandResult.getTask();
        int numOfTasks = commandResult.getNumOfTasks();
        if (tasks != null) {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.print("\t " + (i + 1) + ". ");
                System.out.println(tasks.get(i));
            }
        } else if (task != null){
            System.out.println("\t   " + task);
            if (numOfTasks >= 0) {
                System.out.println("\t Now you have " + numOfTasks + " task(s) in the list.");
            }
        }
        printHorizontalLine();
    }

}
