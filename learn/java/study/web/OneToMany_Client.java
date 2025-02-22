package study.web;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class OneToMany_Client extends JFrame {
    JTextArea jta;
    JTextField jtf;
    PrintWriter pw;
    public void send() {
        String str = jtf.getText();
        if (str.equals("")) {
            return;
        }
        if (str.equals("00")) {
            System.exit(0);
        }
        pw.println(str);
        pw.flush();
        jtf.setText("");
    }
    OneToMany_Client() {
        super();
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(1000, 100, 500, 300);
        setTitle("客户机端");
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        getContentPane().add(jsp, "Center");
        jtf = new JTextField(30);
        jtf.addActionListener(e -> send());
        JLabel jl = new JLabel("输入聊天内容：");
        JButton jb = new JButton("发  送");
        jb.addActionListener(e -> send());
        JPanel jp = new JPanel();
        jp.add(jl);
        jp.add(jtf);
        jp.add(jb);
        getContentPane().add(jp,"South");
    }
    public void createClientSocket() {
        try {
            Socket s = new Socket("192.168.1.4",8999);
            pw = new PrintWriter(s.getOutputStream(), true);
            new ClientThread(s).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class ClientThread extends Thread {
        Socket s;
        ClientThread(Socket s) {
            this.s = s;
        }
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                    String str = br.readLine();
                    if (str.equals("00")) {
                        break;
                    }
                    jta.append(str + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OneToMany_Client c = new OneToMany_Client();
                    c.setVisible(true);
                    c.createClientSocket();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
