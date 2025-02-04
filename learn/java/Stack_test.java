import java.util.Stack;
public class Stack_test {
    public static void main(String[] args) {
        Stack<Object> s1 = new Stack<Object>();
        System.out.println(s1.empty());
        s1.push("abc");
        s1.push(1);
        s1.push('a');
        s1.push(1.2f);
        System.out.println(s1);
        s1.pop();
        System.out.println(s1);
        System.out.println(s1.peek());
        System.out.println(s1.search("abc"));
    }
}
