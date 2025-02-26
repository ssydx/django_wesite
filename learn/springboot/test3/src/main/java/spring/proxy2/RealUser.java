package spring.proxy2;

public class RealUser implements UserInterface {
    @Override
    public String getUser() {
        System.out.println("方法");
        return "张三";
    }
}
