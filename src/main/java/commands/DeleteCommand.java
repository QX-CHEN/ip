package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.InvalidTaskNumberException;
import storage.Storage;
import tasks.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.Message.DELETE_MESSAGE;

/**
 * Representation of command that deletes a task from TaskList.
 */
public class DeleteCommand extends Command{
    public static final String COMMAND_WORD = "delete";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + " (?<taskNum>\\d+)");

    private static int taskNum;

    /**
     * Creates a DeleteCommand with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     */
    public DeleteCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            taskNum = Integer.parseInt(matcher.group("taskNum"));
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by deleting task of given index.
     *
     * @param tasks runtime storage of tasks.
     */
    public CommandResult execute(TaskList tasks) throws InvalidTaskNumberException {
        Task task = tasks.deleteTask(taskNum);
        Storage.updateFile(tasks);
        return new CommandResult(DELETE_MESSAGE, task, tasks.size());
    }
}
