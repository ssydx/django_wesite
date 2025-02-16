package Web_test;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class OneToOne_Client extends JFrame {
    JTextArea jta;
    JTextField jtf1;
    JTextField jtf2;
    JList jls;
    boolean flag = false;
    PrintWriter pw;
    public void send() {
        if (!flag) {
            JOptionPane.showMessageDialog(null, "请先登录");
            return;
        }
        String name = jtf2.getText().trim();
        String str = jtf1.getText();
        if (str.equals("")) {
            return;
        }
        String rev = (String)jls.getSelectedValue();
        String msg = name + "：发送给：" + rev + "：的信息是：" + str;
        pw.println(msg);
        pw.flush();
        jtf1.setText("");
    }
    OneToOne_Client() {
        super();
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(1000, 100, 500, 300);
        setTitle("客户机端");

        // 信息发送区
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("输入聊天内容：");
        jtf1 = new JTextField(30);
        JButton jb1 = new JButton("发  送");
        jtf1.addActionListener(e -> send());
        jb1.addActionListener(e -> send());
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jb1);
        getContentPane().add(jp1,"South");

        // 登录区
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("输入用户名称");
        jtf2 = new JTextField(30);
        JButton jb2 = new JButton("登  录");
        jb2.addActionListener(e -> {
            if (flag) {
                JOptionPane.showMessageDialog(null, "同一窗口只能登录一次");
                return;
            }
            String name = jtf2.getText().trim();
            pw.println("Login：" + name);
            pw.flush();
            jtf2.setEnabled(false);
            flag = true;
        });
        jp2.add(jl2);
        jp2.add(jtf2);
        jp2.add(jb2);
        getContentPane().add(jp2,"North");

        // 消息展示区
        jta = new JTextArea();
        JScrollPane jscp1 = new JScrollPane(jta);

        // 联系人列表区
        jls = new JList();
        jls.setModel(new DefaultComboBoxModel(new String[]{ "" }));
        JScrollPane jscp2 = new JScrollPane(jls);

        // 核心区
        JSplitPane jspp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jls,jscp1);
        jspp.setDividerLocation(100);
        getContentPane().add(jspp);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                pw.println("Exit：" + jtf2.getText().trim());
                pw.flush();
            }
        });
        

    }

    public void createSocket() {
        try {
            Socket s = new Socket("192.168.1.4",9999);
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
                DefaultComboBoxModel model = (DefaultComboBoxModel)jls.getModel();
                while (true) {
                    String str = br.readLine().trim();
                    // 修改用户列表
                    if (!str.startsWith("MSG：")) {
                        if (str.startsWith("-")) {
                            model.removeElement(str.substring(1));
                            break;
                        }
                        boolean isin = false;
                        for (int i = 0; i < model.getSize(); i++) {
                            if (str.equals((String)model.getElementAt(i))) {
                                isin = true;
                            }
                        }
                        if (!isin) {
                            model.addElement(str);
                        }
                    // 接收
                    } else {
                        jta.append(str + "\n");
                        if (str.equals("00")) {
                            break;
                        }
                    }
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
                    OneToOne_Client c = new OneToOne_Client();
                    c.setVisible(true);
                    c.createSocket();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
