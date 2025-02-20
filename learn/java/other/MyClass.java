package other;
import java.util.ArrayList;

/**
 * @author ssydx
 * @category 自定义
 * @version 1.1
 * @deprecated 3.5
 * @since 0.8
 * @see www.baidu.com
*/
public class MyClass {
    private String name;
    private int age;
    public String gender;
    MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + "," + age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    /**
     * 设置名字的方法
     * @param newName 新名字
     * @return 布尔值，设置是否成功
    */
    public boolean setName(String newName) {
        name = newName;
        return true;
    }

}




