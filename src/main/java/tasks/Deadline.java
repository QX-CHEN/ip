package tasks;

/**
 * Representation of a type of task with description and deadline.
 */
public class Deadline extends Task {
    private static final String CODE = "D";
    private String by;

    /**
     * Creates a Deadline task with description and deadline.
     *
     * @param description description of a task.
     * @param by deadline of a task.
     */
    public Deadline(String description, String by) {
        super(description);
        setBy(by);
    }

    /**
     * Creates a Deadline task with status, description and deadline.
     *
     * @param done status of a task.
     * @param description description of a task.
     * @param by deadline of a task.
     */
    public Deadline(boolean done, String description, String by) {
        super(done, description);
        setBy(by);
    }

    /**
     * Get deadline of a task.
     *
     * @return deadline of a task.
     */
    public String getBy() {
        return by;
    }

    /**
     * Set deadline of a task.
     *
     * @param by deadline of a task.
     */
    public void setBy(String by) {
        this.by = by;
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
        return getBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (by: " + getDatetime() + ")";
    }
}
