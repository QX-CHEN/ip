package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import storage.Storage;
import tasks.Todo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.Message.ADD_MESSAGE;

/**
 * Representation of command that adds a Todo task to TaskList.
 */
public class AddTodo extends AddCommand {
    public static final String COMMAND_WORD = "todo";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(.*\\S.*)");

    private final String description;

    /**
     * Creates a AddTodo Command with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     */
    public AddTodo(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            description = matcher.group(1).trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by creating a Todo task and add it to TaskList.
     *
     * @param tasks runtime storage of tasks.
     */
    public CommandResult execute(TaskList tasks) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        Storage.updateFile(tasks);
        return new CommandResult(ADD_MESSAGE, todo, tasks.size());
    }
}
