package practice.Dinosaur_test;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundImage {
    public BufferedImage paper;
    private Graphics2D pen;
    private BufferedImage image1, image2;
    private int x1, x2;
    BackgroundImage() {
        try {
            image1 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\背景.png"));
            image2 = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\image\\背景2.png"));
        } catch (Exception e) {
            System.out.println("背景图片未找到");
        }
        paper = new BufferedImage(800, 300, BufferedImage.TYPE_INT_RGB);
        pen = paper.createGraphics();
        x1 = 0;
        x2 = 800;
        pen.drawImage(image1, 0, 0, null);
    }
    public void roll() {
        if(x1 <= -800) {
            x1 = 800;
        }
        if(x2 <= -800) {
            x2 = 800;
        }
        x1 -= 5;
        x2 -= 5;
        pen.drawImage(image1, x1, 0, null);
        pen.drawImage(image2, x2, 0, null);
    }
}
