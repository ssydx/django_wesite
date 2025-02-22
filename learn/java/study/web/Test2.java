package study.web;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Test2 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("事件");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 500, 300);
        jf.setAlwaysOnTop(true);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT, 10,10));
        
        class MyAction extends AbstractAction {
            MyAction() {
                putValue(Action.NAME, "btn");
                putValue(Action.SHORT_DESCRIPTION,"按钮");
                putValue(Action.SMALL_ICON, new ImageIcon(Test2.class.getResource("src/呵护.jpeg")));
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击");
            }
        }
        JButton jb = new JButton(new MyAction());
        jf.add(jb);



        jf.setVisible(true);
    }
}
