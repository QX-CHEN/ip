package commands;

import data.TaskList;
import tasks.Task;

/**
 * CommandResult represents a result after command execution.
 * it is pass to Ui class for printing.
 */
public class CommandResult {
    private final String message;
    private TaskList tasks = null;
    private Task task = null;
    private int numOfTasks = -1;

    /**
     * Creates a CommandResult with message, task and number of tasks.
     *
     * @param message to be displayed.
     * @param task that the command operated on, created or deleted.
     * @param numOfTasks task count after operation.
     */
    public CommandResult(String message, Task task, int numOfTasks) {
        this.message = message;
        this.task = task;
        this.numOfTasks = numOfTasks;
    }

    /**
     * Creates a CommandResult with message and task.
     *
     * @param message to be displayed.
     * @param task that the command operated on, created or deleted.
     */
    public CommandResult(String message, Task task) {
        this.message = message;
        this.task = task;
    }

    /**
     * Creates a CommandResult with message and tasks.
     *
     * @param message to be displayed.
     * @param tasks to be displayed.
     */
    public CommandResult(String message, TaskList tasks) {
        this.message = message;
        this.tasks = tasks;
    }

    /**
     * Creates a CommandResult with message.
     *
     * @param message to be displayed.
     */
    public CommandResult(String message) {
        this.message = message;
    }

    /**
     * Get the message from CommandResult.
     *
     * @return message string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the tasks from CommandResult.
     *
     * @return a TaskList of tasks.
     */
    public TaskList getTasks() {
        return tasks;
    }

    /**
     * Get the task from CommandResult.
     *
     * @return a task.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Get the task count from CommandResult.
     *
     * @return number of tasks.
     */
    public int getNumOfTasks() {
        return numOfTasks;
    }
}
