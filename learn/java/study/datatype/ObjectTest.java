package study.datatype;

public class ObjectTest {
    public static void main(String[] args) {
        Object o1 = new Object();
        System.out.println(o1.hashCode());
        System.out.println(o1.toString());
        System.out.println(o1.equals(new Object()));
        // 获取类本身
        System.out.println(o1.getClass());
        System.err.println(Object.class);
    }
}
