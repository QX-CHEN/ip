import java.util.Scanner;

public class Duke {
    // Assume no more than 100 tasks
    private static String[] tasks = new String[100];
    private static int taskCount = 0;

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

    public static void list() {
        printHorizontalLine();
        for (int i = 0; i < taskCount; i++) {
            System.out.println("\t " + (i + 1) + ". " + tasks[i]);
        }
        printHorizontalLine();
    }

    public static void greet() {
        printMessage("\t Hello! I'm Duke" + System.lineSeparator() +
                "\t What can I do for you?");
    }

    public static void bye() {
        printMessage("\t Bye. Hope to see you again soon!");
    }

    public static void echo(String str) {
        printMessage("\t " + str);
    }

    public static void addTask(String task) {
        tasks[taskCount++] = task;
        printMessage("\t added: " + task);
    }

    public static boolean executeCommand(String command) {
        boolean loop = true;
        if (command.equals("bye")) {
            bye();
            loop = false;
        } else if (command.equals("list")) {
            list();
        } else {
//            echo(command);
            addTask(command);
        }
        return loop;
    }

}
