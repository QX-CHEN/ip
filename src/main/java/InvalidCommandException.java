public class InvalidCommandException extends Exception {
    @Override
    public String toString() {
        return "Check command format!";
    }
}
