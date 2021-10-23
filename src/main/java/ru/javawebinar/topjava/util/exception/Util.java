package ru.javawebinar.topjava.util.exception;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Util {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static <T extends Comparable<T>>boolean isBetweenHalfOpen(T lt, T startTime, T endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) < 0;
    }

}
