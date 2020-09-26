package tasks;

import java.time.LocalDate;
import java.time.LocalTime;

import static common.Utils.*;

public class Event extends Task {
    private static final String CODE = "E";
    private LocalDate date;
    private LocalTime time;

    public Event(String description, String dateString, String timeString) {
        super(description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

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

    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public String getDatetime() {
        return dateToString(getDate()) + "|" + timeToString(getTime());
    }

    @Override
    public String toString() {
        return "[" + getCode() + "]" + getStatusIcon() + " " +
                getDescription() + " (at: " + dateToString(getDate()) + " " + timeToString(getTime()) + ")";
    }
}
