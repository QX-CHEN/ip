package exceptions;

public class InvalidCommandException extends Exception {
    @Override
    public String toString() {
        return "\tCheck command format!";
    }
}
