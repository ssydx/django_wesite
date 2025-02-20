package tooltype;
public class System_test {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        String v = "";
        for (int i = 0; i < 10000; i++) {
            v += String.valueOf("abc");
        }
        long e = System.currentTimeMillis();
        System.out.println(e - s);
        System.out.println(System.getenv());
        System.out.println(System.getProperties());
    }
}
