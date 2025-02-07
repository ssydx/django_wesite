class O1 {
    O1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String name;
    int age;
    @Override
    public String toString() {
        return "姓名：" + name + "，年龄：" + age;
    }
}
final class O2 {
    O2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String name;
    int age;
    @Override
    public String toString() {
        return "姓名：" + name + "，年龄：" + age;
    }
}
abstract class O3 {
    O3(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String name;
    int age;
    @Override
    public String toString() {
        return "姓名：" + name + "，年龄：" + age;
    }
}
class Calc1 {
    private int x;
    private int y;
    Calc1(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int add() {
        return x + y;
    }
    public int sub() {
        return x - y;
    }
    public int pro() {
        return x * y;
    }
    public int div() {
        return x / y;
    }
}
final class Calc2 {
    private Calc2() {}
    public static int add(int x, int y) {
        return x + y;
    }
    public static int sub(int x, int y) {
        return x - y;
    }
    public static int pro(int x, int y) {
        return x * y;
    }
    public static int div(int x, int y) {
        return x / y;
    }
}
class Ticket {
    private String name;
    private int age;
    Ticket(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        if (age < 18) {
            return name + age + 20;
        } else {
            return name + age + 20;
        }
    }
}

public class ToObject {
    public static void main(String[] args) {
        // 默认类
        O1 o1_1 = new O1("ZS", 24);
        System.out.println(o1_1);
        class O1_O1 extends O1 {
            O1_O1(String name, int age, char gender) {
                super(name, age);
                this.gender = gender;
            }
            char gender;
            @Override
            public String toString() {
                return "姓名：" + name + "，年龄：" + age + "，性别：" + gender;
            }
        }
        O1_O1 o1_o1 = new O1_O1("LS", 18, 'F');
        System.out.println(o1_o1);
        // 不可继承类
        O2 o2_1 = new O2("ZS", 24);
        System.out.println(o2_1);
        // 必须继承类
        class O3_O1 extends O1 {
            O3_O1(String name, int age, char gender) {
                super(name, age);
                this.gender = gender;
            }
            char gender;
            @Override
            public String toString() {
                return "姓名：" + name + "，年龄：" + age + "，性别：" + gender;
            }
        }
        O3_O1 o3_o1 = new O3_O1("LS", 18, 'F');
        System.out.println(o3_o1);
        Calc1 c1 = new Calc1(10, 3);
        System.out.println(c1.add());
        System.out.println(c1.sub());
        System.out.println(c1.pro());
        System.out.println(c1.div());
        System.out.println(Calc2.add(10, 3));
        System.out.println(Calc2.sub(10, 3));
        System.out.println(Calc2.pro(10, 3));
        System.out.println(Calc2.div(10, 3));
        Ticket t1 = new Ticket("zs", 17);
        System.out.println(t1);
        Ticket t2 = new Ticket("ls", 32);
        System.out.println(t2);
        System.out.println(t2.getClass());
        System.out.println(t2.getClass().getName());
    }
}
