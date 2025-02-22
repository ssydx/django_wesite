package practice.Dinosaur_test;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacle {
    public int x, y;
    public BufferedImage image;
    private BufferedImage image1, image2;
    Obstacle() {
        try {
            image1 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\石头.png"));
            image2 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\仙人掌.png"));
        } catch (Exception e) {
            System.out.println("障碍图片未找到");
        }
        if (new Random().nextInt(2) == 0) {
            image = image1;
        } else {
            image = image2;
        }
        x = 800;
        y = 195 - image.getHeight();
    }
    public void move() {
        x -= 5;
    }
    public boolean isLive() {
        if (x <= -image.getWidth()) {
            return false;
        } else {
            return true;
        }
    }
    public Rectangle getBounds() {
        if (image == image2) {
            return new Rectangle(x + 7, y, 15, image.getHeight());
        }
        return new Rectangle(x + 5, y + 4, 23, 21);
    }
}
