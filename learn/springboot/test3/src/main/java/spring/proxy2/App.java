package spring.proxy2;

public class App {
    public static void main(String[] args) {
        UserInterface userServiceInterface = ProxyUser.toProxy(new RealUser());
        System.out.println(userServiceInterface.getUser());
    }
}
