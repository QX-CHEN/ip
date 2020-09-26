package commands;

import data.TaskList;
import exceptions.InvalidCommandException;
import ui.Ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private static final Pattern COMMAND_PATTERN = Pattern.compile(COMMAND_WORD + "(?<keyword>.*\\s.*)");

    private final String keyword;

    public FindCommand(String trimmedInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(trimmedInput);
        if (matcher.find()) {
            keyword = matcher.group("keyword").trim();
        } else {
            throw new InvalidCommandException();
        }
    }

    public void execute(TaskList tasks) {
        Ui.printHorizontalLine();
        Ui.printMessageWithNewLine("\t Here are the matching tasks in your list:");
        int count = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(keyword)) {
                Ui.printMessageWithoutNewLine("\t " + count + ". ");
                Ui.printTask(tasks.get(i));
                count++;
            }
        }
        Ui.printHorizontalLine();
    }
}
