package commands;

import data.TaskList;
import exceptions.InvalidTaskNumberException;
import exceptions.TaskDoneException;

/**
 * Representation of generic command.
 */
public abstract class Command {
    /**
     * Execute the command.
     * @throws InvalidTaskNumberException task number out of range.
     * @throws TaskDoneException done command given to a task that is already done.
     */
    public abstract CommandResult execute(TaskList tasks) throws InvalidTaskNumberException, TaskDoneException;
}
