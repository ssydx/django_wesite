package com.springboot.myblog.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommonUtil {
    private static final DateTimeFormatter formatter;
    private static final Map<Long, String> map;
    public static String format(LocalDateTime ldt) {
        return ldt.format(formatter);
    }
    public static String toSlug(String title) {
        return String.join(
            "-", 
            title.toLowerCase()
                .replace("\n", " ")
                .replace("[^a-z\\d\\s]", " ")
                .split(" ")
        ).replace("-+", "-");
    }
    private static String getDayOfMonthSuffix(int n) {
        switch (n % 10) {
            case 1:
                return n + "st";
            case 2:
                return n + "nd";
            case 3:
                return n + "rd";
            default:
            return n + "th";
        }
    }
    private static Map<Long, String> buildMap() {
        Map<Long, String> ret = new HashMap<>();
        for (int i = 1; i <= 31; i++) {
            ret.put((long)i, getDayOfMonthSuffix(i));
        }
        return ret;
    }
    static {
        map = buildMap();
        formatter = new DateTimeFormatterBuilder()
                        .appendPattern("yyyy-MM-dd")
                        .appendLiteral(" ")
                        .appendText(ChronoField.DAY_OF_MONTH, map)
                        .appendLiteral(" ")
                        .appendPattern("yyyy")
                        .toFormatter(Locale.ENGLISH);
    }


}
