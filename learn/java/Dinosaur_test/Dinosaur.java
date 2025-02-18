package Dinosaur_test;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Dinosaur {
    // 图片
    public BufferedImage image;
    private BufferedImage image1, image2, image3;
    // 图片位置
    public int x = 50;
    public int y = 110;
    // 计时器
    private long time = 0;
    // 跳跃方向
    private int val = 0;
    // 跳跃标志
    private boolean flag = false;
    Dinosaur() {
        try {
            image1 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\恐龙1.png"));
            image2 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\恐龙2.png"));
            image3 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\恐龙3.png"));
        } catch (Exception e) {
            System.out.println("恐龙图片未找到");
        }
    }
    // 走
    public void step() {
        switch (time / 250 % 3) {
            case 1l:
                image = image1;
                break;
            case 2l:
                image = image2;
                break;
        
            default:
                image = image3;
                break;
        }
        time += 20;
    }
    // 跳
    public void jump() {
        flag = true;
    }
    // 动作，注意体会
    public void move() {
        if (flag) {
            if (y >= 110) {
                val = -4;
            }
            if (y <= -10) {
                val = 4;
            }
            y += val;
            if (y >= 110) {
                flag = false;
            }
        } else {
            step();
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
