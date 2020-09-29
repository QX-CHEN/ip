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
    private LocalTime start;
    private LocalTime end;

    /**
     * Creates a Event task with description and time.
     *
     * @param description description of an event.
     * @param dateString date of an event.
     * @param startString start time of an event.
     * @param endString end time of an event.
     */
    public Event(String description, String dateString, String startString, String endString) {
        super(description);
        date = dateStringToDate(dateString);
        start = timeStringToTime(startString);
        end = timeStringToTime(endString);
    }

    /**
     * Creates a Event task with status, description and time.
     *
     * @param done status of an event.
     * @param description description of an event.
     * @param dateString date of an event.
     * @param startString start time of an event.
     * @param endString end time of an event.
     */
    public Event(boolean done, String description, String dateString, String startString, String endString) {
        super(done, description);
        date = dateStringToDate(dateString);
        start = timeStringToTime(startString);
        end = timeStringToTime(endString);
    }

    /**
     * Get date of an event.
     *
     * @return date of an event.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set date of an event.
     *
     * @param date date of an event.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get start time of an event.
     *
     * @return start time of an event.
     */
    public LocalTime getStartTime() {
        return start;
    }

    /**
     * Set start time of an event.
     *
     * @param start start time of an event.
     */
    public void setStartTime(LocalTime start) {
        this.start = start;
    }

    /**
     * Get end time of an event.
     *
     * @return end time of an event.
     */
    public LocalTime getEndTime() {
        return end;
    }

    /**
     * Set end time of an event.
     *
     * @param end  end time of an event.
     */
    public void setEndTime(LocalTime end) {
        this.end = end;
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
        return dateToString(getDate()) + "|" + timeToString(getStartTime()) + "|" + timeToString(getEndTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (at: " + dateToString(getDate()) +
                " " + timeToString(getStartTime()) + "-" + timeToString(getEndTime()) + ")";
    }
}
