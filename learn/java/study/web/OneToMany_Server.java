package study.web;

import java.awt.Window;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class OneToMany_Server extends JFrame {
    ServerSocket ss;
    Socket s;
    Vector<Socket> v = new Vector<Socket>();
    JTextArea jta;
    OneToMany_Server() {
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
            ss = new ServerSocket(8999);
            while (true) {
                jta.append("等待客户端连接\n");
                s = ss.accept();
                v.add(s);
                jta.append("客户端连接成功" + s + "\n");
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
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                    String str = br.readLine();
                    for (Socket socket : v) {
                        // 非发则收
                        if (socket != s) {
                            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                            pw.println(str);
                            pw.flush();
                        }
                    }
                }
            } catch (Exception e) {
                jta.append("已经退出连接" + s + "\n");
                v.remove(s);
            }
        }
    }
    public static void main(String[] args) {
        OneToMany_Server s = new OneToMany_Server();
        s.setVisible(true);
        s.createSocket();
    }
}
