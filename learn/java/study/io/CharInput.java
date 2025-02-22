package study.io;

import java.io.FileReader;

class FileReader_test {
    public static final void run() {
        try (FileReader f = new FileReader("D://字节输出流-字符流.txt")) {
            System.out.println(f.ready());
            System.out.println(f.getEncoding());
            f.skip(3);
            System.out.println((char)f.read());
            char[] carr = new char[1024];
            int len = f.read(carr, 0, 16);
            System.out.println(carr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// BufferedReader

public class CharInput {
    public static void main(String[] args) {
        FileReader_test.run();
    }
}
