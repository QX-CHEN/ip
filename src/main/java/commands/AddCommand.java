package commands;

import data.TaskList;
import ui.Ui;

/**
 * Representation of add command that adds a task to TaskList.
 */
public abstract class AddCommand extends Command {
    /**
     * Print add message.
     */
    protected void printAddMessage(TaskList tasks) {
        Ui.printAddMessage(tasks);
    }
}
