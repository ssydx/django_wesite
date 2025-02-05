
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinkedList_test {
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
        System.out.println(l2);
        l3.add('a');
        l3.add(1);
        System.out.println(l1.containsAll(l3));
        LinkedList<Object> l4 = new LinkedList<>();
        l4.add('a');
        l4.add("b");
        l4.add(1);
        System.out.println(l4);
        Iterator<Object> it = l4.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        ListIterator<Object> lit = l4.listIterator();
        while (lit.hasNext()) {
            Object o = lit.next();
            System.out.println(o);
            if (o.equals(1)) {
                lit.set(2);
            }
        }
        System.out.println(l4);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        Spliterator<Integer> spliterator = Arrays.spliterator(numbers);
        // 尝试分割spliterator
        Spliterator<Integer> spliterator1 = spliterator.trySplit();
        // 创建流来消费spliterator
        Stream<Integer> stream1 = StreamSupport.stream(spliterator, false);
        Stream<Integer> stream2 = StreamSupport.stream(spliterator1, false);
        // 并行处理两个流
        stream1.forEach(System.out::println); // 可能输出前半部分
        stream2.forEach(System.out::println); // 可能输出后半部分
    }
}
