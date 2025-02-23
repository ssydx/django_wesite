package study.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.lang.annotation.Annotation;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation1 {
    String value() default "hello";
    int count();
}

@Annotation1(count = 10)
class AnnotationTest1 {
    public String name = "ssydx";
    private int age = 25;
    AnnotationTest1(int age) {
        this.age = age;
    }
    private int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        System.out.println(getAge());
    }
}


public class AnnotationTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = AnnotationTest1.class;
            Class<? extends Annotation> cls = Annotation1.class;
            System.out.println(cls.isAnnotation()); // 是注释类
            System.out.println(clazz.isAnnotationPresent(cls)); // 被指定的注释类进行注释
            Annotation[] annotations = clazz.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
