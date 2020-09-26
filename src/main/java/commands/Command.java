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
     */
    public abstract CommandResult execute(TaskList tasks) throws InvalidTaskNumberException, TaskDoneException;
}
