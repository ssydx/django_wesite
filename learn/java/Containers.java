import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
public class Containers {
    public static void main(String[] args) {
        LinkedList<Object> l1 = new LinkedList<>();
        // l1.remove();
        System.out.println(l1.poll());
        l1.add("zs");
        l1.offer("ls");
        l1.add("ww");
        System.out.println(l1);
        System.out.println(l1.element());
        System.out.println(l1.getLast());
        l1.addFirst(1);
        l1.offerFirst('a');
        System.out.println(l1);
        System.out.println(l1.peek());
        System.out.println(l1.peekLast());
        System.out.println(l1.size());
        l1.set(4, 'a');
        System.out.println(l1);
        System.out.println(l1.contains('a'));
        System.out.println(l1.indexOf('a'));
        System.out.println(l1.lastIndexOf('a'));
        Object l2 = l1.clone();
        System.out.println(l2);
        // 哈希码相同未必意味着对象内容相同
        System.out.println(l2.hashCode());
        System.out.println(l1.hashCode());
        // 直接比较的是地址
        System.out.println(l2 == l1);
        // 比较的是内容
        System.out.println(l2.equals(l1));
        // 强转后才能使用链表方法
        LinkedList<Object> l3 = (LinkedList<Object>) l1.clone();
        System.out.println(l3 == l1);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        l3.clear();
        System.out.println(l3);
        // 自动拆箱
        System.out.println('a' == Character.valueOf('a'));
        // 显式调用
        System.out.println(Arrays.toString(l1.toArray()));
        l1.addAll((LinkedList<Object>)l2);
        System.out.println(l1);
    }
}
