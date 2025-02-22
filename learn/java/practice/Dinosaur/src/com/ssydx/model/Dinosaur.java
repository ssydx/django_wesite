package practice.Dinosaur.src.com.ssydx.model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import practice.Dinosaur.src.com.ssydx.service.FreshThread;
import practice.Dinosaur.src.com.ssydx.service.Sound;

public class Dinosaur {
    public BufferedImage image;
    private BufferedImage image1,image2,image3;
    public int x,y;
    private int jumpValue = 0;
    private boolean jumpState = false;
    private int stepTimer = 0;
    private final int JUMP_HIGHT = 100,LOWEST_Y = 120,FREASH = FreshThread.FREASH;

    // 初始化
    public Dinosaur() {
        x = 50;
        y = LOWEST_Y;
        try {
            image1 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\恐龙1.png"));
            image2 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\恐龙2.png"));
            image3 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\恐龙3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 踏步
    private void step() {
        int tmp = stepTimer / 250 % 3;
        switch (tmp) {
            case 1:
                image = image1;
                break;
            case 2:
                image = image2;
                break;
        
            default:
                image = image3;
                break;
        }
        stepTimer += FREASH;
    }
    // 跳跃
    public void jump() {
        if (!jumpState) {
            Sound.jump();
        }
        jumpState = true;
    }
    // 动作
    public void move() {
        step();
        if (jumpState) {
            if (y >= LOWEST_Y) {
                jumpValue = -4;
            }
            if (y <= LOWEST_Y-JUMP_HIGHT) {
                jumpValue = 4;
            }
            y += jumpValue;
            if (y >= LOWEST_Y) {
                jumpState = false;
            }
        }
    }
    // 恐龙脚部外框
    public Rectangle getFootBounds() {
        return new Rectangle(x + 30, y + 59, 29, 18);
    }
    // 恐龙头部外框
    public Rectangle getHeadBounds() {
        return new Rectangle(x + 66, y + 25, 32, 22);
    }
}
