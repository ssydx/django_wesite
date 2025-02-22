package study.io;

import java.io.FileWriter;

class FileWriter_test {
    public static final void run() {
        // 新建
        try (FileWriter f = new FileWriter("D://字符输出流-字符流.txt")) {
            f.write("abc一二三");
            f.write("这是一段话\n");
            f.append("aaaa\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 追加
        try (FileWriter f = new FileWriter("D://字符输出流-字符流.txt",true)) {
            f.write("abc一二三");
            f.write("这是一段话\n");
            f.append("aaaa\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class CharOutput {
    public static void main(String[] args) {
        FileWriter_test.run();
    }
}
