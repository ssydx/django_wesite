package spring.configuration;



public class HelloWorld {
    private String name; 
    HelloWorld() {

    }
    HelloWorld(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println("Hello：" + name);
    }
}
