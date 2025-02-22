package study.io;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileType {
    public static void main(String[] args) {
        File f1 = new File("word.txt");
        if (f1.exists()) {
            System.out.println("文件存在");
            System.out.println(f1.length());
            System.out.println(f1.getName());
            System.out.println(f1.getAbsolutePath());
            System.out.println(f1.canRead());
            System.out.println(f1.canWrite());
            System.out.println(f1.canExecute());
            System.out.println(f1.isFile());
            System.out.println(f1.isDirectory());
            System.out.println(f1.isHidden());
            System.out.println(new Date(f1.lastModified()));
            
        } else {
            try {
                f1.createNewFile();
                System.out.println(f1.getAbsolutePath());
                System.out.println("文件不存在，已创建");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File f2 = new File("D://test1/test1");
        if (! f2.exists()) {
            f2.mkdirs();
        } else {
            System.out.println("目录已存在");
            for (int i=1; i<=20;i++) {
                File ff = new File(f2, Integer.toString(i) + ".txt");
                if (! ff.exists()) {
                    try {
                        ff.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("文件已存在");
                }
            }
        }
        File f3 = new File("D:");
        System.out.println(Arrays.toString(f3.list()));
    }
    
}