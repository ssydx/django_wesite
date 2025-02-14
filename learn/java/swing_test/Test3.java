package swing_test;

import java.awt.*;
import javax.swing.*;


public class Test3 {
    public static void main(String[] args) {
        // 探究JFrame的结构
        // Container c = new Container();
        // c.setVisible(true);

        // 不包含任何内容的容器
        // Window w = new Window(null);
        // w.setBackground(Color.BLUE);
        // w.setBounds(100,100,300,300);
        // w.setVisible(true);

        // JWindow jw = new JWindow();
        // jw.setBounds(100, 100, 300, 300);
        // jw.setVisible(true);

        // 具备基本框架
        // Frame f = new Frame();
        // f.setBounds(100, 100, 5, 5);
        // f.add(new Button("A"));
        // f.setVisible(true);

        // JFrame jf = new JFrame();
        // jf.setBounds(100,100,300,300);
        // jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jf.setUndecorated(true);
        // jf.setVisible(true);

        // Dialog d = new Dialog((Dialog)null);
        // d.setBounds(100, 100, 300, 300);
        // d.setVisible(true);

        // JDialog jd = new JDialog();
        // jd.setBounds(100, 100, 300, 300);
        // jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // jd.setVisible(true);

        // FileDialog fd = new FileDialog((FileDialog)null);
        // fd.setVisible(true);

        // JFrame jf = new JFrame("JOptionPane");
        // JButton jb1 = new JButton("A");
        // JButton jb2 = new JButton("1");
        // JButton jb3 = new JButton("甲");
        // JButton jb4 = new JButton("1");
        // JOptionPane jop = new JOptionPane(
        //     "消息",
        //     JOptionPane.ERROR_MESSAGE, // 消息类型，会更改消息图标
        //     JOptionPane.YES_NO_CANCEL_OPTION, // 选项
        //     new ImageIcon(Test3.class.getResource("src/呵护.jpeg")), // 覆盖消息类型图标
        //     new JButton[]{jb1, jb2, jb3, jb4}, //覆盖选项
        //     jb3
        // );
        // JDialog jd = jop.createDialog(jf, "abc");
        // jd.setBounds(0, 0, 300, 400);
        // jf.setBounds(100,100,300,300);
        // JButton jb = new JButton("打开对话框");
        // jb.setBounds(0, 0, 200, 50);
        // jb.addActionListener(e -> jd.setVisible(true));
        // jf.add(jb);
        // jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jf.setVisible(true);


        // JOptionPane.showMessageDialog(
        //     jf, 
        //     "消息", 
        //     "MessageDialog",
        //     JOptionPane.QUESTION_MESSAGE, 
        //     new ImageIcon(Test3.class.getResource("src/呵护.jpeg"))
        // );

        // JOptionPane.showConfirmDialog(
        //     jf, 
        //     "消息", 
        //     "ConfirmDialog", 
        //     JOptionPane.YES_NO_CANCEL_OPTION, 
        //     JOptionPane.QUESTION_MESSAGE, 
        //     new ImageIcon(Test3.class.getResource("src/呵护.jpeg"))
        // );

        // JOptionPane.showInputDialog(
        //     jf, 
        //     "消息", 
        //     "InputDialog",
        //     JOptionPane.QUESTION_MESSAGE, 
        //     new ImageIcon(Test3.class.getResource("src/呵护.jpeg")), 
        //     new String[]{"a","b","c"}, 
        //     "a"
        // );

        // JButton jb = new JButton("打开对话框");
        // jb.setBounds(0, 0, 200, 50);
        // jb.addActionListener(e -> JOptionPane.showOptionDialog(
        //     jf, 
        //     "消息", 
        //     "OptionDialog", 
        //     JOptionPane.YES_NO_CANCEL_OPTION, 
        //     JOptionPane.QUESTION_MESSAGE, 
        //     new ImageIcon(Test3.class.getResource("src/呵护.jpeg")), 
        //     new JButton[]{jb1, jb2, jb3, jb4}, 
        //     jb3
        // ));
        // jf.add(jb);
        // jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jf.setVisible(true);

        // JFrame jf = new JFrame("JPanel");
        // jf.setBounds(100, 100, 300, 300);
        // JPanel jp1 = new JPanel();
        // jp1.add(new Button("a"));
        // jp1.add(new Button("b"));
        // jf.add(jp1, BorderLayout.NORTH);
        // JPanel jp2 = new JPanel();
        // jp2.add(new Button("c"));
        // jp2.add(new Button("d"));
        // jf.add(jp2);
        // jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jf.setVisible(true);

        JFrame jf = new JFrame("JPanel");
        jf.setBounds(100, 100, 200, 300);
        JPanel jp1 = new JPanel();
        jp1.add(new Button("a"));
        jp1.add(new Button("b"));
        jp1.add(new Button("c"));
        jp1.add(new Button("d"));
        jp1.add(new Button("e"));
        jp1.add(new Button("f"));
        jp1.add(new Button("g"));
        jp1.add(new Button("h"));
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(jp1);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jf.add(jsp, BorderLayout.NORTH);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
