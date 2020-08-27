import java.util.Scanner;

public class Duke {
    // Assume no more than 100 tasks
    private static Task[] tasks = new Task[100];
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
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.print("\t " + (i + 1) + ". ");
            // print tick or cross
            System.out.print(tasks[i].isDone() ? "[\u2714] " : "[\u2716] ");
            System.out.println(tasks[i].getDescription());
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
        tasks[taskCount++] = new Task(task);
        printMessage("\t added: " + task);
    }

    public static void markAsDone(int taskNum) {
        // Did not check whether the task is done or exists
        tasks[taskNum - 1].setDone(true);
        printHorizontalLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   [\u2714] " + tasks[taskNum - 1].getDescription());
        printHorizontalLine();
    }

    public static boolean executeCommand(String command) {
        boolean loop = true;
        String[] commandWords = command.split(" ");
        if (command.equals("bye")) {
            bye();
            loop = false;
        } else if (command.equals("list")) {
            list();
        } else if (commandWords[0].equals("done")) {
            markAsDone(Integer.parseInt(commandWords[1]));
        } else {
//            echo(command);
            addTask(command);
        }
        return loop;
    }

}
