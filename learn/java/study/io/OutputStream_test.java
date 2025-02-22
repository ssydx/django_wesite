package study.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class OutputStream_test {
    public static void main(String[] args) {
        File f1 = new File("D://test1.txt");
        try {
            FileOutputStream out = new FileOutputStream(f1,true);
            out.write("这是一段话\n".getBytes());
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            FileInputStream in = new FileInputStream(f1);
            System.out.println(in.available());
            byte[] barr = new byte[1024];
            int len = in.read(barr);
            System.out.println(new String(barr, 0, len));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
