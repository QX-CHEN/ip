import java.util.Scanner;

public class Duke {
    // Assume no more than 100 tasks
    private static final int MAX_TASKS = 100;
    private static final Task[] tasks = new Task[MAX_TASKS];
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
            System.out.println(tasks[i]);
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

    public static void addTask(String task) {
        if (task.startsWith("todo")) {
            tasks[taskCount] = new Todo(task.replace("todo", "").trim());
        } else if  (task.startsWith("deadline")) {
            String[] deadlineInfo = task.replace("deadline", "").split("/by");
            tasks[taskCount] = new Deadline(deadlineInfo[0].trim(), deadlineInfo[1].trim());
        } else if (task.startsWith("event")) {
            String[] eventInfo = task.replace("event", "").split("/at");
            tasks[taskCount] = new Event(eventInfo[0].trim(), eventInfo[1].trim());
        } else {
            System.out.println("No such task");
        }

        printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks[taskCount]);
        taskCount++;
        System.out.println("\t Now you have " + taskCount + " tasks in the list.");
        printHorizontalLine();
    }

    public static void markAsDone(int taskNum) {
        // Did not check whether the task is done or exists
        tasks[taskNum - 1].setDone(true);
        printHorizontalLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks[taskNum - 1]);
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
            addTask(command);
        }
        return loop;
    }

}
