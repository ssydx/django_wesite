package study.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import tool.PrintMethods;

public class MethodTest {
    public static void main(String[] args) {
        try {
            Method m = String.class.getMethod("substring",int.class, int.class);
            System.out.println(m);
            String fullname = m.toString();
            System.out.println("对象全名：" + fullname);
            System.out.println("对象全名：" + m.toGenericString());
            Class<?> cls = m.getClass();
            System.out.println("对象自身：" + cls);
            System.out.println("对象自身：" + m.getDeclaringClass());
            int modifier = m.getModifiers();
            System.out.println("对象修饰符：" + Modifier.toString(modifier));
            String name = m.getName();
            System.out.println("对象名称：" + name);
            Class<?> returnType = m.getReturnType();
            System.out.println("对象返回值类型：" + returnType);
            System.out.println("对象返回值类型：" + m.getGenericReturnType());
            Class<?>[] parameterTypes = m.getParameterTypes();
            System.out.println("对象参数类型：" + Arrays.toString(parameterTypes));
            System.out.println("对象参数类型：" + Arrays.toString(m.getGenericParameterTypes()));
            System.out.println("对象参数数量：" + m.getParameterCount());
            System.out.println("对象参数：" + Arrays.toString(m.getParameters()));
            // System.out.println(m.getDefaultValue());
            // System.out.println(m.getExceptionTypes());
            // System.out.println(m.getGenericExceptionTypes());
            // System.out.println(Arrays.toString(m.getTypeParameters()));

            
            // m.canAccess();
            // m.trySetAccessible(); // 非强制将私有方法设置为可访问
            // m.setAccessible(false); // 强制将私有方法设置为可访问
            // System.out.println(m.isVarArgs());
            // System.out.println(m.isSynthetic());
            // System.out.println(m.isDefault());
            // System.out.println(m.isBridge());

            String s1 = "abcdefg";
            String s2 = (String)m.invoke(s1, 1, 5);
            System.out.println(s2);



        } catch (Exception e) {
            System.out.println("不存在此方法");
        }
    }
}
