package complexdatatype;
class BookInfo<T> {
    private T bookinfo;
    BookInfo(T bookinfo) {
        this.bookinfo = bookinfo;
    }
    public T getBookinfo() {
        return bookinfo;
    }
}
public class 泛型 {

    public static void main(String[] args) {
        BookInfo<String> b1 = new BookInfo<String>("abc");
        System.out.println(b1.getBookinfo());
        BookInfo<Character> b2 = new BookInfo<Character>('a');
        System.out.println(b2.getBookinfo());
    }
}
