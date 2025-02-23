package study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


@Target({
    ElementType.TYPE,
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.PARAMETER,
    ElementType.CONSTRUCTOR,
})
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {
    String name();
    int value() default 1;
}

@TestAnnotation(name = "class")
class MyClass {
    private int age;
    @TestAnnotation(name = "field",value = 2)
    public String name;
    @TestAnnotation(name = "constructor",value = 5)
    public MyClass(@TestAnnotation(name = "parameter",value = 4) int age) {
        this.age = age;
    }
    @TestAnnotation(name = "method",value = 3)
    public void myMethod() {
        System.out.println("My Method");
    }
}

public class AnnotationTest {
    public static void main(String[] args) {
        try {
            Class<TestAnnotation> clazz = TestAnnotation.class;
            System.out.println(clazz);
            System.out.println("修饰符：" + Modifier.toString(clazz.getModifiers()));
            System.out.println("简略名：" + clazz.getSimpleName());
            System.out.println("属性：" + Arrays.toString(clazz.getFields()));
            System.out.println("方法：" + Arrays.toString(clazz.getMethods()));
            System.out.println("构造器：" + Arrays.toString(clazz.getConstructors()));

            Method m = clazz.getMethod("value");
            System.out.println(m);
            System.out.println("方法修饰符：" + Modifier.toString(m.getModifiers()));
            System.out.println("方法简略名：" + m.getName());
            System.out.println("方法返回值：" + m.getReturnType());
            System.out.println("方法参数列表：" + Arrays.toString(m.getParameterTypes()));
            System.out.println("方法默认值（特指注解类）：" + m.getDefaultValue());
        } catch (Exception e) {
            // TODO: handle exception
        }

        // try {
        //     MyClass c = new MyClass(12);
        //     Class<? extends MyClass> clazz = c.getClass();
        //     clazz.getAnnotation(TestAnnotation.class);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}
