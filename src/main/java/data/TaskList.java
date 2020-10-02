package data;

import exceptions.InvalidTaskNumberException;
import exceptions.TaskDoneException;
import tasks.Task;

import java.util.ArrayList;

/**
 * Storage of tasks during runtime and its operations.
 */
public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Add a task to TaskList.
     *
     * @param task new task.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Get current size of TaskList
     *
     * @return size of TaskList.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Get task from TaskList using index.
     *
     * @return task of given index in the TaskList.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Remove task from TaskList using index.
     *
     * @return task that is removed from the TaskList.
     * @throws InvalidTaskNumberException if the task number is out of range.
     */
    public Task deleteTask(int taskNum) throws InvalidTaskNumberException {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            throw new InvalidTaskNumberException();
        }
        return tasks.remove(taskNum - 1);
    }

    /**
     * Mark task as done using index.
     *
     * @return task that is marked as done.
     * @throws InvalidTaskNumberException if the task number is out of range.
     * @throws TaskDoneException if the task is already done.
     */
    public Task markAsDone(int taskNum) throws InvalidTaskNumberException, TaskDoneException {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            throw new InvalidTaskNumberException();
        } else if (tasks.get(taskNum - 1).isDone()) {
            throw new TaskDoneException();
        }
        tasks.get(taskNum - 1).setDone(true);
        return tasks.get(taskNum - 1);
    }

}
