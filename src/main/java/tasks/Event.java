package tasks;

import java.time.LocalDate;
import java.time.LocalTime;

import static common.Utils.*;

/**
 * Representation of a type of task with description and time.
 */
public class Event extends Task {
    private static final String CODE = "E";
    private LocalDate date;
    private LocalTime time;

    /**
     * Creates a Event task with description and time.
     *
     * @param description description of a event.
     * @param dateString date of a event.
     * @param timeString time of a event.
     */
    public Event(String description, String dateString, String timeString) {
        super(description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

    /**
     * Creates a Event task with status, description and time.
     *
     * @param done status of a task.
     * @param description description of a task.
     * @param dateString date of a event.
     * @param timeString time of a event.
     */
    public Event(boolean done, String description, String dateString, String timeString) {
        super(done, description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

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
                getDescription() + " (at: " + dateToString(getDate()) + " " + timeToString(getTime()) + ")";
    }
}
