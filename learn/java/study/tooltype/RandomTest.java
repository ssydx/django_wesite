package study.tooltype;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r1 = new Random(15);
        System.out.println(r1.nextBoolean());
        System.out.println(r1.nextInt());
        System.out.println(r1.nextLong());
        System.out.println(r1.nextFloat());
        System.out.println(r1.nextDouble());
    }
}
