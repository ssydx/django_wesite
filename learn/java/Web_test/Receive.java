package Web_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Receive extends JFrame implements Runnable,ActionListener {
    int port;
    InetAddress group = null;
    MulticastSocket socket = null;
    JButton jb1 = new JButton("开始接收");
    JButton jb2 = new JButton("停止接收");
    JTextArea jta1 = new JTextArea(10,10);
    JTextArea jta2 = new JTextArea(10,10);
    Thread t;
    boolean stop = false;
    public Receive() {
        setTitle("广播数据报");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        t = new Thread(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jta1.setForeground(Color.BLUE);
        JPanel jp = new JPanel();
        jp.add(jb1);
        jp.add(jb2);
        add(jp, BorderLayout.NORTH);
        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(1,2));
        jp2.add(jta1);
        jp2.add(jta2);
        add(jp2, BorderLayout.CENTER);
        validate();
        port = 9898;
        try {
            group = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.joinGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setBounds(1000, 100, 500, 300);
        setVisible(true);
    }
    public void run() {
        while (!stop) {
            byte[] data = new byte[1024];
            DatagramPacket packet = null;
            packet = new DatagramPacket(data, data.length, group, port);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(),0,packet.getLength());
                jta1.setText("正在接收的内容：\n" + message);
                jta2.append(message + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            jb1.setBackground(Color.RED);
            jb2.setBackground(Color.YELLOW);
            if (!(t.isAlive())) {
                t = new Thread(this);
            }
            t.start();
            stop = false;
        }
        if (e.getSource() == jb2) {
            jb1.setBackground(Color.YELLOW);
            jb2.setBackground(Color.RED);
            stop = true;
        }
    }
    public static void main(String[] args) {
        Receive rec = new Receive();
        rec.setSize(500,300);
    }
}
