import java.io.InputStream;
import java.util.Scanner;

public class Runtime_test {
    public static void main(String[] args) {
        try {
            InputStream s = Runtime.getRuntime().exec(new String[]{"help"}).getInputStream();
            Scanner sc = new Scanner(s);
            do {
                System.out.println(sc.nextLine());
            } while (sc.hasNextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        Runtime r1 = Runtime.getRuntime();
        String str[] = new String[10000];
        long s = r1.freeMemory();
        System.out.println("设置前的空闲内存" + s);
        for (String si : str) {
            si = "123";
        }
        long e = r1.freeMemory();
        System.out.println("设置后的空闲内存" + e);
        System.out.println("使用的内存" + (s - e));
        System.out.println(r1.maxMemory());
        System.out.println(r1.totalMemory());
        System.out.println(Runtime.version());
        try {
            System.out.println(Runtime.getRuntime().exec(new String[]{"help"}).getClass());
        } catch (Exception e2) {
            // TODO: handle exception
        }
    }
}
