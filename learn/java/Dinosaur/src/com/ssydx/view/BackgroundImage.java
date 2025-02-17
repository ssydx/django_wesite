package Dinosaur.src.com.ssydx.view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundImage {
    public BufferedImage image;
    private BufferedImage image1,image2;
    private Graphics2D g;
    public int x1,x2;
    public static final int SPEED = 4;
    public BackgroundImage() {
        try {
            image1 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\背景.png"));
            image2 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\背景2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        image = new BufferedImage(800, 300, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
        x1 = 0;
        x2 = 800;
        g.drawImage(image1, x1, 0, null);
    }
    public void roll() {
        x1 -= SPEED;
        x2 -= SPEED;
        if (x1 <= -800) {
            x1 = 800;
        }
        if (x2 <= -800) {
            x2 = 800;
        }
        g.drawImage(image1, x1, 0, null);
        g.drawImage(image2, x2, 0, null);
    }
}
