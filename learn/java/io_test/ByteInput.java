package io_test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

class FileInputStream_test {
    public final static void run() {
        File f = new File("D://字节输入流-字节流.txt");
        // 在ASCII码范围的字符可以正常输出，其余乱码
        try (FileInputStream fin = new FileInputStream(f)) {
            System.out.println(fin.available());
            System.out.println("单字节读取");
            int byteVal;
            while ((byteVal = fin.read()) != -1) {
                System.out.print((char)byteVal);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 显式转换为指定编码格式的字符，不会乱码
        try (FileInputStream fin = new FileInputStream(f)) {
            System.out.println(fin.available());
            System.out.println("多字节读取");
            byte[] barr = new byte[1024];
            int len = fin.read(barr);
            System.out.println(Arrays.toString(barr));
            System.out.println(len);
            String s = new String(barr,0,len,"UTF-8");
            System.out.println(s);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 取出指定的字节数，从字节数组指定位置起填充
        try (FileInputStream fin = new FileInputStream(f)) {
            System.out.println(fin.available());
            System.out.println("读取指定长度");
            byte[] barr = new byte[512];
            int len = fin.read(barr,128,256);
            System.out.println(Arrays.toString(barr));
            System.out.println(len);
            String s = new String(barr,0,len,"UTF-8");
            System.out.println(s);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 跳过指定字节数
        try (FileInputStream fin = new FileInputStream(f)) {
            System.out.println(fin.available());
            fin.skip(111);
            System.out.println("选择性读取1");
            byte[] barr = new byte[512];
            int len = fin.read(barr,128,256);
            System.out.println(Arrays.toString(barr));
            System.out.println(len);
            String s = new String(barr,0,len,"UTF-8");
            System.out.println(s);
            System.out.println("选择性读取2");
            System.out.println(fin.available());
            byte[] barr1 = new byte[256];
            int len1 = fin.read(barr1,0,256);
            System.out.println(Arrays.toString(barr1));
            System.out.println(len1);
            String s1 = new String(barr1,0,len1);
            System.out.println(s1);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 直接通过字符串构造文件输入流
        try (FileInputStream fin = new FileInputStream("D://字节输入流-字节流.txt")) {
            byte[] barr = new byte[1024];
            int len = fin.readNBytes(barr, 0, 1024);
            System.out.println(new String(barr, 0, len));
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}

class BufferedInputStream_test {
    public final static void run() {
        // 不限定缓冲区大小
        try (
            FileInputStream fin = new FileInputStream("D://字节输入流-字节流.txt");
            BufferedInputStream fbin = new BufferedInputStream(fin);
        ) {
            System.out.println(fbin.available());
            System.out.println("第一次读取");
            fbin.skip(128);
            // 理论上已经超出限制，但实际仍可回退，可能是因为没有触发底层读操作
            fbin.mark(16);
            byte[] barr1 = new byte[256];
            int len1 = fbin.read(barr1, 0, 256);
            System.out.println(new String(barr1, 0, len1));
            System.out.println("第二次读取");
            fbin.reset();
            byte[] barr2 = new byte[256];
            int len2 = fbin.read(barr2, 0, 256);
            System.out.println(new String(barr2, 0, len2));
            fbin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 限定缓冲区大小
        try (
            FileInputStream fin = new FileInputStream("D://字节输入流-字节流.txt");
            BufferedInputStream fbin = new BufferedInputStream(fin, 32);
        ) {
            System.out.println(fbin.available());
            System.out.println("第一次读取");
            fbin.skip(128);
            // 理论上已经超出限制，但实际仍可回退，可能是因为没有触发底层读操作
            fbin.mark(16);
            byte[] barr1 = new byte[256];
            int len1 = fbin.read(barr1, 0, 256);
            System.out.println(new String(barr1, 0, len1));
            System.out.println("第二次读取");
            try {
                fbin.reset();
            } catch (Exception e) {
                System.out.println("------------------回退失败--------------");
            }
            byte[] barr2 = new byte[256];
            int len2 = fbin.read(barr2, 0, 256);
            System.out.println(new String(barr2, 0, len2));
            fbin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 有缓冲区的用时
        try (
            FileInputStream fin = new FileInputStream("D://Django 2.2 中文文档 (it-ebooks) (Z-Library).epub");
            BufferedInputStream fbin = new BufferedInputStream(fin);
        ) {
            long start = System.currentTimeMillis();
            System.out.println(fbin.available());
            byte[] barr = new byte[16];
            ArrayList<byte[]> iarr = new ArrayList<byte[]>();
            while (fbin.read(barr) != -1) {
                iarr.add(barr);
            }
            long end = System.currentTimeMillis();
            System.out.println("有缓冲耗时" + (end - start));
            // 关闭外层流即可，会自动关闭内层流
            fbin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 无缓冲区的用时
        try (FileInputStream fin = new FileInputStream("D://Django 2.2 中文文档 (it-ebooks) (Z-Library).epub")) {
            long start = System.currentTimeMillis();
            System.out.println(fin.available());
            byte[] barr = new byte[16];
            ArrayList<byte[]> iarr = new ArrayList<byte[]>();
            while (fin.read(barr) != -1) {
                iarr.add(barr);
            }
            long end = System.currentTimeMillis();
            System.out.println("无缓冲耗时" + (end - start));
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class DataInputStream_test {
    public final static void run() {
        try (
            FileInputStream fin = new FileInputStream("D://数据输出流-字节流.txt");
            DataInputStream fdin = new DataInputStream(fin);
        ) {
            System.out.println("可读字节数：" + fdin.available());
            System.out.println(fdin.readInt());
            System.out.println(fdin.readInt());
            System.out.println(fdin.readBoolean());
            System.out.println(fdin.readInt());
            System.out.println(fdin.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class ByteInput {
    public static void main(String[] args) {
        // FileInputStream_test.run();
        // BufferedInputStream_test.run();
        DataInputStream_test.run();
    }
}
