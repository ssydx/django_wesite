package practice.Dinosaur.src.com.ssydx.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import practice.Dinosaur.src.com.ssydx.model.Dinosaur;
import practice.Dinosaur.src.com.ssydx.model.Obstacle;
import practice.Dinosaur.src.com.ssydx.service.FreshThread;
import practice.Dinosaur.src.com.ssydx.service.ScoreRecorder;
import practice.Dinosaur.src.com.ssydx.service.Sound;

public class GamePanel extends JPanel implements KeyListener {
    private BufferedImage image;
    private BackgroundImage background;
    private Dinosaur golden;
    private Graphics2D g2;
    private int addObstacleTimer = 0;
    private boolean finish = false;
    private List<Obstacle> list = new ArrayList<Obstacle>();
    private final int FREASH = FreshThread.FREASH;
    int score = 0;
    int scoreTimer = 0;

    public GamePanel() {
        image = new BufferedImage(800, 300, BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        background = new BackgroundImage();
        golden = new Dinosaur();
        list.add(new Obstacle());
        FreshThread t = new FreshThread(this);
        t.start();
    }

    private void paintImage() {
        background.roll();
        golden.move();
        g2.drawImage(background.image, 0, 0, this);
        if (addObstacleTimer == 1300) {
            if (Math.random() * 100 > 40) {
                list.add(new Obstacle());
            }
            addObstacleTimer = 0;
        }
        for (int i = 0; i < list.size(); i++) {
            Obstacle o = list.get(i);
            if (o.isLive()) {
                o.move();
                g2.drawImage(o.image, o.x, o.y, this);
                if (o.getBounds().intersects(golden.getFootBounds()) || o.getBounds().intersects(golden.getHeadBounds())) {
                    Sound.hit();
                    // gameOver();
                }
            } else {
                list.remove(i);
                i--;
            }
        }
        g2.drawImage(golden.image, golden.x, golden.y, this);
        if (scoreTimer >= 500) {
            score += 10;
            scoreTimer = 0;
        }
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("黑体",Font.BOLD,24));
        g2.drawString(String.format("%06d",score), 700, 30);
        addObstacleTimer += FREASH;
        scoreTimer += FREASH;
    }

    public void paint(Graphics g) {
        paintImage();
        g.drawImage(image, 0, 0, this);
    }

    public void gameOver() {
        ScoreRecorder.addNewScore(score);
        finish = true;
    }

    public boolean isFinish() {
        return finish;
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            golden.jump();
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}
