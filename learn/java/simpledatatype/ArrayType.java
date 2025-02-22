package simpledatatype;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class ArrayType {
    public static void main(String[] args) {
        // 需要进一步探索

        int[] iarr1 = new int[3];
        int[] iarr2 = {1,2,3};
        int[] iarr3 = new int[]{1,2,3};
        int[] iarr4;
        System.out.println(Arrays.toString(iarr1));
        System.out.println(Arrays.toString(iarr2));
        System.out.println(Arrays.toString(iarr3));
        // System.out.println(Arrays.toString(iarr4));
        System.out.println(Arrays.toString(new int[3]));
        // System.out.println(Arrays.toString({1,2,3})); // 注意此种方式并不能创建数组对象
        System.out.println(Arrays.toString(new int[]{1,2,3}));

        // 多维数组可以先仅指定较高维度，但后续必须通过显式或隐式方式指定低维度
        int[][] darr = new int[3][];
        int[][] darr2 = new int[][]{{1,2},{1,2,3}};
        darr[0] = new int[3];
        darr[1] = new int[]{1,2,3};
        // 字面量只能在声明时单独使用或结合new使用
        // darr[2] = {1,2,3};
        System.out.println(darr[0][0]);
        System.out.println(darr[1][0]);

        int[] arr1 = {1,2,3,4,5};
        System.out.println(Arrays.hashCode(arr1));
        // 复制
        System.out.println(Arrays.toString(Arrays.copyOf(arr1, 3)));
        System.out.println(Arrays.toString(Arrays.copyOf(arr1, 10)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr1, 3, 5)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr1, 3, 10)));
        int[] arr2 = {1,2,3,4,5};
        // 相等判定
        System.out.println(Arrays.equals(arr1, arr2));
        // 填充
        Arrays.fill(arr2, 0, 3,5);
        System.out.println(Arrays.toString(arr2));
        // 不匹配
        arr2[0] = 1;
        arr2[1] = 2;
        System.out.println(Arrays.mismatch(arr1, arr2));
        // 映射
        Arrays.setAll(arr2, i -> {
            if (arr2[i] > 3) {
                return 5;
            } else {
                return 1;
            }
        });
        System.out.println(Arrays.toString(arr2));
        // 二进制查找
        System.out.println(Arrays.binarySearch(arr1, 0,3,2));
        // 排序
        int[] arr3 = {5,4,3,2,1};
        Arrays.sort(arr3,0,3);
        System.out.println(Arrays.toString(arr3));
        // 转列表，修改会被同步，支持引用类型数组，参数列表
        Integer[] arr4 = {5,4,3,2,1};
        List<Integer> ls1 = Arrays.asList(arr4);
        ls1.replaceAll(e -> e + 1);
        System.out.println(ls1);
        System.out.println(Arrays.toString(arr4));
        List<Integer> ls2 = Arrays.asList(1,2,3);
        System.out.println(ls2);
        // 流，详见流
        IntStream s1 = Arrays.stream(arr1);
        s1.forEach(e -> System.out.println("流：" + e));
        Stream<Integer> s2 = Arrays.stream(arr4);
        System.out.println(s2.count());
        // 累积
        int[] arr5 = {5,4,3,2,1};
        Arrays.parallelPrefix(arr5, 0, 3, (a,b) -> a + b);
        System.out.println(Arrays.toString(arr5));
        // 比较
        Integer[] arr6 = {1,2,3,4,5};
        Integer[] arr7 = {1,2,3,4,5};
        System.out.println(Arrays.compare(arr6, 1, 4, arr7, 1, 4, (a,b) -> a - b));
    }
}
