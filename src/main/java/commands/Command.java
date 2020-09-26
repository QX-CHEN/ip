package commands;

import data.TaskList;

/**
 * Representation of generic command.
 */
public abstract class Command {
    /**
     * Execute the command.
     */
    public abstract void execute(TaskList tasks);
}
