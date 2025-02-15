package Web_test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MyServer2 extends JFrame {
    private ServerSocket ss;
    private Socket s;
    JTextArea jta;
    JTextField jtf;
    PrintWriter pw;
    JButton jb;
    BufferedReader br;
    MyServer2() {
        // 基本设置
        setTitle("服务端窗口");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        Container c = getContentPane();
        // 消息显示区
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        c.add(jsp, "Center");
        // 启动区
        JButton jb1 = new JButton("启动服务器");
        c.add(jb1, "North");
        // 发送区
        JPanel jp = new JPanel(new BorderLayout(10,10));
        jtf = new JTextField();
        jb = new JButton("发送");
        // 连接客户机端后按钮才可用
        jb.setEnabled(false);
        jp.add(jtf, "Center");
        jp.add(jb, "East");
        jb.addActionListener(evt -> {
            pw.println(jtf.getText().trim());
            jta.append("服务器端消息：" + jtf.getText().trim() + "\n");
            jtf.setText("");
        });
        jb1.addActionListener(e -> {
            jb1.setEnabled(false);
            // 在新线程启动服务器并接收客户机端消息
            start();
            c.add(jp, "South");
            c.revalidate();
            c.repaint();
        });
        // 关闭窗口的操作
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (pw != null) {
                    pw.println("exit");
                    pw.close();
                }
                if (s != null) {
                    try {
                        s.close();
                    } catch (Exception err) {
                        err.printStackTrace();
                    }
                }
                if (ss != null) {
                    try {
                        ss.close();
                    } catch (Exception err) {
                        err.printStackTrace();
                    }
                }
            }
        });
        
        setVisible(true);
    }
    private void start() {
        new Thread(() -> {
            try {
                ss = new ServerSocket(8099);
                jta.append("服务器端套接字已创建\n");
                while (true) {
                    jta.append("等待客户机端连接\n");
                    s = ss.accept();
                    jta.append("客户机端已经连接\n");
                    jb.setEnabled(true);
                    pw = new PrintWriter(s.getOutputStream(),true);
                    br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    while (true) {
                        String str = br.readLine();
                        if ("exit".equals(str)) {
                            jta.append("客户机端断开连接\n");
                            jb.setEnabled(false);
                            break;
                        } else {
                            jta.append("客户机端消息：" + str.trim() + "\n");
                        }
                    }
                    br.close();
                    s.close();
                }
            } catch (Exception e) {
                jta.append("该端口当前不可使用\n");
                e.printStackTrace();
            }
        }).start();
    }
    public static void main(String[] args) {
        MyServer2 ms = new MyServer2();
    }
}
