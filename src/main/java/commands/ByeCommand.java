package commands;

import common.Messages;
import data.TaskList;

public class ByeCommand extends Command{
    public static final String COMMAND_WORD = "bye";

    public void execute(TaskList tasks) {
        Messages.bye();
    }
}
