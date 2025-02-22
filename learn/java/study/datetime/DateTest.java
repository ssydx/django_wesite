package study.datetime;
import java.util.Date;

import tool.PrintMethods;
public class DateTest {
    public static void main(String[] args) {
        // 很多方法已被舍弃，请使用其他类替代
        Date d1 = new Date();
        System.out.println(d1);
        Date d2 = new Date(22345555551111l);
        System.out.println(d2);
        System.out.println(d1.before(d2));
        PrintMethods.print(Date.class);

    }
}
