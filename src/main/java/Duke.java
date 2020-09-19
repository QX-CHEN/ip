
import common.Messages;
import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import storage.Storage;
import commands.ByeCommand;
import commands.Command;
import parser.Parser;

import java.util.Scanner;


public class Duke {

    private static final TaskList tasks = new TaskList();

    public static void main(String[] args) {
        Messages.greet();
        Storage.loadTasks(tasks);
        Scanner scanner = new Scanner(System.in);
        while (executeCommand(scanner.nextLine()));

    }

    public static boolean executeCommand(String rawCommand) {
        boolean loop = true;
        try {
            Command command = Parser.processInput(rawCommand);
            command.execute(tasks);
            if (command instanceof ByeCommand) {
                loop = false;
            }
        }  catch (NumberFormatException e) {
            System.out.println("\tInvalid task number!");
        } catch (UnknownCommandException | InvalidCommandException e) {
            System.out.println(e);
        }
        return loop;
    }
}
