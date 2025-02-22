package complexdatatype;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import tool.PrintMethods;



class LinkedListTest {
    public static final void run() {
        LinkedList<String> ll = new LinkedList<String>();
        System.out.println(ll);
        System.out.println(ll.isEmpty());
        
        ll.add("end");
        ll.addLast("end1");
        ll.addFirst("start1");
        ll.add(2, "center1");
        ll.addAll(1,ll);
        ll.push("front");
        System.out.println(ll);
        System.out.println(ll.size());

        System.out.println("head:" + ll.element());
        System.out.println("head:" + ll.get(3));
        System.out.println("head:" + ll.getFirst());
        System.out.println("tail:" + ll.getLast());
        System.out.println("firstindex:" + ll.indexOf("front"));
        System.out.println("lastindex:" + ll.lastIndexOf("front"));
        System.out.println("contains:" + ll.contains("front"));

        ll.remove();
        ll.removeFirst();
        ll.removeLast();
        ll.remove("center1");
        ll.removeFirstOccurrence("head1");
        ll.removeLastOccurrence("end");
        ll.remove(0);
        // ll.removeAll();
        // ll.retainAll();
        // ll.removeIf();
        ll.pop();

        ll.set(0, "new1");
        // ll.replaceAll();
        


        ll.offer("tail");
        ll.offerFirst("head1");
        ll.offerLast("tail1");
        System.out.println(ll);
        System.out.println(ll.size());

        System.out.println("head:" + ll.peek());
        System.out.println("head:" + ll.peekFirst());
        System.out.println("tail:" + ll.peekLast());

        ll.poll();
        ll.pollFirst();
        ll.pollLast();

        System.out.println(Arrays.toString(ll.toArray()));

        System.out.println(ll.stream().count());

        System.out.println(ll.reversed());

        ll.forEach(e -> System.out.println(e));

        ll.clear();

    }
}

class HashSetTest {
    public static final void run() {
        HashSet<String> set = new HashSet<String>();
        System.out.println(set);
        System.out.println(set.isEmpty());
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        set.addAll(set);
        System.out.println(set.size());
        System.out.println(set);

        System.out.println(set.contains("a"));
        System.out.println(set.containsAll(set));

        set.remove("a");
        // set.removeAll();
        // set.retainAll();
        // set.removeIf();

        set.stream().forEach(e -> System.out.println(e));

        System.out.println(Arrays.toString(set.toArray()));

        set.forEach(e -> System.out.println(e));

        set.clear();

    }
}

class HashMapTest {
    public static final void run() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(map.isEmpty());
        System.out.println(map);

        map.put("zs", 1);
        map.put("ls", 2);
        map.put("ww", 1);
        map.put("zs", 3); // 重复键会替换原键值对，返回旧值
        map.putIfAbsent("ss", 12); // 键不存在或键对应的值为null则插入，否则不变
        map.putAll(map);
        System.out.println(map.size());
        System.out.println(map);

        System.out.println(map.get("zs"));
        System.out.println(map.getOrDefault("ss", 10));
        System.out.println(map.containsKey("zs"));
        System.out.println(map.containsValue(3));

        map.remove("ls");
        map.remove("zs", 1); // 键值都匹配才可以
        System.out.println(map.size());
        System.out.println(map);

        map.replace("ss", 5); // 键存在且有值时替换为新值
        map.replace("zs", 5, 10); // 键值对匹配时替换值
        // map.replaceAll();

        map.forEach((k,v)->System.out.println(k));

        map.merge("ss", 1, (oldv,newv) -> oldv + newv); // 指定的键如果存在，在函数中处理旧值和指定的新值
        System.out.println(map);

        // 比较绕
        map.compute("zs", (key,e) -> e * e); // 键存在则第二参数为原值，不存在则为null，函数返回值如果为null则删除键值对，否则加入映射
        System.out.println(map);
        // map.computeIfAbsent(null, null);
        // map.computeIfPresent(null, null);

        System.out.println(map.keySet()); // Set
        System.out.println(map.values()); // Collection
        System.out.println(map.entrySet());

        Set<HashMap.Entry<String,Integer>> set = map.entrySet();
        for (HashMap.Entry<String,Integer> entry : set) {
            System.out.println(entry);
        }

    }
}

public class ContainerTest {
    public static void main(String[] args) {
        // 双向循环链表
        // LinkedListTest.run();
        // 哈希集合
        // HashSetTest.run();
        // 哈希映射
        // HashMapTest.run();


    }
}
