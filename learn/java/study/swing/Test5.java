package study.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JToolTip;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;

public class Test5 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("小组件");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 500, 300);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT, 10,10));

        // JLabel jl = new JLabel("这是标签",new ImageIcon(Test5.class.getResource("src/呵护.jpeg")),JLabel.CENTER);
        // jl.setOpaque(true);
        // jl.setBackground(Color.BLUE);
        // jl.setForeground(Color.GREEN);
        // jf.add(jl);
        // System.out.println(jl.getText());
        // System.out.println(jl.getIcon());
        // System.out.println(jl.getBackground());
        // System.out.println(jl.getForeground());
        // System.out.println(jl.isOpaque());

        // JTextField jtf = new JTextField("abc", 5);
        // jtf.setBackground(Color.BLUE);
        // jtf.setForeground(Color.GREEN);
        // jf.add(jtf);

        // JTextArea jta = new JTextArea("abc", 5, 10);
        // jta.setBackground(Color.BLUE);
        // jta.setForeground(Color.GREEN);
        // jta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        // jf.add(jta);


        // JMenuBar jmb = new JMenuBar();

        // JMenu jm1 = new JMenu("菜单1");
        // jmb.add(jm1);

        // JMenu jm2 = new JMenu("菜单2");
        // jm2.add(new JMenuItem("1"));
        // jm2.add(new JMenuItem("2"));
        // jm2.add(new JMenuItem("3"));
        // jm2.addSeparator();
        // jm2.add(new JMenuItem("a"));
        // jm2.add(new JMenuItem("b"));
        // jm2.setMnemonic(KeyEvent.VK_A);
        // jmb.add(jm2);

        // JMenu jm3 = new JMenu("菜单3");
        // ButtonGroup bg = new ButtonGroup();
        // JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("A");
        // JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("B");
        // jrmi2.setSelected(true);
        // JRadioButtonMenuItem jrmi3 = new JRadioButtonMenuItem("C");
        // bg.add(jrmi1);
        // bg.add(jrmi2);
        // bg.add(jrmi3);
        // jm3.add(jrmi1);
        // jm3.add(jrmi2);
        // jm3.add(jrmi3);
        // jmb.add(jm3);

        // JMenu jm4 = new JMenu("菜单4");
        // jm4.add(new JCheckBoxMenuItem("A"));
        // jm4.add(new JCheckBoxMenuItem("B"));
        // jm4.add(new JCheckBoxMenuItem("C"));
        // jmb.add(jm4);

        // jf.setJMenuBar(jmb);


        JComboBox jcb = new JComboBox<>(new Object[]{1,1.2,"abc",'a'});
        jcb.setSelectedIndex(2);
        jf.add(jcb);

        JList jl = new JList<>(new Object[]{1,1.2,"abc",'a'});
        jl.setSelectedIndex(2);
        System.out.println(Arrays.toString(jl.getSelectedIndices()));
        jf.add(jl);

        // JPopupMenu jpm = new JPopupMenu("弹出菜单");
        // jpm.add(new JMenuItem("a"));
        // jpm.add(new JMenuItem("b"));
        // jpm.add(new JMenuItem("c"));
        // JButton jb = new JButton("弹出菜单");
        // jb.addActionListener(e -> jpm.show(jb, 0, jb.getHeight()));
        // jf.add(jb);

        // JToolBar jtb = new JToolBar("工具栏", JToolBar.HORIZONTAL);
        // jtb.add(new JButton("a"));
        // jtb.add(new JButton("b"));
        // jtb.addSeparator();
        // jtb.add(new JButton("1"));
        // jf.add(jtb);


        // JButton jb = new JButton("按钮");
        // jb.setToolTipText("这是按钮");
        // jf.add(jb);

        // JColorChooser jcc = new JColorChooser();
        // jf.add(jcc);

        // JFileChooser jfc = new JFileChooser();
        // jf.add(jfc);


        // // 创建根节点
        // DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
        // // 创建子节点
        // DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("子节点 1");
        // DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("子节点 2");
        // // 向根节点添加子节点
        // root.add(child1);
        // root.add(child2);
        // // 可以为子节点添加更多子节点
        // child1.add(new DefaultMutableTreeNode("子节点 1.1"));
        // child1.add(new DefaultMutableTreeNode("子节点 1.2"));
        // child2.add(new DefaultMutableTreeNode("子节点 2.1"));
        // child2.add(new DefaultMutableTreeNode("子节点 2.2"));
        // // 创建 JTree 并指定根节点
        // JTree tree = new JTree(root);
        // JScrollPane jsp = new JScrollPane(tree);
        // jf.setLayout(new BorderLayout());
        // jf.add(jsp, BorderLayout.CENTER);

        // JSpinner js = new JSpinner();
        // jf.add(js);
        // JScrollBar jsb = new JScrollBar();
        // jf.add(jsb);
        // JSlider jsl = new JSlider(0, 100, 50);
        // jf.add(jsl);
        // JProgressBar jpb = new JProgressBar(0, 100);
        // jf.add(jpb);
        // JToolTip jtt = new JToolTip();
        // jf.add(jtt);



        jf.setVisible(true);
    }
}
