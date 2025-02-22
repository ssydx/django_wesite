package practice.Dinosaur_test;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainJFrame extends JFrame {
    public MainJFrame() {
        setBounds(400, 200, 800, 230);
        setTitle("小游戏");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
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
