import java.util.Date;
public class String_test {
    public static void main(String[] args) {
        String s1 = "甲乙丙123abcABC😀。    .";
        System.out.println(s1.charAt(1));
        System.out.println(s1.substring(2,5));
        System.out.println(s1.subSequence(2, 5));
        System.out.println(s1.length());
        // 格式化
        System.out.println(String.format("%1$c %2$s", 'c',"sss"));
        Date d1 = new Date();
        System.out.println(d1);
        // 日期时间
        System.out.printf("%1$tD %1$tT %1$tR %1$tr %1$tF %1$tc\n", d1);
        // 世纪
        String s2 = String.format("%1$tC", d1);
        System.out.println(s2);
        // 年
        String s3 = String.format("%1$tY %1$ty", d1);
        System.out.println(s3);
        // 月
        String s4 = String.format("%1$tm %1$tB %1$tb %1$th", d1);
        System.out.println(s4);
        // 日
        String s5 = String.format("%1$td %1$te", d1);
        System.out.println(s5);
        // 周
        String s6 = String.format("%1$tA %1$ta", d1);
        System.out.println(s6);
        // 第几天
        String s7 = String.format("%1$tj", d1);
        System.out.println(s7);
        // 时
        String s8 = String.format("%1$tH %1$tI %1$tk %1$tl", d1);
        System.out.println(s8);
        // 分
        String s9 = String.format("%1$tM", d1);
        System.out.println(s9);
        // 秒 毫秒 纳秒
        String s10 = String.format("%1$tS %1$tL %1$tN", d1);
        System.out.println(s10);
        String s11 = String.format("%1$tZ %1$tp %1$ts %1$tQ", d1);
        System.out.println(s11);
    }
}
