package tasks;

import ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private static final String CODE = "D";
    private LocalDate date;
    private LocalTime time;

    public Deadline(String description, String dateString, String timeString) {
        super(description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

    public Deadline(boolean done, String description, String dateString, String timeString) {
        super(done, description);
        date = dateStringToDate(dateString);
        time = timeStringToTime(timeString);
    }

    private LocalDate dateStringToDate(String dateString) {
        if (dateString == null) {
            return null;
        }
        if (dateString.contains("/")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else if (dateString.contains("-")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            Ui.printMessageWithNewLine("Unknown date format!");
            return null;
        }
    }

    private LocalTime timeStringToTime(String timeString) {
        if (timeString == null) {
            return null;
        }
        int time = Integer.parseInt(timeString);
        int hour = time / 100;
        int minute = time % 100;
        return LocalTime.of(hour, minute);
    }

    private String dateToString(LocalDate date) {
        if (date == null) {
            return "";
        } else {
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    private String timeToString(LocalTime time) {
        if (time == null) {
            return "";
        } else {
            return time.format(DateTimeFormatter.ofPattern("HHmm"));
        }
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
                getDescription() + " (by: " + dateToString(getDate()) + " " + timeToString(getTime()) + ")";
    }
}
