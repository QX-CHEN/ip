package ui;

import data.TaskList;
import tasks.Task;

public class Ui {
    private static final String HORIZONTAL_LINE = "\t______________________________" +
            "______________________________";
    private static final String GREET = "\t Hello! I'm Duke" + System.lineSeparator() +
            "\t What can I do for you?";
    private static final String BYE = "\t Bye. Hope to see you again soon!";

    public static void printHorizontalLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printMessageWithHorizontalLines(String message) {
        printHorizontalLine();
        System.out.println(message);
        printHorizontalLine();
    }

    public static void printMessageWithNewLine(String message) {
        System.out.println(message);
    }

    public static void printMessageWithNewLine(Exception e) {
        System.out.println(e);
    }

    public static void printMessageWithoutNewLine(String message) {
        System.out.print(message);
    }

    public static void greet() {
        printMessageWithHorizontalLines(GREET);
    }

    public static void bye() {
        printMessageWithHorizontalLines(BYE);
    }

    public static void printAddMessage(TaskList tasks) {
        printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks.get(tasks.size() - 1));
        System.out.println("\t Now you have " + tasks.size() + " task(s) in the list.");
        printHorizontalLine();
    }

    public static void printTask(Task task) {
        System.out.println(task);
    }

}
