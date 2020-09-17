package tasks;

public class Todo extends Task {
    private static final String CODE = "T";

    public Todo(String description) {
        super(description);
    }

    public Todo(boolean done, String description) {
        super(done, description);
    }

    @Override
    public String getCode() {
        return CODE;
    }

//    @Override
//    public String getDatetime() {
//        return "";
//    }

    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription();
    }
}
