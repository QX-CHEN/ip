package commands;

import data.TaskList;
import storage.Storage;

public abstract class Command {
    public abstract void execute(TaskList tasks);

    protected void updateFile(TaskList tasks) {
        Storage.updateFile(tasks);
    }
}
