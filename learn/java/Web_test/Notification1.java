package Web_test;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Notification1 extends JFrame {
    MulticastSocket socket;
    Notification1() {
        setTitle("广播者");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,500,300);

        JTextArea jtf = new JTextArea();
        add(jtf, "Center");

        JButton jb = new JButton("发送");

        try {
            socket = new MulticastSocket(9099);
            socket.setTimeToLive(1);
            socket.joinGroup(new InetSocketAddress(InetAddress.getByName("224.255.10.0"), 9099), NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
        } catch (Exception err) {
            err.printStackTrace();
        }

        jb.addActionListener(e -> {
            byte[] barr = jtf.getText().getBytes();
            jtf.setText("");
            if (barr.length == 0) {
                return;
            }
            try {
                socket.send(new DatagramPacket(barr, barr.length,InetAddress.getByName("224.255.10.0"),9099));
            } catch (Exception err) {
                err.printStackTrace();
            }
        });
        add(jb, "South");

        setVisible(true);
    }
    public static void main(String[] args) {
        Notification1 n = new Notification1();
    }
}
