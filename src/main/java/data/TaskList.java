package data;

import tasks.Task;
import ui.Ui;

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
        Ui.printHorizontalLine();
        Ui.printMessageWithNewLine("\t Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            Ui.printMessageWithoutNewLine("\t " + (i + 1) + ". ");
            Ui.printTask(tasks.get(i));
        }
        Ui.printHorizontalLine();
    }

    public void deleteTask(int taskNum) {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            Ui.printMessageWithNewLine("\tInvalid task number!");
            return;
        }

        Ui.printHorizontalLine();
        Ui.printMessageWithNewLine("\t Noted. I've removed this task:");
        Ui.printMessageWithNewLine("\t   " + tasks.remove(taskNum - 1));
        Ui.printMessageWithNewLine("\t Now you have " + tasks.size() + " task(s) in the list.");
        Ui.printHorizontalLine();
    }

    public void markAsDone(int taskNum) {
        if (taskNum <= 0 || taskNum > tasks.size()) {
            Ui.printMessageWithNewLine("\tInvalid task number!");
            return;
        } else if (tasks.get(taskNum - 1).isDone()) {
            Ui.printMessageWithNewLine("\tTask already done!");
            return;
        }
        tasks.get(taskNum - 1).setDone(true);
        Ui.printHorizontalLine();
        Ui.printMessageWithNewLine("\t Nice! I've marked this task as done:");
        Ui.printMessageWithNewLine("\t   " + tasks.get(taskNum - 1));
        Ui.printHorizontalLine();
    }

}
