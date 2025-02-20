package other;
public class CharType {
    public static void main(String[] args) {
        System.out.println(Character.BYTES);
        System.out.println(Character.SIZE);
        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MIN_VALUE);
        String c1 = "😀";
        System.out.println(Character.codePointAt(c1,0));
        System.out.println(Character.codePointAt(c1,1));
        System.out.println(Character.isDigit('1'));
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isLetterOrDigit(' '));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.reverseBytes('a'));
    }
}
