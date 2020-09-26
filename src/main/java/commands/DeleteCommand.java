package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import storage.Storage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representation of command that deletes a task from TaskList.
 */
public class DeleteCommand extends Command{
    public static final String COMMAND_WORD = "delete";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "\\s*(\\d*)\\s*");

    private static int taskNum;

    /**
     * Creates a DeleteCommand with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     */
    public DeleteCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            taskNum = Integer.parseInt(matcher.group(1));
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by deleting task of given index.
     *
     * @param tasks runtime storage of tasks.
     */
    public void execute(TaskList tasks) {
        tasks.deleteTask(taskNum);
        Storage.updateFile(tasks);
    }
}
