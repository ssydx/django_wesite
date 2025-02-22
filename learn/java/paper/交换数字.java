package paper;

public class 交换数字 {
    private static void change1(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a + " b=" + b);
    }
    private static void change2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + " b=" + b);
    }
    public static void main(String[] args) {
        change1(20, 10);
        change2(20, 10);

        change1(Integer.MAX_VALUE, 1);
        change2(Integer.MAX_VALUE, 1);

        int i = Integer.MAX_VALUE + 1;
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
    }
}
