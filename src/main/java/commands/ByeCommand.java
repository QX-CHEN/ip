package commands;

import data.TaskList;
import ui.Ui;

import static common.Message.BYE_MESSAGE;

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
    public CommandResult execute(TaskList tasks) {
        return new CommandResult(BYE_MESSAGE);
    }
}
