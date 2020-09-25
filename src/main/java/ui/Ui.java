package ui;

import data.TaskList;
import tasks.Task;

/**
 * Ui class handles printing of messages.
 */
public class Ui {
    private static final String HORIZONTAL_LINE = "\t______________________________" +
            "______________________________";
    private static final String GREET = "\t Hello! I'm Duke" + System.lineSeparator() +
            "\t What can I do for you?";
    private static final String BYE = "\t Bye. Hope to see you again soon!";

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
     * Prints a message with a new line character at the end.
     *
     * @param message message to be printed with new line character.
     */
    public static void printMessageWithNewLine(String message) {
        System.out.println(message);
    }

    /**
     * Prints an exception message with a new line character at the end.
     *
     * @param e exception to be printed with new line character.
     */
    public static void printMessageWithNewLine(Exception e) {
        System.out.println(e);
    }

    /**
     * Prints a message without a new line character at the end.
     *
     * @param message message to be printed with new line character.
     */
    public static void printMessageWithoutNewLine(String message) {
        System.out.print(message);
    }

    /**
     * Prints a greeting message.
     */
    public static void greet() {
        printMessageWithHorizontalLines(GREET);
    }

    /**
     * Prints a bye message.
     */
    public static void bye() {
        printMessageWithHorizontalLines(BYE);
    }

    /**
     * Prints an added task message.
     *
     * @param tasks latest TaskList object after adding the new task.
     */
    public static void printAddMessage(TaskList tasks) {
        printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks.get(tasks.size() - 1));
        System.out.println("\t Now you have " + tasks.size() + " task(s) in the list.");
        printHorizontalLine();
    }

    /**
     * Prints task information.
     *
     * @param task task object.
     */
    public static void printTask(Task task) {
        System.out.println(task);
    }

}
