package tasks;

import java.time.LocalDate;
import java.time.LocalTime;

import static common.Utils.*;

/**
 * Representation of a type of task with description and deadline.
 */
public class Deadline extends Task {
    private static final String CODE = "D";
    private LocalDate date;
    private LocalTime time;

    /**
     * Creates a Deadline task with description and deadline.
     *
     * @param description description of a task.
     * @param dateString date of a deadline.
     * @param timeString time of a deadline.
     */
    public Deadline(String description, String dateString, String timeString) {
        super(description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

    /**
     * Creates a Deadline task with status, description and deadline.
     *
     * @param done status of a task.
     * @param description description of a deadline.
     * @param dateString date of a deadline.
     * @param timeString time of a deadline.
     */
    public Deadline(boolean done, String description, String dateString, String timeString) {
        super(done, description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

    /**
     * Get date of a deadline.
     *
     * @return date of a deadline.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set date of a deadline.
     *
     * @param date of a deadline.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get time of a deadline.
     *
     * @return time of a deadline.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Set time of a deadline.
     *
     * @param time of a deadline.
     */
    public void setTime(LocalTime time) {
        this.time = time;
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
        return dateToString(getDate()) + "|" + timeToString(getTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (by: " + dateToString(getDate()) + " " + timeToString(getTime()) + ")";
    }
}
