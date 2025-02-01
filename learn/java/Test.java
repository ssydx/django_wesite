// 基本数据类型
public class Test {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o3 = new Object();
        Object o2 = o1;
        System.out.println(o1);
        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
        System.out.println(o1.hashCode());
        System.out.println(o1.getClass());
    }
}
