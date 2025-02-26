package spring.dependency;

public class Department {
    private String name;
    private String boss;
    public Department(String name,String boss) {
        this.name = name;
        this.boss = boss;
    }
    public String toString() {
        return name + " " + boss;
    }
}
