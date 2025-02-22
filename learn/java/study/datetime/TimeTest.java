package study.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;


class LocalDateTest {
    public static final void run() {
        // 不可变对象
        LocalDate ld1 = LocalDate.now();
        System.out.println(ld1);
        LocalDate ld2 = LocalDate.of(2024, 12, 12);
        System.out.println(ld2);
        LocalDate ld3 = LocalDate.parse("2023-08-30"); // 必须是该格式
        System.out.println(ld3);
        LocalDate ld4 = LocalDate.ofEpochDay(1223433); // 纪元天数
        System.out.println(ld4);
        // 获取
        System.out.println(ld1.getLong(ChronoField.MONTH_OF_YEAR));
        System.out.println(ld1.getYear());
        System.out.println(ld1.getMonthValue());
        System.out.println(ld1.getMonth());
        System.out.println(ld1.getDayOfMonth());
        System.out.println(ld1.getDayOfWeek());
        System.out.println(ld1.getDayOfYear());
        // 判定
        System.out.println(ld2.isLeapYear());
        System.out.println(ld1.isAfter(ld2));
        System.out.println(ld1.isBefore(ld2));
        // 相等比较
        System.out.println(ld1.isEqual(ld2));
        System.out.println(ld1.equals(ld2));
        System.out.println(ld1.compareTo(ld2));
        // 格式化
        System.out.println(ld1.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        // 修改，返回新值
        System.out.println(ld1.withYear(2021));
        System.out.println(ld1.with(ChronoField.MONTH_OF_YEAR, 11));
        System.out.println(ld1.with(TemporalAdjusters.firstDayOfNextMonth())); // 有很多实用函数
        // 长度
        System.out.println(ld1.lengthOfYear());
        System.out.println(ld1.lengthOfMonth());
        // 范围
        System.out.println(ld1.range(ChronoField.MONTH_OF_YEAR));
        // 增减差
        System.out.println(ld1.plus(Period.of(0, 2, 3)));
        System.out.println(ld1.plus(Period.ofWeeks(2)));
        System.out.println(ld1.plus(10,ChronoUnit.DAYS));
        System.out.println(ld1.plusWeeks(1));
        System.out.println(ld1.minus(Period.ofMonths(3)));
        System.out.println(ld1.minus(3, ChronoUnit.MONTHS));
        System.out.println(ld1.minusMonths(3));
        System.out.println(ld2.until(ld1, ChronoUnit.MONTHS));
        System.out.println(ld1.until(ld2));
        // 结合时间
        System.out.println(ld1.atStartOfDay());
        System.out.println(ld1.atTime(LocalTime.now()));
        System.out.println(ld1.atTime(OffsetTime.now()));
        System.out.println(ld1.atTime(12, 12, 30, 54));

        // 创建日期流
        ld2.datesUntil(ld1,Period.ofDays(3)).forEach(e -> System.out.println(e));

        // 自定义查询
        System.out.println(ld2.query(TemporalQueries.precision()));

        // System.out.println(ld1.adjustInto(ld2));
        // System.out.println(ld2.getChronology());
        // System.out.println(ld1.getEra());
        // System.out.println(ld1.toEpochSecond(LocalTime.now(), ZoneOffset.UTC));
    }
}

class LocalTimeTest {
    public static final void run() {
        // 类比日期
        LocalTime lt1 = LocalTime.now();
        System.out.println(lt1);
        LocalTime lt2 = LocalTime.parse("11 55 22 222", DateTimeFormatter.ofPattern("HH mm ss n"));
        System.out.println(lt2);
        LocalTime lt3 = LocalTime.ofNanoOfDay(11111111189788L);
        System.out.println(lt3);
        LocalTime lt4 = LocalTime.ofSecondOfDay(11111);
        System.out.println(lt4);
        LocalTime lt5 = LocalTime.parse("23:12:12");
        System.out.println(lt5);
        // 获取
        System.out.println(lt1.getLong(ChronoField.NANO_OF_SECOND));
        // 增加
        System.out.println(lt1.plus(Duration.ofMinutes(10).ofNanos(1001)));
        // 减少
        System.out.println(lt1.minus(12, ChronoUnit.HOURS));
        // 差
        System.out.println(lt1.until(lt2, ChronoUnit.HOURS));
        // 修改
        System.out.println(lt1.with(ChronoField.HOUR_OF_DAY,10));
        // 查询
        System.out.println(lt1.range(ChronoField.HOUR_OF_DAY));
        System.out.println(lt1.query(TemporalQueries.precision()));
        // 格式化
        System.out.println(lt1.format(DateTimeFormatter.ISO_TIME));
        // 结合日期
        System.out.println(lt1.atDate(LocalDate.now()));
        System.out.println(lt1.atOffset(ZoneOffset.UTC));
        // 没有时间流

        // 截断时间
        System.out.println(lt1.truncatedTo(ChronoUnit.MINUTES));
    }
}

class LocalDateTimeTest {
    public static final void run() {
        // 类比日期
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        System.out.println(ldt1.get(ChronoField.HOUR_OF_DAY));
        System.out.println(ldt1.isSupported(ChronoField.DAY_OF_MONTH));
        System.out.println(ldt1.isSupported(ChronoUnit.DECADES));
        System.out.println(ldt1.toLocalDate());
        System.out.println(ldt1.toLocalTime());
        System.out.println(ldt1.truncatedTo(ChronoUnit.HOURS));
    }
}

class 其他相关类 {
    public static final void run() {
        LocalDate ld = LocalDate.now(ZoneId.of("Europe/London")); // 当前系统时间对应的指定时区的时间
        LocalTime lt = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ZonedDateTime.now();
        OffsetTime ot = OffsetTime.now();
        OffsetDateTime odt = OffsetDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);
        System.out.println(zdt);
        System.out.println(ot);
        System.out.println(odt);
        Instant i = Instant.now(); // 无时区时间，即系统时间对应的格林威治时间UTC
        System.out.println(i);
        System.out.println("-".repeat(20) + "本地日期" + "-".repeat(20));
        System.out.println(ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println("-".repeat(20) + "本地时间" + "-".repeat(20));
        // System.out.println(lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));
        // System.out.println(lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));
        System.out.println(lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println(lt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        System.out.println("-".repeat(20) + "本地日期时间" + "-".repeat(20));
        // System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        // System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        System.out.println("-".repeat(20) + "时区日期时间" + "-".repeat(20));
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        System.out.println("-".repeat(20) + "偏移日期时间" + "-".repeat(20));
        // System.out.println(odt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        // System.out.println(odt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println(odt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(odt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    }
}

public class TimeTest {
    public static void main(String[] args) {
        // LocalDateTest.run();
        // LocalTimeTest.run();
        // LocalDateTimeTest.run();
        // 其他相关类.run();
        String str1 = "2023 22 23 12 34 12";
        String[] sarr = str1.split(" ");
        if (sarr.length != 6) {
            System.out.println("您输入的数据不合理");
        } else {
            LocalDateTime ldt = LocalDateTime.parse(sarr[0]+"-"+sarr[1]+"-"+sarr[2]+"T"+sarr[3]+":"+sarr[4]+":"+sarr[5]);
            System.out.println("北京时间为：" + ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println("纽约时间为：" + ldt.minusHours(12) .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }
}
