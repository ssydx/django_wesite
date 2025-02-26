package spring.proxy1;

public class realUser {
    private String name;
    public realUser() {
        System.out.println("无参初始化对象");
    }
    public realUser(String name) {
        System.out.println("有参初始化对象");
        this.name = name;
    }
    public void setName(String name) {
        System.out.println("设置姓名");
        this.name = name;
    }
    public String getName() {
        System.out.println("获得姓名");
        return name;
    }
    public void print() {
        System.out.println("原对象");
    }
}
