package common;

import ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static LocalDate dateStringToDate(String dateString) {
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

    public static LocalTime timeStringToTime(String timeString) {
        if (timeString == null) {
            return null;
        }
        int time = Integer.parseInt(timeString);
        int hour = time / 100;
        int minute = time % 100;
        return LocalTime.of(hour, minute);
    }

    public static String dateToString(LocalDate date) {
        if (date == null) {
            return "";
        } else {
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    public static String timeToString(LocalTime time) {
        if (time == null) {
            return "";
        } else {
            return time.format(DateTimeFormatter.ofPattern("HHmm"));
        }
    }
}
