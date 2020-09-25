package tasks;

/**
 * Representation of a type of task with description only.
 */
public class Todo extends Task {
    private static final String CODE = "T";

    /**
     * Creates a Todo task with description only.
     *
     * @param description description of a task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Creates a Todo task with description and status.
     *
     * @param done status of a task.
     * @param description description of a task.
     */
    public Todo(boolean done, String description) {
        super(done, description);
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
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription();
    }
}
