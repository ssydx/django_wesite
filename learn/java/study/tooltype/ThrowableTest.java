package study.tooltype;
public class ThrowableTest {
    public static void main(String[] args) {
        try {
            int[] arr = {1,2,3,4,5};
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
            System.out.println(e.getClass());
            System.out.println(e.getSuppressed());
            System.out.println(e.getStackTrace());
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();
        }
    }
}
