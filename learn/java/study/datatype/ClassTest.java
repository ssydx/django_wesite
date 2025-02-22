package study.datatype;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassTest {
    public static void main(String[] args) {
        Integer i = 10;
        Class<? extends Integer> c = i.getClass();

        System.out.println("包名：" + c.getPackageName());
        System.out.println("包对象：" + c.getPackage());
        System.out.println("模块对象：" + c.getModule());
        System.out.println("父类对象：" + c.getSuperclass());
        System.out.println("父类对象(含泛型参数)：" + c.getGenericSuperclass());
        System.out.println("接口对象数组：" + Arrays.toString(c.getInterfaces()));
        System.out.println("接口对象数组（含泛型参数）：" + Arrays.toString(c.getGenericInterfaces()));
        // 类名
        System.out.println(c);
        System.out.println(c.getTypeName());
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        // 修饰符
        System.out.println(Modifier.toString(c.getModifiers()));
        // 内部类
        System.out.println(Arrays.toString(c.getClasses()));
        System.out.println(Arrays.toString(c.getDeclaredClasses()));
        // 属性
        System.out.println(Arrays.toString(c.getFields()));
        System.out.println(Arrays.toString(c.getDeclaredFields()));
        try {
            System.out.println(c.getField("MAX_VALUE"));
            System.out.println(c.getDeclaredField("Min_value"));
        } catch (Exception e) {
            System.out.println(e.getClass() + ":" + e.getMessage());
        }
        // 方法
        System.out.println(Arrays.toString(c.getMethods()));
        System.out.println(Arrays.toString(c.getDeclaredMethods()));
        try {
            System.out.println(c.getMethod("valueOf", int.class));
            System.out.println(c.getDeclaredMethod("equal", Object.class));
        } catch (Exception e) {
            System.out.println(e.getClass() + ":" + e.getMessage());
        }
        // 构造方法
        System.out.println(Arrays.toString(c.getConstructors()));
        System.out.println(Arrays.toString(c.getDeclaredConstructors()));
        try {
            System.out.println(c.getConstructor(int.class));
            System.out.println(c.getDeclaredConstructor(String.class));
        } catch (Exception e) {
            System.out.println(e.getClass() + ":" + e.getMessage());
        }
        // 根据字符串获取类对象
        try {
            Class<?> cc = Class.forName("java.lang.Number");
            System.out.println(cc.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 是否为基本类型或void
        System.out.println(int.class.isPrimitive());
        // 是否为数组类型
        int[] arr = {1,2,3};
        System.out.println(arr.getClass().isArray());
        // 还有很多方法

        // System.out.println(c.getClassLoader());
        // System.out.println(c.descriptorString());
    }
}
