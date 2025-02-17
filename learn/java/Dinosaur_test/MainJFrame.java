package Dinosaur_test;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainJFrame extends JFrame {
    public MainJFrame() {
        setBounds(300, 200, 800, 300);
        setTitle("小游戏");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("保存记录");
            }
        });

        Container c = getContentPane();
        c.removeAll();
        GameJPanel panel = new GameJPanel();
        c.add(panel);
        addKeyListener(panel);
        c.validate();
    }
}
