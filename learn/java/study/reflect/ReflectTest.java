package study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class MyClass {
    private String p_name;
    private int p_age;
    public String name;
    public int age;
    public MyClass(String p_name, int p_age) {
        this.p_name = p_name;
        this.p_age = p_age;
    }
    MyClass(String p_name, int p_age, String name, int age) {
        this.p_name = p_name;
        this.p_age = p_age;
        this.name = name;
        this.age = age;
    }
    String info() {
        return name + age;
    }
    String info(int a) {
        return name + age + a;
    }
    @Override
    public String toString() {
        return p_name + p_age;
    }
}

public class ReflectTest {
    public static void main(String[] args) {
        MyClass c1 = new MyClass("zs", 23);
        System.out.println(c1);
        Class <? extends MyClass> classInfo = c1.getClass();
        // 包
        System.out.println(classInfo.getPackage());
        System.out.println(classInfo.getPackageName());
        // 类名
        System.out.println(classInfo.getName());
        System.out.println(classInfo.getTypeName());
        System.out.println(classInfo.getSimpleName());
        // 父类
        System.out.println(classInfo.getSuperclass());
        // 接口
        System.out.println(Arrays.toString(classInfo.getInterfaces()));
        // 构造方法
        System.out.println(Arrays.toString(classInfo.getConstructors()));
        System.out.println(Arrays.toString(classInfo.getDeclaredConstructors()));
        try {
            System.out.println(classInfo.getDeclaredConstructor(String.class,int.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 方法
        System.out.println(Arrays.toString(classInfo.getMethods()));
        System.out.println(Arrays.toString(classInfo.getDeclaredMethods()));
        try {
            System.out.println(classInfo.getDeclaredMethod("info"));
            System.out.println(classInfo.getDeclaredMethod("info",int.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 属性
        System.out.println(Arrays.toString(classInfo.getFields()));
        System.out.println(Arrays.toString(classInfo.getDeclaredFields()));
        try {
            System.out.println(classInfo.getDeclaredField("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 内部类
        System.out.println(Arrays.toString(classInfo.getClasses()));
        System.out.println(Arrays.toString(classInfo.getDeclaredClasses()));

        System.out.println("-".repeat(50));

        // 属性
        Field[] farr = classInfo.getDeclaredFields();
        for (Field field : farr) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
            field.setAccessible(true);
            try {
                System.out.println(field.get(c1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            classInfo.getDeclaredField("name").set(c1, "ssydx");
            classInfo.getDeclaredField("age").setChar(c1, '1');
            System.out.println(c1.name);
            System.out.println(c1.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Method[] marr = classInfo.getDeclaredMethods();
        try {
            for (Method method : marr) {
                System.out.println(method);
                System.out.println(method.getName());
                System.out.println(Arrays.toString(method.getParameterTypes()));
                System.out.println(method.getReturnType());
                System.out.println(method.getModifiers());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method m = classInfo.getDeclaredMethod("info");
            System.out.println(m.invoke(c1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
