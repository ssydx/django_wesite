package io_test;

import java.io.FileOutputStream;

class FileOutputStream_test {
    public static final void run() {
        // 有则删除，无则新建
        try (FileOutputStream f = new FileOutputStream("D://字节输出流-字节流.txt")) {
            String s = """
                    这个抽象类是表示字节输出流的所有类的超类。输出流接受输出字节并将它们发送到某个接收器。
                    需要定义 OutputStream 子类的应用程序必须始终至少提供一种写入一个字节输出的方法。""";
            byte[] barr = s.getBytes();
            f.write(barr);
            byte[] barr1 = "abcABC123\n".getBytes();
            f.write(barr1);
            byte[] barr2 = "AB😀(*^_^*)".getBytes();
            f.write(barr2, 2, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 有则追加，无则新建
        try (FileOutputStream f = new FileOutputStream("D://字节输出流-字节流.txt", true)) {
            byte[] barr = "程序运行之后会向D盘根目录下的word.txt文件写入3行文字，并且会在控制台输出如下信息\n".getBytes();
            f.write(barr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class ByteOutput {
    public static void main(String[] args) {
        FileOutputStream_test.run();
    }
}
