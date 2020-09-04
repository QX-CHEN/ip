public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        setDescription(description);
        setDone(false);
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
        return isDone() ? "[\u2714]" : "[\u2716]";
    }

    public String getCode() {
        return "";
    }

    public String getDatetime() {
        return "";
    }

    @Override
    public String toString() {
        return getCode() + getStatusIcon() + " " +
                getDescription() + " " + getDatetime();
    }

}
