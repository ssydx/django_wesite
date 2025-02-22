package simpledatatype;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarType {
    private static void datePrint(int field, String name, String note) {
        Calendar c = Calendar.getInstance();
        System.out.printf(
            "%1$-30s：%2$-10s 最小值：%3$-10s 最大值：%4$-10s 备注：%5$-20s\n",
            name,
            c.get(field),
            c.getActualMinimum(field),
            c.getActualMaximum(field),
            note
        );
    }
    public static void main(String[] args) {
        // 线程安全性和易用性存在问题
        Calendar c = Calendar.getInstance(Locale.CHINESE);
        System.out.println(c);
        System.out.println(c.getTime());
        System.out.println(c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CHINESE));
        System.out.println(c.getDisplayNames(Calendar.MONTH, Calendar.LONG, Locale.CHINESE));
        c.set(2022, 11,20);
        System.out.println(c.getTime());
        c.set(2024, 3, 12, 12, 30, 31);
        System.out.println(c.getTime());
        c.set(Calendar.YEAR,2025);
        System.out.println(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 20);
        System.out.println(c.getTime());

        
        c.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println(c.getFirstDayOfWeek());
        System.out.println(c.getTimeZone());
        System.out.println(c.before(Calendar.getInstance()));
        System.out.println(c.after(Calendar.getInstance()));


        datePrint(Calendar.YEAR, "年", "");
        datePrint(Calendar.MONTH, "月","从0开始");
        datePrint(Calendar.DAY_OF_MONTH, "日","当前月份的最大值");
        datePrint(Calendar.HOUR_OF_DAY, "时","24小时制");
        datePrint(Calendar.HOUR, "时","12小时制");
        datePrint(Calendar.MINUTE, "分","");
        datePrint(Calendar.SECOND, "秒","");
        datePrint(Calendar.MILLISECOND, "毫秒","");
        datePrint(Calendar.DAY_OF_WEEK, "周几","1为周日，7为周六");
        datePrint(Calendar.WEEK_OF_MONTH, "月中第几周","");
        datePrint(Calendar.WEEK_OF_YEAR, "年中第几周","");
        datePrint(Calendar.DAY_OF_WEEK_IN_MONTH, "本月第几次出现该周几","");


    }
}
