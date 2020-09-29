package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import exceptions.InvalidTaskNumberException;
import exceptions.TaskDoneException;
import storage.Storage;
import tasks.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.Message.MARK_AS_DONE_MESSAGE;

/**
 * Representation of command that marks a task in TaskList as done.
 */
public class DoneCommand extends Command{
    public static final String COMMAND_WORD = "done";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + " (?<taskNum>\\d+)");
    private static int taskNum;

    /**
     * Creates a DoneCommand with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     * @throws InvalidCommandException input format does not match with the command word.
     */
    public DoneCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            taskNum = Integer.parseInt(matcher.group("taskNum"));
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by marking task of given index as done.
     *
     * @param tasks runtime storage of tasks.
     * @return CommandResult that pass printing info to Ui class.
     * @throws InvalidTaskNumberException task number out of range.
     */
    public CommandResult execute(TaskList tasks) throws InvalidTaskNumberException, TaskDoneException {
        Task task = tasks.markAsDone(taskNum);
        Storage.updateFile(tasks);
        return new CommandResult(MARK_AS_DONE_MESSAGE, task);
    }
}
