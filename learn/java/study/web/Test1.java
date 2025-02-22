package study.web;

import java.net.InetAddress;
import java.net.ServerSocket;

public class Test1 {
    public static void main(String[] args) {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println(ip);
            System.out.println(ip.getHostName());
            System.out.println(ip.getHostAddress());
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            ServerSocket ss = new ServerSocket(8999);
            System.out.println(ss.getLocalPort());
            System.out.println(ss.isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
