import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        greet();
        while (executeCommand(in.nextLine()));
    }

    public static void printHorizontalLine() {
        System.out.println("\t______________________________" +
                "______________________________");
    }

    public static void printMessage(String message) {
        printHorizontalLine();
        System.out.println(message);
        printHorizontalLine();
    }

    public static void greet() {
        printMessage("\t Hello! I'm Duke\n\t What can I do for you?");
    }

    public static void bye() {
        printMessage("\t Bye. Hope to see you again soon!");
    }

    public static void echo(String str) {
        printMessage("\t " + str);
    }

    public static boolean executeCommand(String command) {
        boolean loop = true;
        if (command.equals("bye")) {
            bye();
            loop = false;
        } else {
            echo(command);
        }
        return loop;
    }

}
