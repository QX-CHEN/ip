package exceptions;

/**
 * UnknownCommandException is thrown when input
 * does not start with available command words.
 */
public class UnknownCommandException extends Exception {
    /**
     * String representation for printing.
     *
     * @return string representation for printing.
     */
    @Override
    public String toString() {
        return "\tCheck command word!";
    }
}
