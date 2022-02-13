package utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

    public static final String CUSTOM_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static LocalDate strToDate(String strDate) {
        return LocalDate.parse(strDate, DateTimeFormatter.ISO_DATE);    // ISO_DATE = "yyyy-MM-dd"
    }

    public static String dateToStr(LocalDate date) {
        DateTimeFormatter javaFormatter = DateTimeFormatter.ISO_DATE;
        return javaFormatter.format(date);
    }

    public static LocalDateTime strToLocalDateTime(String dateStr) {
        DateTimeFormatter javaFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(dateStr, javaFormatter);
    }

    public static String localDateTimeToStr(LocalDateTime dateTime) {
        DateTimeFormatter javaFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return javaFormatter.format(dateTime);
    }

    public static LocalDateTime mysqlStrToLocalDateTime(String dateStr) {
        DateTimeFormatter javaFormatter = DateTimeFormatter.ofPattern(CUSTOM_DATETIME_FORMAT);
        return LocalDateTime.parse(dateStr, javaFormatter);
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        String startTimeStr = "2021-06-11T00:00:00";
        String endTimeStr = "2021-06-13T23:59:00";

        LocalDateTime startTime = LocalDateTime.parse(startTimeStr).with(LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr).with(LocalTime.MIN);

        System.out.println(String.valueOf(startTime));
        System.out.println(String.valueOf(endTime));

        System.out.println(ChronoUnit.HOURS.between(startTime, endTime));
        System.out.println(ChronoUnit.DAYS.between(startTime, endTime));

        System.out.println(Duration.between(startTime, endTime).toHours());
        System.out.println(Duration.between(startTime, endTime).toDays());

        System.out.println(formatter.format(startTime.plusDays(2)));
        System.out.println(formatter.format(startTime));
        System.out.println(formatter.format(endTime));
    }
}
