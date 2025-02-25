package com.ssydx.springdemo5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class ProxyUser {
    private ProxyUser() {}
    public static UserInterface toProxy(UserInterface src) {
        return (UserInterface)Proxy.newProxyInstance(
            src.getClass().getClassLoader(), 
            src.getClass().getInterfaces(), 
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("方法调用前");
                    Object retValue = method.invoke(src, args);
                    System.out.println("方法调用后");
                    return retValue;
                }
            }
        );
    }
}

// public class ProxyUser {
//     // 私有构造函数，防止实例化
//     private ProxyUser() {}

//     public static <T> T toProxy(T src) {
//         Class<?> clazz = src.getClass();
//         // 检查是否有实现任何接口
//         if (clazz.getInterfaces().length == 0) {
//             throw new IllegalArgumentException("The provided object does not implement any interfaces.");
//         }
        
//         return (T) Proxy.newProxyInstance(
//                 clazz.getClassLoader(),
//                 clazz.getInterfaces(),
//                 new InvocationHandler() {
//                     @Override
//                     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                         System.out.println("方法调用前");
//                         try {
//                             Object retValue = method.invoke(src, args);
//                             System.out.println("方法调用后");
//                             return retValue;
//                         } catch (Throwable t) {
//                             // 可以在这里加入特定的异常处理逻辑
//                             throw t;
//                         }
//                     }
//                 });
//     }
// }