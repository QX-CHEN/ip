package commands;

import common.Messages;
import data.TaskList;

public abstract class AddCommand extends Command {

    protected void printAddMessage(TaskList tasks) {
        Messages.printHorizontalLine();
        System.out.println("\t Got it. I've added: this task:");
        System.out.println("\t   " + tasks.get(tasks.size() - 1));
        System.out.println("\t Now you have " + tasks.size() + " task(s) in the list.");
        Messages.printHorizontalLine();
    }
}
