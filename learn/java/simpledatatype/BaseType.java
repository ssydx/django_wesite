package simpledatatype;

import tool.PrintFields;
import tool.PrintMethods;

class BooleanType { // 变量名可以是中文字符
    public static final void run() {
        // Boolean构造函数已被废弃

        System.out.println("-".repeat(10) + "声明初始化" + "-".repeat(10));
        // 值类型
        boolean b1 = true;
        // 引用类型，构造函数已被舍弃，实际创建用静态方法
        Boolean b2 = Boolean.valueOf(true);
        // 自动拆箱
        boolean b3 = Boolean.valueOf(true);
        // 自动装箱
        Boolean b4 = true;
        
        System.out.println("-".repeat(10) + "类型转换" + "-".repeat(10));
        // 布尔值类型<->布尔引用类型，自动装拆箱就相当于执行这两个方法
        Boolean Bool1 = Boolean.valueOf(true);
        boolean bool1 = Bool1.booleanValue(); // 实例方法
        // 字符串类型<->布尔引用类型，忽略大小写后等价于true的字符串返回true，否则均返回false
        Boolean Bool2 = Boolean.valueOf("true");
        String str1 = Bool2.toString();
        // 字符串类型<->布尔值类型，忽略大小写后等价于true的字符串返回true，否则均返回false
        boolean bool2 = Boolean.parseBoolean("true");
        String str2 = String.valueOf(bool2); // 字符串的方法
        // String bool3 = Boolean.toString(Bool2); // 发生拆装箱

        System.out.println("-".repeat(10) + "哈希码及相等判定" + "-".repeat(10));
        Boolean Bool4 = Boolean.valueOf(true);
        Boolean Bool5 = Boolean.valueOf(true);
        Boolean Bool6 = Boolean.valueOf(false);
        // 使用valueOf方法时（构造函数则会新建，但其已被抛弃，不应使用）
        // 值为true的布尔对象的哈希码均为1231，false均为1237
        // 本质是指向Boolean类的静态终极属性TRUE和FALSE，而不是新建对象
        System.out.println(Boolean.hashCode(Bool4));
        System.out.println(Bool5.hashCode()); // 实例方法
        System.out.println(Boolean.hashCode(Bool6));
        // 因此自然而然前两者内容也相同，地址相同
        System.out.println(Bool4.equals(Bool5)); // 实例方法
        System.out.println(Bool4 == Bool5);
        // 后两者内容也不相同，地址不相同
        System.out.println(Bool4.equals(Bool6)); // 实例方法
        System.out.println(Bool1 == Bool6);

        System.out.println("-".repeat(10) + "逻辑运算" + "-".repeat(10));
        System.out.println(true && false);
        System.out.println(Boolean.logicalAnd(true, false));
        System.out.println(true || false);
        System.out.println(Boolean.logicalOr(true, false));
        System.out.println(true != false); // 没有直接的逻辑异或运算符，用此替代，或(a || b) && !(a && b)
        System.out.println(Boolean.logicalXor(true, false));
        
        // 更多用在比较器中
        System.out.println("-".repeat(10) + "比较" + "-".repeat(10));
        System.out.println(Boolean.compare(true, false));
        System.out.println(Boolean.valueOf(true).compareTo(Boolean.valueOf(false))); // 实例方法

        System.out.println("-".repeat(10) + "属性" + "-".repeat(10));
        // 通过valueOf创建的对象本质指向了这两个属性
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.FALSE);

        System.out.println("-".repeat(10) + "基本类型boolean的 Class 对象" + "-".repeat(10));
        System.out.println(Boolean.TYPE);

        System.out.println("-".repeat(10) + "系统属性" + "-".repeat(10));
        boolean b = Boolean.getBoolean("myapp.feature.enabled");
        System.out.println(b);

        // public Optional <DynamicConstantDesc <Boolean >> describeConstable()

        System.out.println("-".repeat(10) + "所有公开的属性方法（包括继承的）" + "-".repeat(10));
        PrintFields.print(Boolean.class);
        PrintMethods.print(Boolean.class);

        System.out.println("-".repeat(10) + "已废弃的构造方法" + "-".repeat(10));
        Boolean boolean1 = new Boolean(true);
        Boolean boolean2 = new Boolean(true);
        Boolean boolean3 = new Boolean(false);
        // 虽然哈希码被重写为true都相同，但即使内容相同，地址也不相同
        System.out.println(boolean1.hashCode());
        System.out.println(boolean2.hashCode());
        System.out.println(boolean3.hashCode());
        System.out.println(boolean1 == boolean2);
        System.out.println(boolean1 == boolean3);
        System.out.println(boolean1.equals(boolean2));
        System.out.println(boolean1.equals(boolean3));
    }
}

class IntegerType {
    public static final void run() {
        // 构造函数同废弃

        System.out.println("-".repeat(10) + "声明初始化" + "-".repeat(10));
        // 同Boolean
        int i1 = 10;
        Integer i2 = Integer.valueOf(10);
        int i3 = Integer.valueOf(10);
        Integer i4 = 10;

        System.out.println("-".repeat(10) + "类型转换" + "-".repeat(10));
        // 同Boolean
        Integer Integer1 = Integer.valueOf(10);
        int int1 = Integer1.intValue();
        Integer Integer2 = Integer.valueOf("10");
        String str1 = Integer2.toString();
        int int2 = Integer.parseInt("10");
        String str2 = String.valueOf(int2);
        // String int3 = Integer.toString(Integer2); // 发生拆装箱

        System.out.println("-".repeat(10) + "变基转换" + "-".repeat(10));
        // 字符串类型->整数引用类型（变基）
        // Integer Integer4 = Integer.valueOf("10", 2); // 指定转换基数
        
        // 整数值类型<->字符串类型（变基）
        String str5 = Integer.toString(-10, 2);  // 指定转换基数 "1010"
        int int5 = Integer.parseInt(str5, 2); // 10
        
        // 整数值类型->字符串类型（无符号变基）
        // String str6 = Integer.toBinaryString(10); // 有2 8 16三种类似方法 "1010"

        // 整数值类型<->字符串类型（无符号）
        String str7 = Integer.toUnsignedString(-10);
        int int7 = Integer.parseUnsignedInt(str7);

        // 整数值类型<->字符串类型（无符号变基）
        String str8 = Integer.toUnsignedString(10,2);
        int int8 = Integer.parseUnsignedInt(str8, 2);

        System.out.println("-".repeat(10) + "基元转换" + "-".repeat(10));
        // 扩大基元，通常不需要显式调用，会发生自动转换
        long l1 = Integer.toUnsignedLong(-10); // 例外，无符号扩大需要显式调用该方法
        long l2 = Integer.valueOf(-10).longValue();
        long l3 = Integer.valueOf(-10);
        long l4 = -10;
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);

        // 缩小基元，必须显式调用，相当于强制转换，舍弃高位
        int i = 32700000;
        short s1 = Integer.valueOf(i).shortValue();
        short s2 = (short)i;
        System.out.println(s1);
        System.out.println(s2);
        // 32位二进制字符串
        String str = String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
        System.out.println(str);
        // 截断
        String substr = str.substring(16);
        System.out.println(substr);
        // 按位取反
        StringBuffer strbuf1 = new StringBuffer();
        for (char c: substr.toCharArray()) {
            if (c == '0') {
                strbuf1.append('1');
            } else {
                strbuf1.append('0');
            }
        }
        System.out.println(strbuf1);
        // 加1
        StringBuffer strbuf2 = new StringBuffer();
        int add = 1;
        for (int k = strbuf1.toString().length() - 1; k >= 0; k--) {
            if (add == 1) {
                if (strbuf1.charAt(k) == '1') {
                    strbuf2.insert(0, '0');
                } else {
                    strbuf2.insert(0, '1');
                    add = 0;
                }
            } else {
                strbuf2.insert(0, strbuf1.charAt(k));
            }
        }
        System.out.println(strbuf2);
        // 删除前导0，不删除也行
        String bstr1 = strbuf2.toString().replaceFirst("^0*", "");
        System.out.println(bstr1);
        // 添加符号位
        String bstr2 = (substr.startsWith("1") ? "-": "") + bstr1;
        System.out.println(bstr2);
        // 转为short
        short s = Short.parseShort(bstr2, 2);
        System.out.println(s);

        System.out.println("-".repeat(10) + "哈希码及相等判定" + "-".repeat(10));
        // 同Boolean
        Integer Integer5 = Integer.valueOf(10);
        Integer Integer6 = Integer.valueOf(10);
        Integer Integer7 = Integer.valueOf(20);
        System.out.println(Integer5.hashCode());
        System.out.println(Integer.hashCode(Integer6));
        System.out.println(Integer7.hashCode());
        System.out.println(Integer5.equals(Integer6));
        System.out.println(Integer5 == Integer6);
        System.out.println(Integer5.equals(Integer7));
        System.out.println(Integer5 == Integer7);

        System.out.println("-".repeat(10) + "数学运算" + "-".repeat(10));
        System.out.println(Integer.signum(-10)); // 0：0 正：1 负：-1
        System.out.println(Integer.max(10, 20));
        System.out.println(Integer.min(10, 20));
        System.out.println(Integer.sum(10, 20));
        System.out.println(Integer.divideUnsigned(-11, 3));
        System.out.println(Integer.remainderUnsigned(-11, -3));

        System.out.println("-".repeat(10) + "位运算" + "-".repeat(10));
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.bitCount(7)); // 二进制中1的个数
        System.out.println(Integer.lowestOneBit(7)); // 二进制中最低位对应的十进制值
        System.out.println(Integer.highestOneBit(7)); // 二进制中最高位对应的十进制值，右侧均视为0
        System.out.println(Integer.numberOfLeadingZeros(7)); // 前导0的个数
        System.out.println(Integer.numberOfTrailingZeros(7)); // 后随0的个数
        System.out.println(Integer.reverse(7));
        System.out.println(Integer.reverseBytes(7));
        System.out.println(Integer.rotateLeft(7, 1)); // 从左侧移出的从右侧进入
        System.out.println(Integer.rotateRight(7, 1)); // 从右侧移出的从左侧进入

        // 比较函数
    }
}

class ByteAndShortAndLong {
    public static final void run() {
        // 构造函数同废弃

        // Long基本类同Integer
        /* 
        Short没有位运算相关的方法，除reverseBytes
        也没有变基转换方法，除valueOf(String s, int radix) parseShort(String s, int radix)
        也没有数学运算的相关方法
        */ 
        /* 
        Byte没有位运算相关的方法
        也没有变基转换方法，除valueOf(String s, int radix) parseShort(String s, int radix)
        也没有数学运算的相关方法
        */ 
        System.out.println("-".repeat(10) + "所有方法等" + "-".repeat(10));
        Class<?>[] nums = {Byte.class,Short.class,Integer.class,Long.class,Float.class,Double.class};
        for (Class<?> number : nums) {
            try {
                System.out.printf(
                    "%1$-10s %2$-10s %3$-10s %4$-30s %5$-30s\n",
                    number.getSimpleName(),
                    number.getField("BYTES").get(null),
                    number.getField("SIZE").get(null),
                    number.getField("MAX_VALUE").get(null),
                    number.getField("MIN_VALUE").get(null)
                );
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PrintMethods.print(Byte.class);
        PrintMethods.print(Short.class);
        PrintMethods.print(Long.class);
    }
}

class DoubleAndFloatType {
    public static final void run() {
        // 构造函数同废弃

        /* 
        Double没有位运算相关的方法
        也没有变基转换方法，除toHexString(double d)
        有数学运算的相关方法（sum min max）
        相等比较同Boolean
        比较器同Boolean
        */ 
        System.out.println("-".repeat(10) + "特有方法" + "-".repeat(10));
        double d1 = 10.0;
        Double d2 = Double.valueOf(10.0);
        // 0.0/0.0，无穷大/无穷大，负数的平方根，负对数，类型转换失败
        System.out.println(Double.isNaN(d1));
        System.out.println(d2.isNaN());
        System.out.println(Double.isFinite(d1));
        System.out.println(Double.isInfinite(d1));
        System.out.println(d2.isInfinite());
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NaN);

        // Float基本等同Double
    }
}

class 数字补充 {
    public static final void run() {
        System.out.println("-".repeat(10) + "补充内容" + "-".repeat(10));
        // int i1 = null;
        Integer i2 = null;
        // null == null
        System.out.println(null == null);
        // NaN != NaN
        System.out.println(0.0/0 == 0.0/0);

        // 后缀
        // 默认为int
        System.out.println(1 instanceof Integer);
        System.out.println(1L instanceof Long);
        // 默认为double
        System.out.println(1.0f instanceof Float);
        System.out.println(1.0 instanceof Double);

        // 前缀
        int[] arr = {10,0b10,0B10,070,0xf0,0xF0};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

class CharacterType {
    public static final void run() {
        System.out.println("-".repeat(10) + "字符" + "-".repeat(10));
        // 不支持空字符
        // char c1 = '';
        char c1 = 'a';
        Character c2 = Character.valueOf('a');

        Character Char1 = Character.valueOf('a');
        char char1 = Char1.charValue();

        // Character Char2 = Character.valueOf("a");
        String str1 = Character.toString('a');

        // char char2 = Character.parseChar('a');
        String str2 = String.valueOf('a');

        System.out.println(Character.BYTES);
        System.out.println(Character.SIZE);
        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.MAX_VALUE);
        char char3 = Character.reverseBytes('a');
        System.out.println(char3);

        System.out.println("-".repeat(10) + "字符常用方法" + "-".repeat(10));
        int i = (int)'a';
        System.out.println(i);
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isLetterOrDigit('a'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.isSpaceChar('a'));
        System.out.println(Character.isWhitespace('a'));
        System.out.println(Character.toLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
    }
}

public class BaseType {
    public static void main(String[] args) {
        // BooleanType.run();
        // IntegerType.run();
        // ByteAndShortAndLong.run();
        // DoubleAndFloatType.run();
        // 数字补充.run();
        CharacterType.run();
    }
}
