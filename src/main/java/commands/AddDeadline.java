package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import storage.Storage;
import tasks.Deadline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representation of command that adds a Deadline task to TaskList.
 */
public class AddDeadline extends AddCommand{
    public static final String COMMAND_WORD = "deadline";

    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(.*\\S.*)/by(.*\\S.*)");
    private final String description;
    private final String datetime;

    /**
     * Creates a AddDeadline Command with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     */
    public AddDeadline(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            description = matcher.group(1).trim();
            datetime = matcher.group(2).trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by creating a Deadline task and add it to TaskList.
     *
     * @param tasks runtime storage of tasks.
     */
    public void execute(TaskList tasks) {
        Deadline deadline = new Deadline(description, datetime);
        tasks.add(deadline);
        Storage.updateFile(tasks);
        printAddMessage(tasks);
    }
}
