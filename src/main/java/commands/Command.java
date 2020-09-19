package commands;

import data.TaskList;

public abstract class Command {
    public abstract void execute(TaskList tasks);
}
