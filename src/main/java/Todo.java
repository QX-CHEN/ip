public class Todo extends Task {
    private static final String CODE = "[T]";

    public Todo(String description) {
        super(description);
    }

    @Override
    public String getCode() {
        return CODE;
    }
}
