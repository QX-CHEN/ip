package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import storage.Storage;
import tasks.Deadline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.Message.ADD_MESSAGE;

/**
 * Representation of command that adds a Deadline task to TaskList.
 */
public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";

    // pattern: deadline description /by dd/mm/yyyy HHmm
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + " (?<description>(\\w+\\s*)+\\w*)" +
            " /by (?<date>\\d{2}/\\d{2}/\\d{4}) (?<time>\\d{4})");
    private final String description;
    private final String date;
    private final String time;

    /**
     * Creates a DeadlineCommand with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     * @throws InvalidCommandException if the trimmed input format does not match with the pattern.
     */
    public DeadlineCommand(String trimmedInput) throws InvalidCommandException {
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
     * Executes the command by creating a Deadline task and add it to TaskList.
     *
     * @param tasks runtime storage of tasks.
     * @return CommandResult that pass printing info to Ui class.
     */
    public CommandResult execute(TaskList tasks) {
        Deadline deadline = new Deadline(description, date, time);
        tasks.add(deadline);
        Storage.updateFile(tasks);
        return new CommandResult(ADD_MESSAGE, deadline, tasks.size());
    }
}
