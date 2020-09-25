import commands.ByeCommand;
import commands.Command;
import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.util.Scanner;

/**
 * Duke class starts, runs and stops the main program.
 *
 * @author Chen Qixing
 * @version 0.1
 * @since 16 AUG 2020
 */
public class Duke {

    private static final TaskList tasks = new TaskList();

    /**
     * Reads data from file and runs main program.
     */
    public static void main(String[] args) {
        Storage.loadTasks(tasks);
        run();
    }


    private static void run() {
        Scanner scanner = new Scanner(System.in);
        Ui.greet();
        boolean running = true;
        while (running) {
            try {
                Command command = Parser.processInput(scanner.nextLine());
                command.execute(tasks);
                if (command instanceof ByeCommand) {
                    running = false;
                }
            }  catch (NumberFormatException e) {
                Ui.printMessageWithNewLine("\tInvalid task number!");
            } catch (UnknownCommandException | InvalidCommandException e) {
                Ui.printMessageWithNewLine(e);
            }
        }
    }
}
