package tasks;

/**
 * Representation of a type of task with description and time.
 */
public class Event extends Task {
    private static final String CODE = "E";
    private String at;

    /**
     * Creates a Event task with description and time.
     *
     * @param description description of a task.
     * @param at timing of a task.
     */
    public Event(String description, String at) {
        super(description);
        setAt(at);
    }

    /**
     * Creates a Event task with status, description and time.
     *
     * @param done status of a task.
     * @param description description of a task.
     * @param at timing of a task.
     */
    public Event(boolean done, String description, String at) {
        super(done, description);
        setAt(at);
    }

    /**
     * Get timing of a task.
     *
     * @return timing of a task.
     */
    public String getAt() {
        return at;
    }

    /**
     * Set timing of a task.
     *
     * @param at timing of a task.
     */
    public void setAt(String at) {
        this.at = at;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode() {
        return CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDatetime() {
        return getAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (at: " + getDatetime() + ")";
    }
}
