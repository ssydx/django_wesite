package Dinosaur.src.com.ssydx.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dinosaur.src.com.ssydx.service.ScoreRecorder;

public class ScoreDialog extends JDialog {
    public ScoreDialog(JFrame frame) {
        super(frame, true);
        int[] scores = ScoreRecorder.getScores();
        JPanel scoreP = new JPanel(new GridLayout(4, 1));
        scoreP.setBackground(Color.WHITE);
        JLabel title = new JLabel("得分排行榜", JLabel.CENTER);
        title.setForeground(Color.RED);
        JLabel first = new JLabel("第一名：" + scores[2], JLabel.CENTER);
        JLabel second = new JLabel("第二名：" + scores[1], JLabel.CENTER);
        JLabel third = new JLabel("第三名：" + scores[0], JLabel.CENTER);
        JButton restart = new JButton("重新开始");
        restart.addActionListener(e -> dispose());
        scoreP.add(title);
        scoreP.add(first);
        scoreP.add(second);
        scoreP.add(third);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(scoreP, BorderLayout.CENTER);
        c.add(restart, BorderLayout.SOUTH);
        setTitle("游戏结束");
        int width,height;
        width = height = 200;
        int x = frame.getX() + (frame.getWidth() - width) / 2;
        int y = frame.getX() + (frame.getHeight() - height) / 2;
        setBounds(x,y,width,height);
        setVisible(true);
    }
}
