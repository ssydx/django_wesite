package Web_test;

public class T {
    public static void main(String[] args) {
        int cnt = 0;
        int n = 0;
        for (int i = 1; i <= 10; i++) {
            n = n * 10 + 9;
            cnt += n;
        }
        System.out.println(cnt);
    }
}
