package tooltype;

public class Math_test {
    public static void main(String[] args) {
        double d1 = 3.452343;
        double d2 = -3.543221;
        System.out.println(Math.min(d1, d2));
        System.out.println(Math.max(d1, d2));
        System.out.println(Math.abs(d2));
        System.out.println(Math.random());
        System.out.println(Math.round(d2));
        System.out.println(Math.sqrt(d2));
        System.out.println(Math.pow(d1, d2));
        System.out.println(Math.rint(d2)); // 最接近的整数（类型仍是原类型），如果两侧差相同，返回偶数那个
        System.out.println(Math.clamp(d1, 0, 3));
        System.out.println(Math.toRadians(180) == Math.PI);
        System.out.println(Math.toDegrees(Math.PI) == 180);
        System.out.println(Math.ceil(d2));
        System.out.println(Math.floor(d2));
    }
}
