package 高频考题;

public class 整型溢出 {
    public static void main(String[] args) {
        byte s1 = -5;
        byte s2 = (byte)(~Math.abs(s1) + 1);
        System.out.println(s1 == s2);
        byte s3 = 125; // 0x7D=0b01111101
        byte s4 = 124; // 0x7C=0b01111100
        byte s5 = (byte)(s3 + s4); // 0b00000000111111001 -> 0b111111001 -> 0b11111000 -> 0b10000111 -> -7
        System.out.println(s5);
        byte s6 = (byte)0b111111001;
        byte s7 = (byte)0b10000111;
        System.out.println(s6);
        System.out.println(s7);
        while () {
            
        }
    }
}
