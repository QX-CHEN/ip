import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    // Assume no more than 100 tasks
    private static final int MAX_TASKS = 100;
    private static final ArrayList<Task> tasks = new ArrayList<>(MAX_TASKS);

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
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print("\t " + (i + 1) + ". ");
            System.out.println(tasks.get(i));
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
        if (trimmedCommand.startsWith("todo")) {
            String todoInfo = trimmedCommand.replace("todo", "").trim();
            if (isEmptyDescription(todoInfo)) {
                throw new InvalidCommandException();
            }
            tasks.add(new Todo(todoInfo));
        } else if  (trimmedCommand.startsWith("deadline")) {
            String[] deadlineInfo = trimmedCommand.replace("deadline", "").split("/by");
            if (isEmptyDescription(deadlineInfo[0].trim()) || deadlineInfo.length != 2) {
                throw new InvalidCommandException();
            }
            String description = deadlineInfo[0].trim();
            String datetime = deadlineInfo[1].trim();
            tasks.add(new Deadline(description, datetime));
        } else if (trimmedCommand.startsWith("event")) {
            String[] eventInfo = trimmedCommand.replace("event", "").split("/at");
            if (isEmptyDescription(eventInfo[0].trim()) || eventInfo.length != 2) {
                throw new InvalidCommandException();
            }
            String description = eventInfo[0].trim();
            String datetime = eventInfo[1].trim();
            tasks.add(new Event(description, datetime));
        } else {
            throw new UnknownCommandException();
        }

        printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks.get(tasks.size() - 1));
        System.out.println("\t Now you have " + tasks.size() + " tasks in the list.");
        printHorizontalLine();
    }

    public static boolean isEmptyDescription(String description) {
        return ("".equals(description));
    }

    public static void markAsDone(int taskNum) {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            System.out.println("\tInvalid task number!");
            return;
        } else if (tasks.get(taskNum - 1).isDone()) {
            System.out.println("\tTask already done!");
            return;
        }
        tasks.get(taskNum - 1).setDone(true);
        printHorizontalLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks.get(taskNum - 1));
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
                int taskNum = Integer.parseInt(trimmedCommand.split(" ")[1]);
                markAsDone(taskNum);
            } else {
                addTask(trimmedCommand);
            }
        }  catch (NumberFormatException e) {
            System.out.println("\tTask number should be numeric and within Integer range!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\tPlease provide task number for done command!");
        } catch (UnknownCommandException | InvalidCommandException e) {
            System.out.println(e);
        }
        return loop;
    }
}
