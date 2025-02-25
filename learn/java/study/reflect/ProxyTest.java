import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Service {
    void performService1();
    void performService2(String message);
}

class RealService implements Service {
    @Override
    public void performService1() {
        System.out.println("实际方法");
    }
    @Override
    public void performService2(String message) {
        System.out.println("实际方法:" + message);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        // 创建真实的服务对象
        Service realService = new RealService();

        // 创建代理对象
        Service proxyService = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        System.out.println("在执行" + method.getName() + "方法之前");
                        try {
                            Object result = method.invoke(realService, args);
                            return result;
                        } catch (Throwable e) { // 捕获潜在的异常
                            throw new RuntimeException(e); // 重新包装异常
                        } finally {
                            System.out.println("在执行" + method.getName() + "方法之后");
                        }
                    }
                }
        );

        // 调用代理对象的方法
        proxyService.performService1();
        proxyService.performService2("hello world");
    }
}
