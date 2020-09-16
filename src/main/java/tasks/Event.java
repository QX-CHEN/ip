package tasks;

public class Event extends Task {
    private static final String CODE = "E";
    private String at;

    public Event(String description, String at) {
        super(description);
        setAt(at);
    }

    public Event(boolean done, String description, String at) {
        super(done, description);
        setAt(at);
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public String getDatetime() {
        return getAt();
    }

    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (at: " + getDatetime() + ")";
    }
}
