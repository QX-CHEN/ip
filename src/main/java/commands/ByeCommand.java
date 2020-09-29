package commands;

import data.TaskList;

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
     * @return CommandResult that pass printing info to Ui class.
     */
    public CommandResult execute(TaskList tasks) {
        return new CommandResult(BYE_MESSAGE);
    }
}
