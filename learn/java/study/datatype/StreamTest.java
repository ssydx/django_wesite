package study.datatype;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("孙悟空");
        ll.add("唐僧");
        ll.add("猪八戒");
        ll.add("沙和尚");
        ll.add("孙悟空");
        ll.add("白骨精");
        ll.add("菩提祖师");
        ll.add("如来");
        ll.add("玉帝");
        ll.add("太上老君");
        System.out.println(ll);
        // count
        Stream<String> ss1 = ll.stream();
        System.out.println(ss1.count());
        // distinct
        Stream<String> ss2 = ll.stream();
        System.out.println(ss2.distinct().toList());
        // sort
        Stream<String> ss3 = ll.stream();
        System.out.println(ss3.sorted().collect(Collectors.toList()));
        // limit
        Stream<String> ss4 = ll.stream();
        System.out.println(Arrays.toString(ss4.limit(3).toArray()));
        // offset
        Stream<String> ss5 = ll.stream();
        System.out.println(ss5.skip(2).collect(Collectors.toSet()));
        // where
        Stream<String> ss6 = ll.stream();
        System.out.println(ss6.filter(e -> e.length() > 2).toList());

        Stream<String> ss7 = ll.stream();
        System.out.println(ss7.sorted((a,b) -> Integer.compare(a.length(),b.length())).dropWhile(e -> e.length() <= 2).toList());

        Stream<String> ss8 = ll.stream();
        System.out.println(ss8.sorted((a,b) -> Integer.compare(a.length(),b.length())).takeWhile(e -> e.length() <= 3).toList());

        Stream<String> ss9 = ll.stream();
        System.out.println(ss9.peek(e -> System.out.println(e)).toList());

        Stream<String> ss10 = ll.stream();
        ss10.forEach(System.out::println);

        Stream<String> ss11 = ll.stream();
        System.out.println(ss11.allMatch(e -> e.length() > 3));

        Stream<String> ss12 = ll.stream();
        System.out.println(ss12.anyMatch(e -> e.length() > 3));

        Stream<String> ss13 = ll.stream();
        System.out.println(ss13.noneMatch(e -> e.length() > 3));

        Stream<String> ss14 = ll.stream();
        System.out.println(ss14.max((a,b) -> Integer.compare(a.length(), b.length())));

        Stream<String> ss15 = ll.stream();
        System.out.println(ss15.min((a,b) -> Integer.compare(a.length(), b.length())));

        Stream<String> ss16 = ll.stream();
        System.out.println(ss16.findFirst());

        Stream<String> ss17 = ll.stream();
        System.out.println(ss17.findAny());

        Stream<String> ss18 = ll.stream();
        System.out.println(ss18.map(e -> "姓名：" + e).toList());

        Stream<String> ss19 = ll.stream();
        System.out.println(ss19.reduce((a,b) -> a + b));



        // sequential()
        // close()
        // gather()



        int[] iarr = {3,10,34,2,132,45,23};
        IntStream is1 = Arrays.stream(iarr,1,5);
        System.out.println(is1.average());
        IntStream is2 = Arrays.stream(iarr);
        System.out.println(is2.max());
        IntStream is3 = IntStream.of(iarr);
        System.out.println(is3.min());
        
        
    }
}
