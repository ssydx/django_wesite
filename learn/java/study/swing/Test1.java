package study.swing;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.Border;

class JFrame_test {
    public static final void run() {
        JFrame jf1 = new JFrame("窗口标题");
        jf1.setLocation(1000, 500);
        jf1.setSize(300, 300);
        jf1.setBounds(1000,500,500,500);
        jf1.setBackground(Color.BLUE);
        jf1.setForeground(Color.GREEN);
        jf1.setVisible(true);
    }
}
class JDialog_test {
    public static final void run() {
        JFrame jf1 = new JFrame("窗口标题");
        jf1.setBounds(0, 0, 800, 600);
        JDialog jd1 = new JDialog(jf1,"对话框标题",true);
        jd1.setLocation(0, 0);
        jd1.setSize(300, 300);
        jd1.setBounds(500,500,500,500);
        jd1.setBackground(Color.BLUE);
        jd1.setForeground(Color.GREEN);
        jf1.setVisible(true);
        jd1.setVisible(true);
    }
}
class JOptionPane_test {
    public static final void run() {
        int i;
        i = JOptionPane.showOptionDialog(null, "你准备好了吗", "选项框", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
        i = JOptionPane.showConfirmDialog(null, null,"确认框",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        JOptionPane.showInputDialog(null, "消息", "输入框", JOptionPane.PLAIN_MESSAGE, null, null, null);
        JOptionPane.showMessageDialog(null, "消息", "消息框", JOptionPane.INFORMATION_MESSAGE, null);
        System.out.println(i);
    }
}
class Layout_test {
    // 绝对布局
    public static final void run1() {
        JFrame jf = new JFrame();
        jf.setTitle("布局");
        jf.setBounds(100,100,500,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(null);

        for (int i = 1; i <= 3; i++) {
            JButton jb = new JButton("button" + i);
            jb.setBounds(100 * i,100,100,50);
            jf.add(jb);
            
        }
        jf.setVisible(true);
    }
    // 流式布局
    public static final void run2() {
        JFrame jf = new JFrame();
        jf.setTitle("布局");
        jf.setBounds(100,100,500,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT, 10,10));

        for (int i = 1; i <= 20; i++) {
            jf.add(new JButton("button" + i));
        }
        jf.setVisible(true);
    }
    // 上下左右中
    public static final void run3() {
        JFrame jf = new JFrame();
        jf.setTitle("布局");
        jf.setBounds(100,100,500,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(10,10));

        jf.add(new JButton("东"),BorderLayout.EAST);
        jf.add(new JButton("西"),BorderLayout.WEST);
        jf.add(new JButton("南"),BorderLayout.SOUTH);
        jf.add(new JButton("北"),BorderLayout.NORTH);
        jf.add(new JButton("中"),BorderLayout.CENTER);
        jf.setVisible(true);
    }
    // 网格布局
    public static final void run4() {
        JFrame jf = new JFrame();
        jf.setTitle("布局");
        jf.setBounds(100,100,500,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(4,5,10,10));

        for (int i = 1; i <= 20; i++) {
            jf.add(new JButton("button" + i));
        }
        jf.setVisible(true);
    }
}
class JPanel_test {
    public static final void run() {
        JFrame jf = new JFrame();
        jf.setBounds(100,100,500,300);
        jf.setTitle("面板们");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(2,2,10,10));
        for (int i = 1; i <= 4; i++) {
            JPanel jp = new JPanel();
            jp.setBorder(BorderFactory.createTitledBorder("面板" + i));
            switch (i) {
                case 1:
                case 2:
                    jp.setLayout(new BorderLayout());
                    jp.add(new Button("B"), BorderLayout.WEST);
                    break;
                case 3:
                case 4:
                    jp.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
                    jp.add(new Button("B1"));
                    jp.add(new Button("B2"));
                    break;
                default:
                    break;
            }
            jf.add(jp);
        }
        jf.setVisible(true);
    }
}
class JScrollPanel_test {
    public static final void run() {
        JFrame jf = new JFrame();
        jf.setBounds(100,100,500,300);
        jf.setTitle("可滚动");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea jt = new JTextArea(20,100);
        JScrollPane js = new JScrollPane();
        js.add(jt);
        jf.add(js);
        jf.setVisible(true);
    }
}
class JLabel_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new GridLayout(2,2,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel jl;
        jl = new JLabel();
        jf.add(jl);
        jl = new JLabel("标签",JLabel.RIGHT);
        jf.add(jl);
        Icon ic = new ImageIcon(JLabel_test.class.getResource("src/cywl.png"));
        jl = new JLabel(ic);
        jf.add(jl);
        jl = new JLabel("标签",ic,JLabel.RIGHT);
        System.out.println(jl.getText());
        System.out.println(jl.getIcon());
        System.out.println(jl.getIconTextGap());
        System.out.println(jl.getHorizontalAlignment());
        jl.setText("label");
        jl.setIcon(new ImageIcon(JLabel_test.class.getResource("src/呵护.jpeg")));
        jl.setIconTextGap(50);
        jl.setVerticalTextPosition(JLabel.TOP);
        jl.setVerticalAlignment(JLabel.BOTTOM);
        jf.add(jl);
        jf.setVisible(true);
    }
}
class JButton_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new GridLayout(2,2,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton jb;
        jb = new JButton();
        jf.add(jb);
        jb = new JButton("按钮");
        jf.add(jb);
        jb = new JButton(new ImageIcon(JButton_test.class.getResource("src/cywl.png")));
        jf.add(jb);
        Icon ic = new ImageIcon(JButton_test.class.getResource("src/呵护.jpeg"));
        jb = new JButton("按钮", ic);
        jb.setVerticalAlignment(JButton.BOTTOM);
        jf.add(jb);
        jf.setVisible(true);
    }
}
class JRadioButton_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new GridLayout(2,2,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JRadioButton jb;
        ButtonGroup bg = new ButtonGroup();
        jb = new JRadioButton();
        bg.add(jb);
        jf.add(jb);
        jb = new JRadioButton("按钮");
        bg.add(jb);
        jf.add(jb);
        jb = new JRadioButton(new ImageIcon(JButton_test.class.getResource("src/呵护.jpeg")));
        bg.add(jb);
        jf.add(jb);
        jf.setVisible(true);
    }
}
class JCheckBox_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JCheckBox jc;
        JCheckBox jc1 = new JCheckBox("香蕉");
        jf.add(jc1);
        JCheckBox jc2 = new JCheckBox("苹果");
        jf.add(jc2);
        JCheckBox jc3 = new JCheckBox("橘子",true);
        jf.add(jc3);
        JButton jb = new JButton("输出");
        jf.add(jb);

        jf.setVisible(true);
    }
}
class JComboBox_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JComboBox<String> jc = new JComboBox<String>();
        jc.addItem("香蕉");
        jc.addItem("苹果");
        jc.addItem("橘子");
        jf.add(jc);

        jf.setVisible(true);
    }
}
class JList_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JList<String> jl = new JList<String>(new String[]{"香蕉","苹果","橘子"});
        jf.add(jl);

        jf.setVisible(true);
    }
}
class JTextField_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField jt = new JTextField("文本",30);
        jt.setSize(100,20);
        jf.add(jt);
        JTextArea jta = new JTextArea("文本",5,30);
        jf.add(jta);
        JPasswordField jp = new JPasswordField("文本",20);
        jf.add(jp);
        JTable jtb = new JTable(new String[][]{{"a","b","c"},{"d","e","f"},},new String[]{"A","B","C"});
        jf.add(jtb);
        jf.setVisible(true);
    }
}
class JAction1_test {
    static class Act implements ActionListener {
        private JFrame jf;
        Act(JFrame jf) {
            this.jf = jf;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(jf, "按钮被点击了");
        }
    }
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton jb1 = new JButton("按钮");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时执行这里的代码
                JOptionPane.showMessageDialog(jf, "按钮被点击了！");
            }
        });
        jf.add(jb1);
        JButton jb2 = new JButton("按钮");
        jb2.addActionListener(new Act(jf));
        jf.add(jb2);
        JButton jb3 = new JButton("按钮");
        jb3.addActionListener(e -> JOptionPane.showMessageDialog(jf, "按钮被点"));
        jf.add(jb3);

        jf.setVisible(true);
    }
}
class JAction2_test {
    public static final void run() {
        JFrame jf = new JFrame("标签用法");
        jf.setBounds(100, 100, 600, 600);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField jt = new JTextField("文本", 20);
        jt.setBounds(0, 0, 150, 50);
        jf.add(jt);
        JButton jb1 = new JButton("按钮");
        jb1.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标移入");
            }
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标移出");
            }
            public void mousePressed(MouseEvent e) {
                System.out.println("鼠标按下");
            }
            public void mouseReleased(MouseEvent e) {
                System.out.println("鼠标释放");
            }
            public void mouseClicked(MouseEvent e) {
                System.out.println(jt.getText());
                jt.setLocation(jt.getX() + 5, jt.getY() + 5);
                for (int i = 0; i < 100; i++) {
                    try {
                        jf.setLocation(jf.getX() + 3, jf.getY() + 3);
                        jf.setLocation(jf.getX() - 3, jf.getY() - 3);
                        Thread.sleep(1);
                    } catch (Exception err) {
                        err.printStackTrace();
                    }
                }
                System.out.println("单击鼠标");
            }
        });
        jb1.setBounds(0, 100, 100, 50);
        jf.add(jb1);

        jf.setVisible(true);
    }
}
class JAction3_test {
    class MyButton {
        private MyButton() {}
        static final JButton getButton(String name, JTextField jt) {
            JButton jb = new JButton(name);
            jb.addActionListener(e -> {
                jt.setText(jt.getText() + jb.getText());
                System.out.println(e);
            });
            return jb;
        }
    }
    public static final void run() {
        JFrame jf = new JFrame("计算器");
        jf.setBounds(100, 100, 320, 500);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField jt = new JTextField();
        jt.setBounds(0, 0, 300, 30);
        jt.setHorizontalAlignment(JTextField.RIGHT);
        jf.add(jt);
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4,4,10,10));
        for (int i = 9; i > 0; i--) {
            JButton jb = MyButton.getButton(String.valueOf(i),jt);
            if (i % 3 == 0) {
                switch (i / 3) {
                    case 3:
                        jp.add(MyButton.getButton("/",jt));
                        break;
                    case 2:
                        jp.add(MyButton.getButton("*",jt));
                        break;
                    case 1:
                        jp.add(MyButton.getButton("-",jt));
                        break;
                    default:
                        break;
                }
            }
            jp.add(jb);
        }
        jp.add(MyButton.getButton("+",jt));
        jp.add(MyButton.getButton("0",jt));
        jp.add(MyButton.getButton(".",jt));
        jp.add(MyButton.getButton("=",jt));
        jp.setBounds(0, 40, 300, 340);
        jf.add(jp);
        jf.setVisible(true);
    }
}

public class Test1 {
    public static void main(String[] args) {
        // JFrame_test.run();
        // JDialog_test.run();
        // JOptionPane_test.run();
        // Layout_test.run1();
        // Layout_test.run2();
        // Layout_test.run3();
        // Layout_test.run4();
        // JPanel_test.run();
        // JScrollPanel_test.run();
        // JLabel_test.run();
        // JButton_test.run();
        // JRadioButton_test.run();
        // JCheckBox_test.run();
        // JList_test.run();
        // JTextField_test.run();
        // JAction1_test.run();
        // JAction2_test.run();
        JAction3_test.run();
        
    }
}
