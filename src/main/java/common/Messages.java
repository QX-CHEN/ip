package common;

public class Messages {
    public static final String HORIZONTAL_LINE = "\t______________________________" +
            "______________________________";
    public static final String GREET = "\t Hello! I'm Duke" + System.lineSeparator() +
            "\t What can I do for you?";
    public static final String BYE = "\t Bye. Hope to see you again soon!";

    public static void printHorizontalLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public static void printMessage(String message) {
        printHorizontalLine();
        System.out.println(message);
        printHorizontalLine();
    }

    public static void greet() {
        printMessage(GREET);
    }

    public static void bye() {
        printMessage(BYE);
    }
}
