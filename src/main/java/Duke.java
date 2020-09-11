import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Duke {
    // Assume no more than 100 tasks
    private static final int MAX_TASKS = 100;
    private static final Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;
    private static final String FILE_PATH = "data/Duke.txt";

    public static void main(String[] args) {
        loadTasks();
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
            String description = deadlineInfo[0].trim();
            String datetime = deadlineInfo[1].trim();
            tasks[taskCount] = new Deadline(description, datetime);
        } else if (trimmedCommand.startsWith("event")) {
            String[] eventInfo = trimmedCommand.replace("event", "").split("/at");
            if (isEmptyDescription(eventInfo[0].trim()) || eventInfo.length != 2) {
                throw new InvalidCommandException();
            }
            String description = eventInfo[0].trim();
            String datetime = eventInfo[1].trim();
            tasks[taskCount] = new Event(description, datetime);
        } else {
            throw new UnknownCommandException();
        }

        printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks[taskCount++]);
        System.out.println("\t Now you have " + taskCount + " tasks in the list.");
        printHorizontalLine();
        updateFile();
    }

    public static boolean isEmptyDescription(String description) {
        return ("".equals(description));
    }

    public static void markAsDone(int taskNum) {
        if (taskNum <= 0 || taskNum > taskCount) {
            System.out.println("\tInvalid task number!");
            return;
        } else if (tasks[taskNum - 1].isDone()) {
            System.out.println("\tTask already done!");
            return;
        }
        tasks[taskNum - 1].setDone(true);
        printHorizontalLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks[taskNum - 1]);
        printHorizontalLine();
        updateFile();
    }

    public static void updateFile() {
        try {
            writeTasksToFile();
        } catch (IOException e) {
            // relative path is different for testing
            System.out.println("Check file path!");
        }
    }

    public static void writeTasksToFile() throws IOException {
        FileWriter file = new FileWriter(FILE_PATH);
        for (int i = 0; i < taskCount; i++) {
            file.write(tasks[i].getCode() + "|" + (tasks[i].isDone() ? "1" : "0") + "|" +
                    tasks[i].getDescription() + "|" + tasks[i].getDatetime() + System.lineSeparator());
        }
        file.close();
    }

    public static void loadTasks() {
        try {
            readTasksFromFile();
        } catch (FileNotFoundException e) {
            // relative path is different for testing
            System.out.println("File not found!");
        }
    }

    public static void readTasksFromFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            processLine(scanner.nextLine());
        }
    }

    public static void processLine(String line) {
        String[] parts = line.split("\\|");
        boolean done = (!"0".equals(parts[1]));
        switch (parts[0]) {
        case "T":
            tasks[taskCount++] = new Todo(done, parts[2]);
            break;
        case "E":
            tasks[taskCount++] = new Event(done, parts[2], parts[3]);
            break;
        case "D":
            tasks[taskCount++] = new Deadline(done, parts[2], parts[3]);
            break;
        default:
            break;
        }
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
