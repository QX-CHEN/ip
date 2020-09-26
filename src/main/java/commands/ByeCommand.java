package commands;

import data.TaskList;
import ui.Ui;

/**
 * Representation of command that stops the program.
 */
public class ByeCommand extends Command{
    public static final String COMMAND_WORD = "bye";

    /**
     * Executes the command by printing a bye message.
     *
     * @param tasks runtime storage of tasks.
     */
    public void execute(TaskList tasks) {
        Ui.bye();
    }
}
