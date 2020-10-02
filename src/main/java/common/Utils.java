package common;

import ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Utils class contains utility functions used by the program.
 */
public class Utils {

    /**
     * Convert a date from String to LocalDate.
     *
     * @param dateString String representation of a date.
     * @return LocalDate that converts from dateString.
     */
    public static LocalDate dateStringToDate(String dateString) {
        if (dateString == null) {
            return null;
        }
        if (dateString.contains("/")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else if (dateString.contains("-")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            Ui.printMessageWithHorizontalLines("Unknown date format!");
            return null;
        }
    }
    
    /**
     * Convert a time from String to LocalDate.
     *
     * @param timeString String representation of a time.
     * @return LocalTime that converts from timeString.
     */
    public static LocalTime timeStringToTime(String timeString) {
        if (timeString == null) {
            return null;
        }
        int time = Integer.parseInt(timeString);
        int hour = time / 100;
        int minute = time % 100;
        return LocalTime.of(hour, minute);
    }

    /**
     * Convert a date from LocalDate to String.
     *
     * @param date LocalDate object.
     * @return Formatted String that converts from LocalDate.
     */
    public static String dateToString(LocalDate date) {
        if (date == null) {
            return "";
        } else {
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    /**
     * Convert a time from LocalTime to String.
     *
     * @param time LocalTime object.
     * @return Formatted String that converts from LocalTime.
     */
    public static String timeToString(LocalTime time) {
        if (time == null) {
            return "";
        } else {
            return time.format(DateTimeFormatter.ofPattern("HHmm"));
        }
    }
}
