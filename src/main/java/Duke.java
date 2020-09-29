import commands.ByeCommand;
import commands.Command;
import commands.CommandResult;
import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.InvalidTaskNumberException;
import exceptions.TaskDoneException;
import exceptions.UnknownCommandException;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.util.Scanner;

import static common.Message.*;

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

    /**
     * Run the main program and stop when a bye command is given.
     */
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        Ui.greet();
        boolean running = true;
        while (running) {
            try {
                Command command = Parser.processInput(scanner.nextLine());
                CommandResult result = command.execute(tasks);
                Ui.printCommandResult(result);
                if (command instanceof ByeCommand) {
                    running = false;
                }
            } catch (NumberFormatException | InvalidTaskNumberException e) {
                Ui.printMessageWithHorizontalLines(INVALID_TASK_NUMBER_MESSAGE);
            } catch (UnknownCommandException e) {
                Ui.printMessageWithHorizontalLines(UNKNOWN_COMMAND_MESSAGE);
            } catch (InvalidCommandException e) {
                Ui.printMessageWithHorizontalLines(INVALID_COMMAND_MESSAGE);
            } catch (TaskDoneException e) {
                Ui.printMessageWithHorizontalLines(TASK_ALREADY_DONE_MESSAGE);
            }
        }
    }
}
