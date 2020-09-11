package task;

public class Deadline extends Task {
    private static final String CODE = "D";
    private String by;

    public Deadline(String description, String by) {
        super(description);
        setBy(by);
    }

    public Deadline(boolean done, String description, String by) {
        super(done, description);
        setBy(by);
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public String getDatetime() {
        return getBy();
    }

    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (by: " + getDatetime() + ")";
    }
}
