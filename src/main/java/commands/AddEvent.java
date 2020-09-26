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

    // pattern: event description /at dd/mm/yyyy HHmm
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + " (?<description>(\\w+\\s*)+\\w*)" +
            " /at (?<date>\\d{2}/\\d{2}/\\d{4}) (?<time>\\d{4})");
    private final String description;
    private final String date;
    private final String time;

    /**
     * Creates a AddEvent Command with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     * @throws InvalidCommandException if the trimmed input format does not match with the pattern.
     */
    public AddEvent(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            description = matcher.group("description");
            date = matcher.group("date");
            time = matcher.group("time");
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
        Event event = new Event(description, date, time);
        tasks.add(event);
        Storage.updateFile(tasks);
        printAddMessage(tasks);
    }
}
