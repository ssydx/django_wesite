package Dinosaur_test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.List;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class GameJPanel extends JPanel implements KeyListener, Runnable {
    BackgroundImage bg;
    Dinosaur ds;
    List<Obstacle> otls = new ArrayList<Obstacle>();
    boolean finish = false;
    int cnt = 0;
    GameJPanel() {
        bg = new BackgroundImage();
        ds = new Dinosaur();
        otls.add(new Obstacle());
        Sound.background();
        new Thread(this).start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 背景前移
        g.drawImage(bg.paper,0,0,this);
        bg.roll();
        // 角色行动
        g.drawImage(ds.image, ds.x,ds.y,this);
        ds.move();
        // 增加障碍
        double n = Math.random() * 700;
        if (cnt > 300 + n) {
            if (Math.random() * 10 > 2) {
                otls.add(new Obstacle());
            }
            cnt = 0;
        }
        // 所有障碍前移
        for (int i = 0; i < otls.size(); i++) {
            Obstacle o = otls.get(i);
            // 还在界面内
            if (o.isLive()) {
                g.drawImage(o.image, o.x, o.y, this);
                o.move();
                // 碰撞检测
                if (o.getBounds().intersects(ds.getFootBounds()) || o.getBounds().intersects(ds.getHeadBounds())) {
                    Sound.hit();
                    finish = true;
                }
            // 不在界面内
            } else {
                otls.remove(i);
                i--;
            }
        }
        cnt += 5;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            ds.jump();
            Sound.jump();
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    @Override
    public void run() {
        while (!finish) {
            try {
                Thread.sleep(20);
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
