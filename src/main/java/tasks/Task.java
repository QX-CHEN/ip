package tasks;

/**
 * Representation of a generic task object.
 */
public abstract class Task {
    private static final String TICK_ICON = "[\u2714]";
    private static final String CROSS_ICON = "[\u2716]";
    private String description;
    private boolean isDone;

    /**
     * Creates a Task instance with description only.
     *
     * @param description description of a task.
     */
    public Task(String description) {
        setDescription(description);
        setDone(false);
    }

    /**
     * Creates a Task instance with description and its status.
     *
     * @param done status of a task.
     * @param description description of a task.
     */
    public Task(boolean done, String description) {
        setDescription(description);
        setDone(done);
    }

    /**
     * Get description of a task.
     *
     * @return description of a task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of a task.
     *
     * @param description description of a task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get status of a task.
     *
     * @return status of a task.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Set status of a task.
     *
     * @param done status of a task.
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Get status icon of a task.
     *
     * @return status icon of a task.
     */
    public String getStatusIcon() {
        return isDone() ? TICK_ICON : CROSS_ICON;
    }

    /**
     * Get code of a task.
     *
     * @return code of a task.
     */
    public abstract String getCode();

    /**
     * Get datetime of a task.
     *
     * @return datetime of a task.
     */
    public abstract String getDatetime();

    /**
     * Get string representation of a task.
     *
     * @return string representation of a task.
     */
    @Override
    public abstract String toString();

}
