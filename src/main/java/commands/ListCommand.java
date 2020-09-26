package commands;

import data.TaskList;

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
    public void execute(TaskList tasks) {
        tasks.list();
    }
}
