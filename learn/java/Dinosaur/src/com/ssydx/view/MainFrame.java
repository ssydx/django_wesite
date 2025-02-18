package Dinosaur.src.com.ssydx.view;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Dinosaur.src.com.ssydx.service.ScoreRecorder;
import Dinosaur.src.com.ssydx.service.Sound;

public class MainFrame extends JFrame {
    public MainFrame() {
        restart();
        setBounds(340,150,820,260);
        setTitle("奔跑吧，小恐龙");
        Sound.background();
        ScoreRecorder.init();
        addListener();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void restart() {
        Container c = getContentPane();
        c.removeAll();
        GamePanel panel = new GamePanel();
        c.add(panel);
        addKeyListener(panel);
        c.validate();
    }
    public void addListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ScoreRecorder.saveScore();
            }
        });
    }
}
