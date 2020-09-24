package commands;

import data.TaskList;
import ui.Ui;

public abstract class AddCommand extends Command {

    protected void printAddMessage(TaskList tasks) {
        Ui.printAddMessage(tasks);
    }
}
