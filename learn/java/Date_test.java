import java.util.Date;
public class Date_test {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        Date d2 = new Date(22345555551111l);
        System.out.println(d2);
        System.out.println(d1.before(d2));
    }
}
