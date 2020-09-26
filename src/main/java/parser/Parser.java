package parser;

import commands.*;
import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;

/**
 * Parser class handles raw input.
 */
public class Parser {

    /**
     * This method creates and returns a command based on the raw input.
     *
     * @param rawInput message to be printed in between the lines.
     * @return a Command based on the raw input.
     * @throws InvalidCommandException if the trimmed input format does not match with the command pattern.
     * @throws UnknownCommandException if the raw input does not start with one the command words.
     */
    public static Command processInput(String rawInput) throws InvalidCommandException, UnknownCommandException {
        String trimmedInput = rawInput.trim();
        if (trimmedInput.startsWith(TodoCommand.COMMAND_WORD)) {
            return new TodoCommand(trimmedInput);
        } else if (trimmedInput.startsWith(EventCommand.COMMAND_WORD)) {
            return new EventCommand(trimmedInput);
        } else if (trimmedInput.startsWith(DeadlineCommand.COMMAND_WORD)) {
            return new DeadlineCommand(trimmedInput);
        } else if (trimmedInput.startsWith(DoneCommand.COMMAND_WORD)) {
            return new DoneCommand(trimmedInput);
        } else if (trimmedInput.startsWith(DeleteCommand.COMMAND_WORD)) {
            return new DeleteCommand(trimmedInput);
        } else if (trimmedInput.startsWith(FindCommand.COMMAND_WORD)) {
            return new FindCommand(trimmedInput);
        } else if (trimmedInput.startsWith(ListCommand.COMMAND_WORD)) {
            return new ListCommand();
        } else if (trimmedInput.startsWith(ByeCommand.COMMAND_WORD)) {
            return new ByeCommand();
        } else {
            throw new UnknownCommandException();
        }
    }
}
