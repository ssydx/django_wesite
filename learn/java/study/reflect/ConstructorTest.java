package study.reflect;

import java.lang.reflect.Constructor;

public class ConstructorTest {
    public static void main(String[] args) {
        try {
            Constructor<String> c = String.class.getConstructor(char[].class);

            // 其他方法不再赘述

            String str = c.newInstance(new char[]{'a','b','c'});
            System.out.println(str);

        } catch (Exception e) {
            System.out.println("没有此构造器");
        }
    }

}
