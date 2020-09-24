package commands;

import data.TaskList;
import ui.Ui;

public class ByeCommand extends Command{
    public static final String COMMAND_WORD = "bye";

    public void execute(TaskList tasks) {
        Ui.bye();
    }
}
