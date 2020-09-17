package tasks;

public abstract class Task {
    private static final String TICK_ICON = "[\u2714]";
    private static final String CROSS_ICON = "[\u2716]";
    private String description;
    private boolean isDone;

    public Task(String description) {
        setDescription(description);
        setDone(false);
    }

    public Task(boolean done, String description) {
        setDescription(description);
        setDone(done);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getStatusIcon() {
        return isDone() ? TICK_ICON : CROSS_ICON;
    }

    public abstract String getCode();

    public String getDatetime() {
        return "";
    }

    @Override
    public abstract String toString();

}
