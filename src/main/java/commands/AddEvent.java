package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import storage.Storage;
import tasks.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representation of command that adds a Event task to TaskList.
 */
public class AddEvent extends AddCommand {
    public static final String COMMAND_WORD = "event";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(.*\\S.*)/at(.*\\S.*)");

    private final String description;
    private final String datetime;

    /**
     * Creates a AddEvent Command with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     */
    public AddEvent(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            description = matcher.group(1).trim();
            datetime = matcher.group(2).trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by creating a Event task and add it to TaskList.
     *
     * @param tasks runtime storage of tasks.
     */
    public void execute(TaskList tasks) {
        Event event = new Event(description, datetime);
        tasks.add(event);
        Storage.updateFile(tasks);
        printAddMessage(tasks);
    }
}
