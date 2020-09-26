package commands;

import data.TaskList;

import static common.Message.LIST_MESSAGE;

/**
 * Representation of command that list all the tasks.
 */
public class ListCommand extends Command{
    public static final String COMMAND_WORD = "list";

    /**
     * Executes the command by listing all the tasks.
     *
     * @param tasks runtime storage of tasks.
     */
    public CommandResult execute(TaskList tasks) {
        return new CommandResult(LIST_MESSAGE, tasks);
    }
}
