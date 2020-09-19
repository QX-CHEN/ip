package data;

import common.Messages;
import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;

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

    public void addTask(String trimmedCommand) throws UnknownCommandException, InvalidCommandException {
        if (trimmedCommand.startsWith("todo")) {
            String todoInfo = trimmedCommand.replace("todo", "").trim();
            if (isEmptyDescription(todoInfo)) {
                throw new InvalidCommandException();
            }
            tasks.add(new Todo(todoInfo));
        } else if  (trimmedCommand.startsWith("deadline")) {
            String[] deadlineInfo = trimmedCommand.replace("deadline", "").split("/by");
            if (isEmptyDescription(deadlineInfo[0].trim()) || deadlineInfo.length != 2) {
                throw new InvalidCommandException();
            }
            String description = deadlineInfo[0].trim();
            String datetime = deadlineInfo[1].trim();
            tasks.add(new Deadline(description, datetime));
        } else if (trimmedCommand.startsWith("event")) {
            String[] eventInfo = trimmedCommand.replace("event", "").split("/at");
            if (isEmptyDescription(eventInfo[0].trim()) || eventInfo.length != 2) {
                throw new InvalidCommandException();
            }
            String description = eventInfo[0].trim();
            String datetime = eventInfo[1].trim();
            tasks.add(new Event(description, datetime));
        } else {
            throw new UnknownCommandException();
        }

        Messages.printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks.get(tasks.size() - 1));
        System.out.println("\t Now you have " + tasks.size() + " task(s) in the list.");
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

    private boolean isEmptyDescription(String description) {
        return ("".equals(description));
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
