import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import storage.Storage;

import java.util.Scanner;



public class Duke {

    private static TaskList tasks = new TaskList();

    public static void main(String[] args) {
        greet();
        Storage.loadTasks(tasks);
        Scanner scanner = new Scanner(System.in);
        while (executeCommand(scanner.nextLine()));
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
        printMessage("\t Hello! I'm Duke" + System.lineSeparator() +
                "\t What can I do for you?");
    }

    public static void bye() {
        printMessage("\t Bye. Hope to see you again soon!");
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
                tasks.list();
            } else if (trimmedCommand.startsWith("done")) {
                int taskNum = Integer.parseInt(trimmedCommand.split(" ")[1]);
                tasks.markAsDone(taskNum);
                Storage.updateFile(tasks);
            } else if (trimmedCommand.startsWith("delete")) {
                int taskNum = Integer.parseInt(trimmedCommand.split(" ")[1]);
                tasks.deleteTask(taskNum);
                Storage.updateFile(tasks);
            } else {
                tasks.addTask(trimmedCommand);
                Storage.updateFile(tasks);
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
