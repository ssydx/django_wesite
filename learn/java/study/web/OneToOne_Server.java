package study.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class OneToOne_Server extends JFrame {
    JTextArea jta;
    ServerSocket ss;
    Socket s;
    Hashtable<String, Socket> map = new Hashtable<String, Socket>();
    OneToOne_Server() {
        super();
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        setTitle("服务器端");
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        getContentPane().add(jsp);
    }
    public void createSocket() {
        try {
            ss = new ServerSocket(9999);
            while (true) {
                jta.append("等待客户端连接\n");
                s = ss.accept();
                new ServerThread(s).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class ServerThread extends Thread {
        Socket s;
        ServerThread(Socket s) {
            this.s = s;
        }
        public void run() {
            String key = "";
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                    String str = br.readLine();
                    // 退出
                    if (str.startsWith("Exit：")) {
                        key = str.substring(5);
                        jta.append(s + " " + key + "退出连接\n");
                        map.remove(key);
                        for (Socket s : map.values()) {
                            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                            pw.println("-" + key);
                            pw.flush();
                        }
                        break;
                    // 登录
                    } else if (str.startsWith("Login：")) {
                        key = str.substring(6);
                        jta.append(s + " " + key + "加入连接\n");
                        // 加入哈希表
                        map.put(key, s);
                        // 对每个端口发送信息，信息为所有端口对应的用户
                        for (Socket s : map.values()) {
                            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                            for (String k : map.keySet()) {
                                pw.println(k);
                                pw.flush();
                            }
                        }
                    // 交流
                    } else {
                        // 接收者
                        key = str.substring(str.indexOf("发送给：") + 4, str.indexOf("：的信息是："));
                        // 发送者
                        String sendUser = str.substring(0, str
                                .indexOf("：发送给："));
                        // 接收者不等于发送者，哈希表中有接收者
                        if (map.containsKey(key) && !key.equals(sendUser)) {
                            Socket s = map.get(key);
                            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                            pw.println("MSG：" + str);
                            pw.flush();
                        }
                    }
                }
            } catch (Exception e) {
                jta.append(s + "异常\n");
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        OneToOne_Server s = new OneToOne_Server();
        s.setVisible(true);
        s.createSocket();
    }
}
