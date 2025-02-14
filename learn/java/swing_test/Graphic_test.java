package swing_test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Graphic_test {
    public static void main(String[] args) {
        class MyPanel1 extends JPanel {
            @Override
            public void paintComponent(Graphics g) {
                g.translate(10, 10);
                System.out.println(g.getClipBounds());
                g.setColor(Color.ORANGE);
                g.drawOval(50, 50, 200, 100);
                g.drawArc(50, 0, 200, 100, 90, -90);
                g.drawLine(0, 0, 100, 100);
                g.drawPolygon(new int[]{10,50,100,200}, new int[]{100,150,50,20}, 4);
                g.drawRect(150, 150, 50, 50);
                g.drawRoundRect(250, 150, 50, 100, 50,50);
                g.drawString("这是文本", 200, 100);
            }
        }
        // class MyPanel1 extends JPanel {
        //     @Override
        //     public void paintComponent(Graphics g) {
        //         g.fillOval(50, 50, 200, 100);
        //         g.fillArc(50, 0, 200, 100, 90, -90);
        //         g.setColor(Color.GREEN);
        //         g.fillPolygon(new int[]{10,50,100,200}, new int[]{100,150,50,20}, 4);
        //         g.fillRect(150, 150, 50, 50);
        //         g.fillRoundRect(250, 150, 50, 100, 50,50);
        //     }
        // }
        MyPanel1 mp = new MyPanel1();
        JFrame jf = new JFrame();
        jf.add(mp);
        jf.setBounds(100, 100, 500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
