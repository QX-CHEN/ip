package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import storage.Storage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representation of command that marks a task in TaskList as done.
 */
public class DoneCommand extends Command{
    public static final String COMMAND_WORD = "done";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "\\s*(\\d*)\\s*");
    private static int taskNum;

    /**
     * Creates a DoneCommand with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     */
    public DoneCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            taskNum = Integer.parseInt(matcher.group(1));
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by marking task of given index as done.
     *
     * @param tasks runtime storage of tasks.
     */
    public void execute(TaskList tasks) {
        tasks.markAsDone(taskNum);
        Storage.updateFile(tasks);
    }
}
