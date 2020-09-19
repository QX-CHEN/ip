package commands;

import data.TaskList;

public class ListCommand extends Command{
    public static final String COMMAND_WORD = "list";

    public void execute(TaskList tasks) {
        tasks.list();
    }
}
