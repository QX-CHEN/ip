package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import tasks.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEvent extends AddCommand {
    public static final String COMMAND_WORD = "event";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(.*\\S.*)/at(.*\\S.*)");

    private final String description;
    private final String datetime;

    public AddEvent(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            description = matcher.group(1).trim();
            datetime = matcher.group(2).trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    public void execute(TaskList tasks) {
        Event event = new Event(description, datetime);
        tasks.add(event);
        printAddMessage(tasks);
    }
}
