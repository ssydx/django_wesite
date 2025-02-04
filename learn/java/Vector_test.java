import java.util.Vector;
public class Vector_test {
    public static void main(String[] args) {
        Vector<Object> v1 = new Vector<Object>(); 
        System.out.println(v1.capacity());
        System.out.println(v1);
        v1.add("abc");
        v1.add(0, 1.2f);
        v1.addElement(1);
        System.out.println(v1);
        System.out.println(v1.capacity());
        v1.setSize(25);
        System.out.println(v1.capacity());
        System.out.println(v1);
        System.out.println(v1.get(1));
        System.out.println(v1.firstElement());
        v1.setSize(5);
        v1.trimToSize();
        System.out.println(v1);
        System.out.println(v1.capacity());
        System.out.println(v1.size());
        v1.set(0, "zs");
        System.out.println(v1);
        v1.remove(4);
        v1.remove(null);
        v1.remove(null);
        System.out.println(v1);
    }
}
