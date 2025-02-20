package other;
public class NumberType {
    public static void main(String[] args) {
        System.out.println(Byte.BYTES);
        System.out.println(Byte.SIZE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.TYPE);
        Byte b1 = Byte.valueOf("12");
        byte b2 = b1.byteValue();
        String b3 = b1.toString();
        String b4 = Byte.toString(b2);
        short b5 = b1.shortValue();
        int b6 = b1.intValue();
        long b7 = b1.longValue();
        float b8 = b1.floatValue();
        double b9 = b1.doubleValue();
        int h1 = b1.hashCode();
        int h2 = Byte.hashCode(b2);
        System.out.println(b1 instanceof Byte);
        System.out.println(b2 instanceof Byte);
        System.out.println(b3 instanceof String);
        System.out.println(b4 instanceof String);
        System.out.println(b5 instanceof Short);
        System.out.println(b6 instanceof Integer);
        System.out.println(b7 instanceof Long);
        System.out.println(b8 instanceof Float);
        System.out.println(b9 instanceof Double);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(Byte.compare((byte)12,(byte)-15));
        System.out.println(Byte.valueOf((byte)12).compareTo(Byte.valueOf((byte)13)));
        System.out.println(Byte.compareUnsigned((byte)12,(byte)-15));
        System.out.println(Byte.compareUnsigned((byte)12,(byte)(256-15)));
        System.out.println(Byte.toUnsignedInt((byte)-15));
        System.out.println(Byte.toUnsignedLong((byte)-15));
        System.out.println(Integer.bitCount(256));
        System.out.println(Integer.highestOneBit(255));
        System.out.println(Integer.lowestOneBit(256));
        System.out.println(Integer.numberOfLeadingZeros(255));
        System.out.println(Integer.numberOfTrailingZeros(256));
        System.out.println(Integer.reverse(256));
        System.out.println(Integer.reverseBytes(256));
        System.out.println(Integer.signum(-255));
        System.out.println(Integer.toBinaryString(255));
        System.out.println(Integer.toOctalString(255));
        System.out.println(Integer.toHexString(255));
        System.out.println(Integer.rotateLeft(255, 4));
        class InnerNumberType {
            public static int rotateLeft(int i,int distance) {
                return Integer.parseInt(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0').repeat(2).substring(distance, distance + 32),2);
            }
        }
        System.out.println(InnerNumberType.rotateLeft(255, 4));
        System.out.println(Integer.toString(-255, 2));
        System.out.println(Integer.toUnsignedString(-255, 2));
        System.out.println(Float.BYTES);
        System.out.println(Float.SIZE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_EXPONENT);
        System.out.println(Float.MIN_EXPONENT);
        System.out.println(Float.MIN_NORMAL);
        System.out.println(Float.NaN);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Float.floatToIntBits(23456.345f));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(23456.345f)));
        System.out.println(Float.intBitsToFloat(1186414769));
        System.out.println(1.2);
    }
}
