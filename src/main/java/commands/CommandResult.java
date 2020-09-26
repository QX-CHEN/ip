package commands;

import data.TaskList;
import tasks.Task;

public class CommandResult {
    private final String message;
    private TaskList tasks = null;
    private Task task = null;
    private int numOfTasks = -1;

    public CommandResult(String message, Task task, int numOfTasks) {
        this.message = message;
        this.task = task;
        this.numOfTasks = numOfTasks;
    }

    public CommandResult(String message, Task task) {
        this.message = message;
        this.task = task;
    }

    public CommandResult(String message, TaskList tasks) {
        this.message = message;
        this.tasks = tasks;
    }

    public CommandResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public TaskList getTasks() {
        return tasks;
    }

    public Task getTask() {
        return task;
    }

    public int getNumOfTasks() {
        return numOfTasks;
    }
}
