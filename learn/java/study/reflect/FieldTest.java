package study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    public static void main(String[] args) {
        try {
            Field f = Boolean.class.getField("FALSE");
            System.out.println(f);
            String fullname = f.toString();
            System.out.println("对象全名：" + fullname);
            System.out.println("对象全名：" + f.toGenericString());
            Class<?> cls = f.getClass();
            System.out.println("对象自身：" + cls);
            System.out.println("对象自身：" + f.getDeclaringClass());
            int modifier = f.getModifiers();
            System.out.println("对象修饰符：" + Modifier.toString(modifier));
            String name = f.getName();
            System.out.println("对象名称：" + name);
            Class<?> type = f.getType();
            System.out.println("对象类型：" + type);
            System.out.println("对象类型：" + f.getGenericType());
            
            // f.canAccess();
            // f.trySetAccessible(); // 非强制将私有方法设置为可访问
            // f.setAccessible(false); // 强制将私有方法设置为可访问
            // System.out.println(f.isSynthetic());

            Boolean b1 = true;
            Boolean b2 = (Boolean)f.get(b1);
            System.out.println(b2); // 不是true，因为b1对象的FALSE属性值恒为false

            // boolean b3 = f.getBoolean(b1);
            // System.out.println(b3); 

            // f.set(b1, true);
            // f.setBoolean(b1, false);

        } catch (Exception e) {
            System.out.println("没有此属性");
            e.printStackTrace();
        }
    }
}
