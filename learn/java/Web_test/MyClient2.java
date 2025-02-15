package Web_test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MyClient2 extends JFrame {
    Socket s;
    JTextArea jta;
    JTextField jtf;
    PrintWriter pw;
    JButton jb;
    MyClient2() {
        // 基本设置
        setTitle("客户端窗口");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(1000, 100, 500, 300);
        Container c = getContentPane();
        // 消息显示区
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        c.add(jsp, "Center");
        // 启动及发送区
        JButton jb1 = new JButton("连接服务器");
        c.add(jb1, "South");
        // 主线程发送信息
        jb1.addActionListener(e -> {
            // 更换组件
            c.remove(jb1);
            c.revalidate();
            c.repaint();
            JPanel jp = new JPanel(new BorderLayout(10,10));
            jtf = new JTextField();
            jb = new JButton("发送");
            // 连接服务器端后按钮才可用
            jb.setEnabled(false);
            jp.add(jtf, "Center");
            jp.add(jb, "East");
            jb.addActionListener(evt -> {
                pw.println(jtf.getText().trim());
                jta.append("客户机端消息：" + jtf.getText().trim() + "\n");
                jtf.setText("");
            });
            c.add(jp, "South");
            // 在新线程启动客户机并接收服务器端消息
            connect();
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
            }
        });
        
        setVisible(true);
    }
    private void connect() {
        new Thread(() -> {
            boolean isconnected = false;
            int cnt = 1;
            while (!isconnected && cnt <= 20) {
                try {
                    jta.setText("尝试连接，第" + cnt + "次\n" );
                    s = new Socket("192.168.1.4", 8099);
                    pw = new PrintWriter(s.getOutputStream(), true);
                    jta.append("连接成功\n");
                    jb.setEnabled(true);
                    isconnected = true;
                    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    while (true) {
                        String str = br.readLine();
                        if ("exit".equals(str)) {
                            jta.append("服务器端关闭\n");
                            jb.setEnabled(false);
                            break;
                        } else {
                            jta.append("服务器端消息：" + str.trim() + "\n");
                        }
                    }
                    br.close();
                    s.close();
                } catch (Exception err) {
                    cnt++;
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }                
            }
            if (!isconnected) {
                jta.append("连接超时，请稍后再试\n");
            }

        }).start();
    }
    public static void main(String[] args) {
        MyClient2 mc = new MyClient2();
    }
}
