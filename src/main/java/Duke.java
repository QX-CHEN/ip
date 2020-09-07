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

    public static void addTask(String trimmedCommand) throws UnknownCommandException, InvalidCommandException {
        // Did not handle empty description
        if (trimmedCommand.startsWith("todo")) {
            String todoInfo = trimmedCommand.replace("todo", "").trim();
            if (isEmptyDescription(todoInfo)) {
                throw new InvalidCommandException();
            }
            tasks[taskCount] = new Todo(todoInfo);
        } else if  (trimmedCommand.startsWith("deadline")) {
            String[] deadlineInfo = trimmedCommand.replace("deadline", "").split("/by");
            if (isEmptyDescription(deadlineInfo[0].trim()) || deadlineInfo.length != 2) {
                throw new InvalidCommandException();
            }
            tasks[taskCount] = new Deadline(deadlineInfo[0].trim(), deadlineInfo[1].trim());
        } else if (trimmedCommand.startsWith("event")) {
            String[] eventInfo = trimmedCommand.replace("event", "").split("/at");
            if (isEmptyDescription(eventInfo[0].trim()) || eventInfo.length != 2) {
                throw new InvalidCommandException();
            }
            tasks[taskCount] = new Event(eventInfo[0].trim(), eventInfo[1].trim());
        } else {
            throw new UnknownCommandException();
        }

        printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks[taskCount++]);
        System.out.println("\t Now you have " + taskCount + " tasks in the list.");
        printHorizontalLine();
    }

    public static boolean isEmptyDescription(String description) {
        return ("".equals(description));
    }

    public static void markAsDone(int taskNum) {
        // Did not check whether the task is done
        if (taskNum <= 0 || taskNum > taskCount) {
            System.out.println("Invalid task number!");
            return;
        }
        tasks[taskNum - 1].setDone(true);
        printHorizontalLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks[taskNum - 1]);
        printHorizontalLine();
    }

    public static boolean executeCommand(String rawCommand) {
        boolean loop = true;
        // remove leading and trailing space
        String trimmedCommand = rawCommand.trim();
        try {
            if (trimmedCommand.startsWith("bye")) {
                bye();
                loop = false;
            } else if (trimmedCommand.startsWith("list")) {
                list();
            } else if (trimmedCommand.startsWith("done")) {
                markAsDone(Integer.parseInt(trimmedCommand.split(" ")[1]));
            } else {
                addTask(trimmedCommand);
            }
        }  catch (NumberFormatException e) {
            System.out.println("Task number should be numeric and within Integer range!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide task number for done command!");
        } catch (UnknownCommandException | InvalidCommandException e) {
            // Possible Errors: event with /by, deadline with /at, todo, event, deadline
            System.out.println(e);
        }
        return loop;
    }
}
