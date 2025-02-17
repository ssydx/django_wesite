package Dinosaur_test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameJPanel extends JPanel implements KeyListener {
    BufferedImage image;
    int x = 0;
    class myThread extends Thread {
        GameJPanel panel;
        myThread(GameJPanel panel) {
            this.panel = panel;
        }
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                    panel.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public GameJPanel() {
        setBackground(Color.GREEN);
        new myThread(this).start();;
    }
    public void paint(Graphics g) {
        g.drawString("这是文字", 50, 50);
        try {
            image = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\背景.png"));
        } catch (Exception e) {
            System.out.println("图片载入失败");
        }
        x--;
        if (x < -500) {
            x = 0;
        }
        g.drawImage(image, x, 0, this);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            System.out.println("跳跃");
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
