package Web_test;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Receive1 extends JFrame {
    MulticastSocket socket;
    boolean run = true;
    Receive1() {
        setTitle("收听者");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(1000,100,500,300);

        JTextArea jtf = new JTextArea();
        JScrollPane jsp = new JScrollPane(jtf);
        add(jsp, "Center");

        JButton jb1 = new JButton("开始收听");
        JButton jb2 = new JButton("结束收听");
        jb2.setEnabled(false);
        
        try {
            socket = new MulticastSocket(9099);
            socket.joinGroup(new InetSocketAddress(InetAddress.getByName("224.255.10.0"), 9099), NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
        } catch (Exception err) {
            err.printStackTrace();
        }

        jb1.addActionListener(e -> {
            jb1.setEnabled(false);
            jb2.setEnabled(true);
            new Thread(() -> {
                while (run) {
                    byte[] barr = new byte[1024];
                    try {
                        DatagramPacket packet = new DatagramPacket(barr, barr.length, InetAddress.getByName("224.255.10.0"), 9099);
                        socket.receive(packet);
                        jtf.append(new String(packet.getData()) + "\n");
                    } catch (Exception err) {
                        err.printStackTrace();
                    }
                }
            }).start();
        });
        jb2.addActionListener(e -> {
            run = false;
            jb1.setEnabled(true);
            jb2.setEnabled(false);
        });
        JPanel jp = new JPanel();
        jp.add(jb1);
        jp.add(jb2);
        add(jp, "South");

        setVisible(true);
    }
    public static void main(String[] args) {
        Receive1 n = new Receive1();
    }
}
