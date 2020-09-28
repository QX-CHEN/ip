import commands.ByeCommand;
import commands.Command;
import commands.CommandResult;
import data.TaskList;
import exceptions.*;
import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.io.IOException;
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
        try {
            Storage.loadTasks(tasks);
            run();
        } catch (NumberFormatException | InvalidTaskNumberException e) {
            Ui.printMessageWithHorizontalLines(INVALID_TASK_NUMBER_MESSAGE);
        } catch (UnknownCommandException e) {
            Ui.printMessageWithHorizontalLines(UNKNOWN_COMMAND_MESSAGE);
        } catch (InvalidCommandException e) {
            Ui.printMessageWithHorizontalLines(INVALID_COMMAND_MESSAGE);
        } catch (TaskDoneException e) {
            Ui.printMessageWithHorizontalLines(TASK_ALREADY_DONE_MESSAGE);
        } catch (UnknownDateFormatException e) {
            Ui.printMessageWithHorizontalLines(UNKNOWN_DATE_FORMAT_MESSAGE);
        } catch (IOException e) {
            Ui.printMessageWithHorizontalLines(FILE_NOT_FOUND_MESSAGE);
        } catch (Exception e) {
            Ui.printMessageWithHorizontalLines(UNKNOWN_ERROR_MESSAGE);
        }
    }


    private static void run() throws NumberFormatException, InvalidTaskNumberException,
            UnknownCommandException, InvalidCommandException, TaskDoneException, UnknownDateFormatException {
        Scanner scanner = new Scanner(System.in);
        Ui.greet();
        boolean running = true;
        while (running) {
            Command command = Parser.processInput(scanner.nextLine());
            CommandResult result = command.execute(tasks);
            Ui.printCommandResult(result);
            if (command instanceof ByeCommand) {
                running = false;
            }
        }
    }
}
