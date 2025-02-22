package study.datatype;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

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

        System.out.println(ll.reversed());

        ll.forEach(e -> System.out.println(e));

        System.out.println(ll.stream().count());

        System.out.println(ll);
        Collections.sort(ll);
        System.out.println(ll);
        Collections.sort(ll, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println(ll);
        ll.sort((a, b) -> Integer.compare(b.length(), a.length()));
        System.out.println(ll);

        System.out.println(ll.subList(0, 1));

        ll.clear();

    }
}

class ArrayListTest {
    public static final void run() {
        ArrayList<String> al = new ArrayList<String>();
        System.out.println(al.isEmpty());

        al.add("A");
        al.addLast("b");
        al.addFirst("c");
        al.add(1, "D");
        al.addAll(2, al);
        System.out.println(al.size());
        System.out.println(al);

        System.out.println(al.get(4));
        System.out.println(al.getFirst());
        System.out.println(al.getLast());
        System.out.println(al.contains("b"));
        System.out.println(al.containsAll(al));
        System.out.println(al.indexOf("b"));
        System.out.println(al.lastIndexOf("b"));
        
        al.remove(3);
        al.remove("b");
        al.removeFirst();
        al.removeLast();
        // al.removeAll();
        // al.retainAll();
        // al.removeIf();
        System.out.println(al.size());
        System.out.println(al);

        al.set(2, "zs");
        // al.replaceAll();
        
        System.out.println(Arrays.toString(al.toArray()));

        System.out.println(al.reversed());

        System.out.println(al.stream().count());

        al.forEach(System.out::println);

        Collections.sort(al);
        System.out.println(al);
        Collections.sort(al,String.CASE_INSENSITIVE_ORDER);
        System.out.println(al);
        al.sort((a,b) -> a.compareTo(b));
        System.out.println(al);

        System.out.println(al.subList(0, 2));

        // al.ensureCapacity(0);
        // al.trimToSize();

        al.clear();


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

        // set.newHashSet();

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
        map.merge("ss", 1, (oldv,newv) -> oldv + newv); // 指定的键如果存在，在函数中处理旧值和指定的新值
        System.out.println(map);

        map.forEach((k,v)->System.out.println(k));

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

        map.clear();

    }
}

class ArrayDequeTest {
    public static final void run() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        PrintMethods.print(ArrayDeque.class);
    }
}

class VectorTest {
    public static final void run() {
        Vector<Integer> v = new Vector<Integer>();
        System.out.println(v.isEmpty());

        v.add(1);
        v.addFirst(2);
        v.addLast(3);
        v.addElement(4);
        v.addAll(0, v);
        System.out.println(v.size());
        System.out.println(v.capacity());
        System.out.println(v);

        System.out.println(v.elementAt(3));
        System.out.println(v.firstElement());
        System.out.println(v.lastElement());
        System.out.println(v.get(4));
        System.out.println(v.getFirst());
        System.out.println(v.getLast());
        System.out.println(v.elements());
        System.out.println(v.contains(3));
        System.out.println(v.containsAll(v));
        System.out.println(v.indexOf(3));
        System.out.println(v.indexOf(3,3));
        System.out.println(v.lastIndexOf(3));
        System.out.println(v.lastIndexOf(3,3));

        v.remove(1);
        v.removeElementAt(1);
        v.remove(Integer.valueOf(2));
        v.removeElement(2);
        v.removeFirst();
        v.removeLast();
        // v.removeAll();
        // v.removeAllElements();
        // v.retainAll();
        // v.removeIf();
        System.out.println(v);

        v.set(1, 3);
        v.setElementAt(5, 1);
        v.insertElementAt(3, 2);
        // v.replaceAll();
        System.out.println(v);

        System.out.println(Arrays.toString(v.toArray()));

        System.out.println(v.reversed());

        System.out.println(v.stream().count());

        v.forEach(System.out::println);

        Collections.sort(v);
        System.out.println(v);
        Collections.sort(v, (a,b) -> Integer.compare(b, a));
        System.out.println(v);
        v.sort((a, b) -> Integer.compare(a, b));
        System.out.println(v);

        System.out.println(v.subList(0, 2));

        // v.copyInto(null);
        // v.ensureCapacity(0);
        // v.setSize(0);
    }
}

class StackTest {
    public static final void run() {
        Stack<String> s = new Stack<String>();
        System.out.println(s.isEmpty());

        s.push("zs");
        s.push("ls");
        System.out.println(s.size());
        System.out.println(s);

        System.out.println(s.peek());

        s.pop();
        System.out.println(s);

        PrintMethods.print(Stack.class);
    }
}

class TreeSetTest {
    public static final void run() {
        TreeSet<String> ts = new TreeSet<String>();
        System.out.println(ts.isEmpty());

        ts.add("a");
        ts.add("A");
        ts.add("B");
        ts.add("b");
        ts.add("c");
        ts.add("a");
        ts.add("d");
        ts.add("e");
        ts.add("f");
        ts.addAll(ts);
        System.out.println(ts.size());
        System.out.println(ts);

        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.getFirst());
        System.out.println(ts.getLast());
        System.out.println(ts.contains("a"));
        System.out.println(ts.containsAll(ts));
        System.out.println(ts.ceiling("b"));
        System.out.println(ts.floor("b"));
        System.out.println(ts.higher("b"));
        System.out.println(ts.lower("b"));
        System.out.println(ts.headSet("b"));
        System.out.println(ts.tailSet("b"));
        System.out.println(ts.headSet("b",true));
        System.out.println(ts.tailSet("b",false));

        ts.remove("a");
        ts.removeFirst();
        ts.removeLast();
        // ts.removeAll();
        // ts.retainAll();
        // ts.removeIf();
        ts.pollFirst();
        ts.pollLast();
        System.out.println(ts.size());
        System.out.println(ts);

        System.out.println(Arrays.toString(ts.toArray()));

        System.out.println(ts.reversed());

        ts.forEach(System.out::println);

        System.out.println(ts.stream().count());

        System.out.println(ts.subSet("c", "g"));
        System.out.println(ts.subSet("c", false, "g", false));

        // ts.comparator();

        ts.clear();
        

    }
}

class TreeMapTest {
    public static final void run() {
        TreeMap<String, Integer> tm = new TreeMap<String,Integer>();
        System.out.println(tm.isEmpty());

        tm.put("a", 1);
        tm.put("b", 2);
        tm.put("c", 3);
        tm.put("A", 10);
        tm.put("d", null);
        tm.put("f", null);
        // tm.putAll(tm);
        // tm.putIfAbsent(null, null);
        // tm.compute(null, null);
        // tm.computeIfAbsent(null, null);
        // tm.computeIfPresent(null, null);
        System.out.println(tm.size());
        System.out.println(tm);

        System.out.println(tm.get("a"));
        System.out.println(tm.getOrDefault("f", 10));
        System.out.println(tm.containsKey("a"));
        System.out.println(tm.containsValue(3));
        System.out.println(tm.firstKey());
        System.out.println(tm.firstEntry());
        System.out.println(tm.lastKey());
        System.out.println(tm.lastEntry());
        System.out.println(tm.ceilingKey("b"));
        System.out.println(tm.ceilingEntry("b"));
        System.out.println(tm.floorKey("b"));
        System.out.println(tm.floorEntry("b"));
        System.out.println(tm.higherKey("b"));
        System.out.println(tm.higherEntry("b"));
        System.out.println(tm.lowerKey("b"));
        System.out.println(tm.lowerEntry("b"));
        System.out.println(tm.headMap("b"));
        System.out.println(tm.headMap("b",true));
        System.out.println(tm.tailMap("b"));
        System.out.println(tm.tailMap("b",false));

        tm.remove("f");
        tm.remove("a", 1);
        tm.pollFirstEntry();
        tm.pollLastEntry();
        System.out.println(tm.size());
        System.out.println(tm);

        // tm.replace(null, null);
        // tm.replace(null, null, null);
        // tm.replaceAll(null);
        // tm.merge(null, null, null);

        // tm.comparator();
        
        tm.forEach((key, value) -> System.out.println(value));

        System.out.println(tm.keySet());
        System.out.println(tm.values());
        System.out.println(tm.entrySet());
        System.out.println(tm.sequencedKeySet());
        System.out.println(tm.sequencedValues());
        System.out.println(tm.sequencedEntrySet());
        System.out.println(tm.descendingKeySet());
        System.out.println(tm.descendingMap());
        // System.out.println(tm.subMap(null, null));
        // System.out.println(tm.subMap(null, false, null, false));
        System.out.println(tm.navigableKeySet());

        System.out.println(tm.reversed());

        tm.clear();

    }
}

class OtherTest {
    public static final void run() {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        System.out.println(ht.isEmpty());
        ht.put("zs", 1);
        ht.put("ls", 2);
        System.out.println(ht.size());
        System.out.println(ht);
        System.out.println(ht.get("zs"));
        System.out.println(ht.containsKey("zs"));
        ht.remove("zs");
        System.out.println(ht.size());
        System.out.println(ht);
        ht.replace("ls", 5);
        System.out.println(ht.size());
        System.out.println(ht);
        ht.clear();

        int cnt = 100;
        BitSet bs = new BitSet(cnt);
        for (int i = 2; i < cnt; i++) {
            if (!bs.get(i)) { // 如果i没有被标记为非质数
                System.out.print(i + " "); // 输出质数
                // 标记所有i的倍数为非质数
                for (int j = i * i; j < cnt; j += i) {
                    bs.set(j);
                }
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<String>();
        System.out.println(pq.isEmpty());
        pq.add("A");
        pq.add("d");
        pq.add("a");
        pq.add("b");
        System.out.println(pq.size());
        System.out.println(pq);
        System.out.println(pq.element());
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);

    }
}

public class ContainerTest {
    public static void main(String[] args) {
        // 双向循环链表
        // LinkedListTest.run();
        // 动态数组列表
        // ArrayListTest.run();
        // 哈希集合
        // HashSetTest.run();
        // 哈希映射
        // HashMapTest.run();

        // VectorTest.run();
        // StackTest.run();
        // ArrayDequeTest.run();

        // 有序集合
        // TreeSetTest.run();
        // 有序映射
        // TreeMapTest.run();

        OtherTest.run();

    }
}
