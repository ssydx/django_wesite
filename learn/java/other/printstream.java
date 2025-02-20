package other;
import java.util.Locale;

public class printstream {
    public static void main(String[] args) {
        System.out.print(true);
        System.out.print(2);
        System.out.print(2.5);
        System.out.print('a');
        System.out.print(new char[]{'a','b','c'});
        System.out.print("123");
        System.out.println();
        System.out.println(12);
        System.out.printf(Locale.TRADITIONAL_CHINESE,"%4$-10s%3$5s%2$2s%1$1s", "a", "b", "档案", "一");
        System.out.format(Locale.TRADITIONAL_CHINESE,"%4$-10s%3$5s%2$2s%1$1s", "a", "b", "档案", "一");
        System.out.append("abc").append('c');
    }
}
