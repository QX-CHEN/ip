package data;

import common.Messages;
import tasks.Task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void list() {
        Messages.printHorizontalLine();
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print("\t " + (i + 1) + ". ");
            System.out.println(tasks.get(i));
        }
        Messages.printHorizontalLine();
    }

    public void deleteTask(int taskNum) {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            System.out.println("\tInvalid task number!");
            return;
        }

        Messages.printHorizontalLine();
        System.out.println("\t Noted. I've removed this task:");
        System.out.println("\t   " + tasks.remove(taskNum - 1));
        System.out.println("\t Now you have " + tasks.size() + " task(s) in the list.");
        Messages.printHorizontalLine();
    }

    public void markAsDone(int taskNum) {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            System.out.println("\tInvalid task number!");
            return;
        } else if (tasks.get(taskNum - 1).isDone()) {
            System.out.println("\tTask already done!");
            return;
        }
        tasks.get(taskNum - 1).setDone(true);
        Messages.printHorizontalLine();
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t   " + tasks.get(taskNum - 1));
        Messages.printHorizontalLine();
    }

}
