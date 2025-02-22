package study.otherdatatype;
import java.util.Arrays;

public class EnumTest {
    public enum Day1 {
        SPRING,SUMMER,FALLEN,WINTER
    }
    public enum Day2 {
        SPRING("春天"),
        SUMMER("春天"),
        FALLEN("春天"),
        WINTER("春天");
        private String readable;
        private Day2(String readable) {
            this.readable = readable;
        }
        public String getName() {
            return readable;
        }
    }
    public static void main(String[] args) {
        System.out.println(Day1.FALLEN);
        System.out.println(Day1.values());
        System.out.println(Arrays.toString(Day2.values()));
        System.out.println(Day2.FALLEN.getName());
    }   
}
