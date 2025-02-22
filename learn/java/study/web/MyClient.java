package study.web;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyClient extends JFrame {
    private PrintWriter writer;
    Socket socket;
    private JTextArea area = new JTextArea();
    private JTextField text = new JTextField();

    public MyClient() {
        setTitle("向服务发送数据");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        JScrollPane jsp = new JScrollPane(area);
        c.add(jsp, BorderLayout.CENTER);
        c.add(text, "South");
        text.addActionListener(e -> {
            writer.println(text.getText().trim());
            area.append(text.getText() + '\n');
            text.setText("");
        });
        addWindowListener(new WindowListener() {
            public void windowIconified(WindowEvent e) {

            }
            public void windowClosing(WindowEvent e) {
                text.setText("exit");
                text.postActionEvent();
                
            }
            public void windowOpened(WindowEvent e) {

            }
            public void windowDeiconified(WindowEvent e) {

            }
            public void windowClosed(WindowEvent e) {
                
            }
            public void windowDeactivated(WindowEvent e) {

            }
            public void windowActivated(WindowEvent e) {

            }
        });
    }
    private void connect() {
        area.append("尝试连接\n");
        try {
            // 创建连接到指定地址指定端口的客户端套接字
            socket = new Socket("127.0.0.1",8998);
            writer = new PrintWriter(socket.getOutputStream(), true);
            area.append("连接成功\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.setSize(200,200);
        client.setVisible(true);
        client.connect();
    }
}
