package exceptions;
/**
 * InvalidCommandException is thrown when input format
 * does not match with available commands.
 */
public class InvalidCommandException extends Exception {
    /**
     * String representation for printing.
     *
     * @return string representation for printing.
     */
    @Override
    public String toString() {
        return "\tCheck command format!";
    }
}
