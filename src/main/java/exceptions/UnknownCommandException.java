package exceptions;

public class UnknownCommandException extends Exception {
    @Override
    public String toString() {
        return "\tCheck command word!";
    }
}
