import java.util.Arrays;
import java.util.Scanner;

public class BaseTest {
    private class Test3_1 {
        public static void run() {
            double V = Math.pow(10/2, 2) * Math.PI * 3;
            System.out.println(V);
            double KG = V * 750;
            System.out.println(KG);
        }
    }
    private class Test3_2 {
        public static void run() {
            int a = 3000;
            int b = 4500;
            if (a > 3500) {
                System.out.println("a需要纳税");
            }
            if (b > 3500) {
                System.out.println("b需要纳税");
            }
        }
    }
    private class Test3_3 {
        public static void run() {
            if ('g' == 103) {
                System.out.println("g == 103");
            } else {
                System.out.println("g != 103");
            }
        }
    }
    private class Test3_4 {
        public static void run() {
            System.out.println("ABCDEFG");
        }
    }
    private class Test3_5 {
        public static void run() {
            System.out.println(100/8.7);
        }
    }
    private class Test3_6 {
        public static void run() {
            double x = (28 * 8 - 2 * 62) / (21.8 * 8 - 2 * 7);
            double y = (21.8 * 62 - 28 * 7) / (21.8 * 8 - 2 * 7);
            System.out.printf("x == %1$+f, y == %2$+f\n", x, y);
            System.out.println(x * 21.8 + y *2);
            System.out.println(x * 7 + y *8);
        }
    }
    private class Test3_7 {
        public static void run() {
            char a = 'a';
            char b = 'b';
            char c = 'c';
            // 将会转换为整数
            System.out.println(a + b + c);
        }
    }
    private class Test3_8 {
        public static void run() {
            double h = Math.floor(2 / 1.5);
            double v = Math.floor(4 / 1.5);
            System.out.println((int)(h * v));
        }
    }
    private class Test3_z1 {
        public static void run() {
            char horse = '马';
            char elephant = '象';
            char armer = '卒';
            System.out.printf("%1$c走日,%2$c走田,小%3$c一去不复还\n",horse,elephant,armer);
        }
    }
    private class Test3_z2 {
        public static void run() {
            System.out.printf("%1$10s\n", "中国工商银行");
            System.out.println("-".repeat(20));
            System.out.printf("日期：  %1$s\n","2021-03-10");
            System.out.printf("姓名：  %1$s\n","张三");
        }
    }
    private class Test3_z3 {
        public static void run() {
            System.out.printf("%1$10s\n", "个人基本信息");
            System.out.println("-".repeat(20));
            System.out.printf("姓名：  %1$s\n","张三");
            System.out.printf("姓别：  %1$c\n",'男');
            System.out.printf("年龄：  %1$d\n",25);
            System.out.printf("身高：  %1$.2f米\n",1.76);
            System.out.printf("是否已婚：  %1$b\n",false);
        }
    }
    private class Test3_z4 {
        public static void run() {
            System.out.printf("小李的最终收入是：%1$d元\n",4500 + 1000 - 500);
        }
    }
    private class Test3_z5 {
        public static void run() {
            int a = 123456;
            String s = "";
            while (a / 10 != 0) {
                s += a % 10;
                a = a / 10;
            }
            s += a;
            System.out.println(s);
        }
    }
    private class Test3_z6 {
        public static void run() {
            System.out.println(80 > 60 ? "及格" : "不及格");
        }
    }
    private class Test3_z7 {
        public static void run() {
            System.out.println((10 - 0.2 * 30 - 0.3 * 10) / 0.2);
        }
    }
    private class Test3_z8 {
        public static void run() {
            System.out.println(Math.floor(400/23) * Math.floor(160/23)* Math.floor(30/23));
        }
    }
    private class Test4_1 {
        public static void run() {
            System.out.println("*".repeat(100));
            System.out.println("几人用餐？");
            int cnt = 8;
            System.out.println("回答：" + 8 + "人");
            if (cnt < 4) {
                System.out.println("大厅四人桌");
            } else if (cnt >= 4 && cnt < 8) {
                System.out.println("大厅八人桌");
            } else {
                System.out.println("楼上包厢");
            }
        }
    }
    private class Test4_2 {
        public static void run() {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入成绩");
            int grade = sc.nextInt();
            switch (grade) {
                case 10:
                case 9:
                    System.out.println("优");
                    break;
                case 8:
                    System.out.println("良");
                    break;
                case 7:
                case 6:
                    System.out.println("中");
                    break;
                case 5:
                case 4:
                case 3:
                case 2:
                case 1:
                case 0:
                    System.out.println("差");
                    break;
                default:
                    System.out.println("无效");
                    break;
            }
            sc.close();
        }
    }
    private class Test4_3 {
        public static void run() {
            int i = 1;
            int sum = 0;
            while (i <= 1000) {
                sum += i++;
            }
            System.out.println(sum);
        }
    }
    private class Test4_4 {
        public static void run() {
            Scanner sc = new Scanner(System.in);
            int pw;
            do {
                System.out.println("请输入三位数密码");
                pw = sc.nextInt();
            } while (pw != 123);
            System.out.println("登录成功");
            sc.close();
        }
    }
    private class Test4_5 {
        public static void run() {
            int evensum = 0;
            for (int i = 2; i <= 100; i++) {
                if (i % 2 == 0) {
                    evensum += i;
                }
            }
            System.out.println(evensum);
            int sum = 0;
            for (int i = 2; i <= 100; i += 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }
    private class Test4_6 {
        public static void run() {
            int[] arr = {1,2,3,4,5};
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    private class Test4_7 {
        public static void run() {
            int i = 1;
            int sum = 1;
            while (i++ <= 10) {
                sum <<= 1;
            }
            System.out.println(sum);
        }
    }
    private class Test4_8 {
        public static int fab(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fab(n - 1) + fab(n - 2);
            }
        }
        public static int fab1(int n) {
            if (n <= 1) {
                return n;
            }
            int[] memo = new int[n + 1];
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
            return memo[n];
        }
        public static void run() {
            int a = 1;
            int b = 1;
            int c = 0;
            for (int i = 3; i <= 9; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
            System.out.println(fab(3));
            System.out.println(fab1(9));
        }
    }
    private class Test4_9 {
        public static void run() {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    private class Test4_10 {
        public static void run() {
            // 默认只跳出当前循环，通过标签可跳出外层循环
            lab: for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (j == 4) {
                        break lab;
                    }
                    System.out.println("i="+i+",j="+j);
                }
            }
        }
    }
    private class Test4_11 {
        public static void run() {
            // 默认只跳出当前循环，通过标签可跳出外层循环
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    continue;
                }
                System.out.println(i);
            }
        }
    }
    private class Test4_z1 {
        public static void run() {
            Scanner sc = new Scanner(System.in);
            int num;
            do {
                System.out.println("请输入整数");
                num = sc.nextInt();
                if (num % 2 == 0) {
                    System.out.println("even");
                } else {
                    System.out.println("odd");
                }
            } while (num != 0);
        }
    }
    private class Test4_z2 {
        public static void run() {
            // 全高+1
            int rcnt = 10;
            // for (int r = 1; r < rcnt; r++) {
            //     System.out.println(" ".repeat(10-r) + "*".repeat(2*r -1));
            // }
            // for (int r = rcnt; r >= 1; r--) {
            //     System.out.println(" ".repeat(10-r) + "*".repeat(2*r -1));
            // }
            for (int r = 1; r < rcnt; r++) {
                System.out.println(" ".repeat(Math.abs(rcnt / 2 - r)) + "*".repeat(r <= rcnt / 2 ? 2 * r - 1 : 2 * (rcnt - r) - 1));
            }
        }
    }
    private class Test4_z3 {
        public static int fac(int n) {
            if (n == 1) {
                return n;
            }
            return n * fac(n - 1);
        }
        public static void run() {
           int i = 1;
           int n = 1;
           double sum = 0;
           while (i++ <= 20) {
                sum += 1.0 / n;
                n *= i;
           }
           double sum1 = 0;
           for (int j = 1; j <= 20; j++) {
                sum1 += 1.0 / fac(j);
           }
           System.out.println(sum);
           System.out.println(sum1);
        }
    }
    private class Test4_z4 {
        public static void run() {
            char[] arr = {4,5,6,7};
            for (char c : arr) {
                
            }
        }
    }
    private class Test4_z5 {
        public static boolean isPrime(int n) {
            if (n == 0 || n == 1) {
                return false;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
        public static void run() {
            label: for (int i = 2; i <= 20; i++) {
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        continue label;
                    }
                    
                }
                System.out.println(i);
            }
            for (int i = 2; i <= 20; i++) {
                boolean isPrime = true;
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime == true) {
                    System.out.println(i);
                }
            }
            for (int k = 1; k <= 100; k++) {
                if (isPrime(k)) {
                    System.out.println(k);
                }
            }
        }
    }
    public static void main(String[] args) {
        Test3_1.run();
        Test3_2.run();
        Test3_3.run();
        Test3_4.run();
        Test3_5.run();
        Test3_6.run();
        Test3_7.run();
        Test3_8.run();
        Test3_z1.run();
        Test3_z2.run();
        Test3_z3.run();
        Test3_z4.run();
        Test3_z5.run();
        Test3_z6.run();
        Test3_z7.run();
        Test3_z8.run();
        Test4_1.run();
        // Test4_2.run();
        Test4_3.run();
        // Test4_4.run();
        Test4_5.run();
        Test4_6.run();
        Test4_7.run();
        Test4_8.run();
        Test4_9.run();
        Test4_10.run();
        Test4_11.run();
        // Test4_z1.run();
        Test4_z2.run();
        Test4_z3.run();
        Test4_z5.run();

    }
}
