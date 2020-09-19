package commands;

import data.TaskList;
import exceptions.InvalidCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteCommand extends Command{
    public static final String COMMAND_WORD = "delete";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "\\s*(\\d*)\\s*");

    private static int taskNum;

    public DeleteCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            taskNum = Integer.parseInt(matcher.group(1));
        } else {
            throw new InvalidCommandException();
        }
    }

    public void execute(TaskList tasks) {
        tasks.deleteTask(taskNum);
    }
}
