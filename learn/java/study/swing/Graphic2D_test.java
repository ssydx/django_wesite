package study.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Graphic2D_test {
    public static void main(String[] args) {
        // class MyPanel1 extends JPanel {
        //     @Override
        //     public void paintComponent(Graphics g) {
        //         Graphics2D g1 = (Graphics2D)g;
        //         g1.translate(10, 10);
        //         g1.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        //         g1.setColor(Color.ORANGE);
        //         g1.drawOval(50, 50, 200, 100);
        //         g1.drawArc(50, 0, 200, 100, 90, -90);
        //         g1.drawLine(0, 0, 100, 100);
        //         g1.drawPolygon(new int[]{10,50,100,200}, new int[]{100,150,50,20}, 4);
        //         g1.drawRect(150, 150, 50, 50);
        //         g1.drawRoundRect(250, 150, 50, 100, 50,50);
        //         g1.setFont(new Font(Font.SERIF,Font.ITALIC,32));
        //         g1.drawString("这是文本", 200, 100);
        //         g1.draw(new Rectangle2D.Double(100,100,100,100));
        //         g1.fill(new Rectangle2D.Double(150,150,100,100));

        //     }
        // }
        class MyPanel1 extends JPanel {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g1 = (Graphics2D)g;
                g1.rotate(Math.toRadians(5));
                g1.shear(0.3, 0);
                Image img;
                try {
                    img = ImageIO.read(new File("C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\swing_test\\src\\cywl.png"));
                    g1.drawImage(img, 0, 0, 200,200,this);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        MyPanel1 mp = new MyPanel1();
        JFrame jf = new JFrame();
        jf.add(mp);
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
