package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import tasks.Todo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddTodo extends AddCommand {
    public static final String COMMAND_WORD = "todo";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(.*\\S.*)");

    private final String description;

    public AddTodo(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            description = matcher.group(1).trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    public void execute(TaskList tasks) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        printAddMessage(tasks);
    }
}
