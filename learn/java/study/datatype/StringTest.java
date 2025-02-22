package study.datatype;

import java.util.Date;
import java.util.Arrays;

import tool.PrintMethods;

class StringTestt {
    public static final void run() {
        // 字符串是不可变对象，对其进行操作不会影响原字符串
        // 重点：格式化，替换，匹配，码点

        PrintMethods.set("|", 30, 30, 30, 30);
        PrintMethods.print(String.class);
        // 创建
        byte[] barr = {12,34,56,100,77};
        String s1 = new String(barr);
        System.out.println(s1);
        char[] carr = {'2','s','啊'};
        String s2 = new String(carr);
        System.out.println(s2);
        String s3 = " 这A1a😀🆒🍺 \t ";
        // 判空
        System.out.println(s3);
        System.out.println(s3.isEmpty());
        System.out.println(s3.length());
        System.out.println(s3.isBlank());
        // 修剪
        String s4 = s3.trim();
        System.out.println(s4);
        System.out.println(s4.length());
        String s5 = s3.stripLeading().stripTrailing();
        System.out.println(s5);
        System.out.println(s5.length());
        // 取出
        System.out.println(s5.charAt(3));
        System.out.println(s5.substring(2, 5));
        // 包含
        System.out.println(s5.indexOf("1a"));
        System.out.println(s5.lastIndexOf('1',1));
        System.out.println(s5.startsWith("1",2));
        System.out.println(s5.endsWith("a"));
        System.out.println(s5.contains("a"));
        // 匹配
        // 整体匹配
        System.out.println(s5.matches(".*"));
        // 自身从指定位置起与另一字符串从指定位置起，指定长度内是否相同
        System.out.println(s5.regionMatches(true, 0, "这A1A😀🆒🍺", 0, 5));
        // 转换
        System.out.println(s5.toLowerCase());
        System.out.println(s5.toUpperCase());
        // 连接和拆分
        String s6 = "a b c";
        String s7 = "def";
        System.out.println(Arrays.toString(s6.split(" ",2)));
        System.out.println(s6 + s7);
        System.out.println(s6.concat(s7));
        System.out.println(String.join("-", s6, s7, "123"));
        // 相等判定，注意：采用常量形式创建的字符串，如果内容相同，两者地址也相同，本质是利用了字符串常量池，valueOf(字符串常量)同理，其他valueOf相关方法或new方法返回的对象地址则总是不同的
        String s8 = "Abc";
        String s9 = "aBc";
        String s10 = "aBc";
        System.out.println(s8.hashCode());
        System.out.println(s9.hashCode());
        System.out.println(s10.hashCode());
        System.out.println(s8 == s9);
        System.out.println(s10 == s9);
        System.out.println(s8.equals(s9));
        System.out.println(s9.equals(s10));
        System.out.println(s9.contentEquals(s10)); // 不仅比较字符串
        System.out.println(s9.equalsIgnoreCase(s10));
        // 替换
        String s11 = " a b c";
        System.out.println(s11.replace(" ",""));
        System.out.println(s11.replaceAll("[a-z]", "1"));
        System.out.println(s11.replaceFirst(" ", "1"));
        // 重复
        System.out.println(s11.repeat(2));
        System.out.println(String.format("%1$5s %2$03d", "a",1));
        System.out.println("%5s".formatted("a","b"));

        // indent stripindent

        // 类型转换
        String str1 = String.valueOf(true);
        String str2 = String.valueOf(Byte.valueOf("1"));
        String str3 = String.valueOf(1);
        String str4 = String.valueOf(1.2);
        String str5 = String.valueOf(new Object());
        String str6 = String.valueOf(new char[]{'a','b','c'},0,2);
        String str7 = String.valueOf('a');
        String[] strarr = {str1,str2,str3,str4,str5,str6,str7};
        for (String string : strarr) {
            System.out.println(string);
        }
        String str8 = "abc123";
        System.out.println(Arrays.toString(str8.toCharArray()));

        // 比较器 compareTo compareToIgnoreCase
        // 复杂字符可能占据两个字符长度，涉及到码点问题，请注意

        String ss1 = new String("abc");
        String ss2 = new String("abc");
        String ss3 = "abc";
        String ss4 = "abc";
        System.out.println(ss1 == ss2);
        System.out.println(ss3 == ss4);
        System.out.println(ss2 == ss3);
        Integer i = Integer.valueOf(10);
        String ss5 = String.valueOf(i);
        String ss6 = String.valueOf(i);
        System.out.println(ss5 == ss6);
        String ss7 = String.valueOf("abc😀");
        String ss8 = String.valueOf("abc😀");
        System.out.println(ss7 == ss8);

        Integer i1 = Integer.valueOf(128);
        Integer i2 = Integer.valueOf(128);
        System.out.println(i1 == i2);
    }
}

class 字符串补充 {
    public static final void run() {
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

public class StringTest {
    public static void main(String[] args) {
        StringTestt.run();
        字符串补充.run();

    }
}
