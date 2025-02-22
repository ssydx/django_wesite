package study.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private ServerSocket server;
    private Socket socket;

    void start() {
        try {
            // 创建一个绑定指定端口的服务器套接字
            server = new ServerSocket(8998);
            System.out.println("服务器套接字已创建");
            while (true) {
                System.out.println("等待客户机连接");
                // 监听并接受与此套接字建立的连接，返回值是客户端套接字
                socket = server.accept();
                // 获取客户端套接字的输入流，包装为缓冲阅读器
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    // 按行读取
                    String message = reader.readLine();
                    // 如果读到exit说明客户端断开连接，退出循环
                    if ("exit".equals(message)) {
                        System.out.println("客户机退出");
                        break;
                    }
                    System.out.println(message);
                }
                // 关闭阅读器
                reader.close();
                // 关闭客户端套接字
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MyServer tcp = new MyServer();
        tcp.start();
    }
}
