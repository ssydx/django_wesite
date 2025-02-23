package study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import tool.PrintFields;

import java.lang.annotation.Annotation;

@Target(ElementType.TYPE)
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

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation2 {
    String value() default "hello";
    int count() default 3;
}
class AnnotationTest2 {
    @Annotation2
    public String name = "ssydx";
    private int age = 25;
    AnnotationTest2(int age) {
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

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation3 {
    String value();
    int count();
}
class AnnotationTest3 {
    public String name = "ssydx";
    private int age = 25;
    AnnotationTest3(int age) {
        this.age = age;
    }
    private int getAge() {
        return age;
    }
    @Annotation3(value = "ss", count = 10)
    public void setAge(int age) {
        this.age = age;
        System.out.println(getAge());
    }
}

@Target({ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation4 {
    String value() default "ss";
    int count() default 10;
}
class AnnotationTest4 {
    public String name = "ssydx";
    private int age = 25;
    @Annotation4(value = "zs", count = 18)
    AnnotationTest4(int age) {
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

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation5 {
    String value() default "ss";
    int count() default 10;
}
class AnnotationTest5 {
    public String name = "ssydx";
    private int age = 25;
    AnnotationTest5(int age) {
        this.age = age;
    }
    private int getAge() {
        return age;
    }
    public void setAge(@Annotation5(value = "parameter") int age) {
        this.age = age;
        System.out.println(getAge());
    }
}


public class ElementTypeTest {
    private static void print(Annotation annotation) {
        System.out.println("注解对象；" + annotation);
        Class<?> clazz = annotation.annotationType();
        System.out.println("注解目标；" + clazz.getDeclaredAnnotation(Target.class));
        System.out.println("注解时期；" + clazz.getDeclaredAnnotation(Retention.class));
    }
    public static void main(String[] args) {
        PrintFields.print(ElementType.class);

        Class<?> cls1 = AnnotationTest1.class;
        Annotation a1 = cls1.getAnnotation(Annotation1.class);
        print(a1);

        try {
            Class<?> cls2 = AnnotationTest2.class;
            Field f = cls2.getField("name");
            Annotation a2 = f.getAnnotation(Annotation2.class);
            print(a2);
        } catch (Exception e) {
            System.out.println("没有此属性");
        }

        try {
            Class<?> cls3 = AnnotationTest3.class;
            Method m = cls3.getMethod("setAge", int.class);
            Annotation a3 = m.getAnnotation(Annotation3.class);
            print(a3);
        } catch (Exception e) {
            System.out.println("没有此方法");
        }

        try {
            Class<?> cls4 = AnnotationTest4.class;
            Constructor<?> c1 = cls4.getDeclaredConstructor(int.class);
            Constructor<AnnotationTest4> c2 = AnnotationTest4.class.getDeclaredConstructor(int.class);
            Annotation a4 = c2.getAnnotation(Annotation4.class);
            print(a4);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("没有此构造方法");
        }

        try {
            Method m = AnnotationTest5.class.getMethod("setAge", int.class);
            Parameter[] ps = m.getParameters();
            System.out.println(Arrays.toString(ps));
            for (Parameter parameter : ps) {
                Annotation a5 = parameter.getAnnotation(Annotation5.class);
                print(a5);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }
}
