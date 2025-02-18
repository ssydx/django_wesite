package awt_test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {
    // @Override
    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     g.drawString("123", 20, 20);
    // }
    // @Override
    // protected void paintBorder(Graphics g) {
    //     g.setColor(Color.BLUE);
    //     g.drawRect(10, 10, 100, 100);
    // }
    // @Override
    // protected void paintChildren(Graphics g) {
    //     g.drawString("1", 0, 0);
    // }
    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(500, 300, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D big = bi.createGraphics();
        try {
            big.drawImage(ImageIO.read(new File("C:\\\\Users\\\\ssydx\\\\Desktop\\\\学习\\\\GIT\\\\django_wesite\\\\learn\\\\java\\\\Dinosaur\\\\image\\\\背景.png")), 0,0, this);
        } catch (Exception e) {
            // TODO: handle exception
        }
        g.drawImage(bi,0,0,this);
    }
}

public class Test1 extends JFrame {
    Test1() {
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,500,300);
        setTitle("测试");
        Container c = getContentPane();
        MyPanel mp = new MyPanel();
        c.add(mp);
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.setVisible(true);
    }
}
