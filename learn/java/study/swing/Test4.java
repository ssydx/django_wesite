package study.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


class BorderLayout_test {
    public static final void run() {
        JFrame jf = new JFrame("Border布局");
        jf.setLayout(new BorderLayout(10,10));
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton jb = new JButton();
        jb.setBackground(Color.BLUE);
        jb.setForeground(Color.GREEN);
        jb.setText(jf.getLayout().toString());
        jf.add(jb);

        JButton jb1 = new JButton();
        jb1.setPreferredSize(new Dimension(100,200));
        jb1.setText(jb1.getPreferredSize().toString());
        jf.add(jb1, BorderLayout.NORTH);

        JButton jb2 = new JButton();
        jb2.setPreferredSize(new Dimension(350,200));
        jb2.setText(jb2.getPreferredSize().toString());
        jf.add(jb2, BorderLayout.EAST);



        jf.setVisible(true);
    }
}

class FlowLayout_test {
    public static final void run() {
        JFrame jf = new JFrame("Flow布局");
        jf.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton jb = new JButton();
        jb.setBackground(Color.BLUE);
        jb.setForeground(Color.GREEN);
        jb.setText(jf.getLayout().toString());
        jf.add(jb);

        JButton jb1 = new JButton();
        jb1.setPreferredSize(new Dimension(100,200));
        jb1.setText(jb1.getPreferredSize().toString());
        jf.add(jb1);

        JButton jb2 = new JButton();
        // jb2.setPreferredSize(new Dimension(350,200));
        jb2.setSize(100,100);
        jb2.setText(jb2.getPreferredSize().toString());
        jf.add(jb2);



        jf.setVisible(true);
    }
}

class GridLayout_test {
    public static final void run() {
        JFrame jf = new JFrame("Flow布局");
        jf.setLayout(new GridLayout(2,2,20,20));
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton jb = new JButton();
        jb.setBackground(Color.BLUE);
        jb.setForeground(Color.GREEN);
        jb.setText(jf.getLayout().toString());
        jf.add(jb);

        JButton jb1 = new JButton();
        // jb1.setPreferredSize(new Dimension(100,200));
        jb.setMaximumSize(new Dimension(50,50));
        jb1.setText(jb1.getPreferredSize().toString());
        jf.add(jb1);

        JButton jb2 = new JButton();
        jb2.setPreferredSize(new Dimension(350,200));
        jb2.setText(jb2.getPreferredSize().toString());
        jf.add(jb2);



        jf.setVisible(true);
    }
}

class CardLayout_test {
    public static final void run() {
        JFrame jf = new JFrame("Flow布局");
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
        jp.setLayout(new CardLayout(20,20));

        JButton jb = new JButton();
        jb.setBackground(Color.BLUE);
        jb.setForeground(Color.GREEN);
        jb.setText("123");
        jp.add(jb);

        JButton jb1 = new JButton();
        // jb1.setPreferredSize(new Dimension(100,200));
        jb.setMaximumSize(new Dimension(50,50));
        jb1.setText("abc");
        jp.add(jb1);

        JButton jb2 = new JButton();
        jb2.setPreferredSize(new Dimension(350,200));
        jb2.setText("甲乙丙");
        jp.add(jb2);

        JButton jb3 = new JButton("???");
        jp.add(jb3, "jb3");

        JButton jbforturn1 = new JButton("翻转");
        jbforturn1.addActionListener(e -> {
            CardLayout cl = (CardLayout)jp.getLayout();
            cl.next(jp);
            cl.setHgap(0);
            cl.setHgap(0);
            jp.revalidate();
            jp.repaint();
        });
        JButton jbforturn2 = new JButton("翻转");
        jbforturn2.addActionListener(e -> {
            CardLayout cl = (CardLayout)jp.getLayout();
            cl.show(jp, "jb3");;
        });

        jf.add(jp, BorderLayout.CENTER);
        jf.add(jbforturn1, BorderLayout.SOUTH);
        jf.add(jbforturn2, BorderLayout.EAST);



        jf.setVisible(true);
    }
}

// 没搞懂
class GridBagLayout_test {
    public static final void run() {
        JFrame jf = new JFrame("GridBag布局");
        jf.setLayout(new GridBagLayout());
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        JButton jb = new JButton("1");
        jf.add(jb, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JButton button2 = new JButton("2");
        jf.add(button2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5; // 跨越两列
        JButton button3 = new JButton("3");
        jf.add(button3, gbc);



        jf.setVisible(true);
    }
}



public class Test4 {
    public static void main(String[] args) {
        // BorderLayout_test.run();
        // FlowLayout_test.run();
        // GridLayout_test.run();
        // CardLayout_test.run();
        GridBagLayout_test.run();
    }
}
