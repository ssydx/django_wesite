package other;
public class IntegerType {
    public static void main(String[] args) {
        var m = 10;
        var n = 3;
        System.out.println(m instanceof Number);
        System.out.println(n instanceof Integer);
        System.out.println(m/n);
        System.out.println(m%n);
        // 1111
        System.out.println(Integer.toBinaryString(-15));
        System.out.println(Integer.toBinaryString(-15 >> 1));
        System.out.println(Integer.toBinaryString(-15 >>> 1));
        short x = 12;
        int y = 12;
        int z = x + y;
        int sum = 0;
        int i = 100;
        System.out.println((1+100)*100/2);
        System.out.println(24.0/5.1);
        System.out.println(24.0%5.1);
        System.out.println("123" + 1);
        System.out.println(1 + "123");
        System.out.println('a' instanceof Character);
        System.out.println("abc" instanceof String);
        System.out.println("""
                1
                2
                3
                """);
        System.out.println("\\");
        String s1 = "abc";
        System.out.println(System.identityHashCode(s1));
        s1 += 'a';
        System.out.println(System.identityHashCode(s1));
        StringBuffer s2 = new StringBuffer("ABC");
        System.out.println(System.identityHashCode(s2));
        s2.append('A');
        System.out.println(System.identityHashCode(s2));
        int[] iarr1;
        int[] iarr2 = {1,2,3,4};
        int[] iarr3 = new int[] {1,2,3};
        int[] iarr4 = new int[3];
        System.out.println(iarr4.length);
        for (int j : iarr4) {
            System.out.println(j);
        }
        String[] sarr1 = {
            "zhangsan",
            "lisi",
            "wangwu",
        };
        for (String string : sarr1) {
            System.out.println(string);
        }
    }
    
}
