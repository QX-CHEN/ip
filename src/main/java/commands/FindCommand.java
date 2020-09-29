package commands;

import data.TaskList;
import exceptions.InvalidCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.Message.FIND_MESSAGE;

/**
 * Representation of command that finds relevant task(s) from TaskList.
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(?<keyword>.*\\s.*)");

    private final String keyword;

    /**
     * Creates a FindCommand with trimmed input.
     *
     * @param trimmedInput raw input without leading and trailing white space.
     * @throws InvalidCommandException if the trimmed input format does not match with the pattern.
     */
    public FindCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            keyword = matcher.group("keyword").trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    /**
     * Executes the command by searching all tasks in TaskList with given keyword.
     *
     * @param tasks runtime storage of tasks.
     * @return CommandResult that pass printing info to Ui class.
     */
    public CommandResult execute(TaskList tasks) {
        TaskList filteredTasks = new TaskList();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(keyword)) {
                filteredTasks.add(tasks.get(i));
            }
        }
        return new CommandResult(FIND_MESSAGE, tasks);
    }
}
