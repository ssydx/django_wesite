package reflect_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 使用 @Target 指定此注解可以用在哪些地方
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.PARAMETER})
// 使用 @Retention 指定此注解在什么时候可用: RUNTIME, CLASS, 或 SOURCE
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {
    String value() default "default value"; // 可选元素，具有默认值
    int count() default 1; // 另一个可选元素，具有默认值
}

class MyClass {
    private int cnt;
    @TestAnnotation(value = "Hello", count = 5)
    public String name;
    @TestAnnotation(value = "Hello", count = 5)
    MyClass(@TestAnnotation(value = "hello") int cnt) {
        this.cnt = cnt;
    }
    @TestAnnotation(value = "Hello", count = 5)
    public void myMethod() {
        System.out.println("My Method");
    }
}

public class Annotation_test {
    public static void main(String[] args) {
        MyClass c1 = new MyClass(12);
        // c1.myMethod();
        try {
            Method m = c1.getClass().getDeclaredMethod("myMethod");
            System.out.println(m);
            System.out.println(m.isAnnotationPresent(TestAnnotation.class));
            System.out.println(m.getAnnotation(TestAnnotation.class));
            System.out.println(m.getAnnotation(TestAnnotation.class).value());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
