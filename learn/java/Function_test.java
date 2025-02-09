
public class Function_test {
    @FunctionalInterface 
    public interface test {
        public void name();
    }
    public static void main(String[] args) {
        test t1 = () -> System.out.println("hello world");
        t1.name();
    }
}
