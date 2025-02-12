package swing_test;

import java.awt.*;
import java.util.Locale;

import javax.swing.*;

public class Test2 {
    public static void main(String[] args) {
        JFrame jf = new JFrame();

        // Component

        // 不具备视觉效果，仅作为标记
        jf.setName("ssydx");
        System.out.println("名字：" + jf.getName());

        // 位置尺寸
        Point p = new Point(100, 100);
        jf.setLocation(p);
        Dimension d = new Dimension(300, 300);
        jf.setSize(d);
        jf.setBounds(150, 150, 500, 300);
        System.out.println("X坐标：" + jf.getX());
        System.out.println("X坐标：" + jf.getY());
        System.out.println("XY坐标：" + jf.getLocation());
        System.out.println("高度：" + jf.getHeight());
        System.out.println("宽度：" + jf.getWidth());
        System.out.println("高宽度：" + jf.getSize());
        System.out.println("位置尺寸：" + jf.getBounds());

        // 颜色
        Container jfp = jf.getContentPane();// 直接设置顶级容器的颜色是无效的，要取其内部容器
        Color c = new Color(200, 100, 50, 128);
        jfp.setBackground(c);
        jfp.setForeground(Color.BLUE); // 顶级容器的前景色通常没有意义
        System.out.println(jf.getBackground());

        // 光标
        Cursor cur = new Cursor(4);
        jf.setCursor(cur);
        System.out.println(jf.getCursor());
        jf.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 字体，容器的字体无意义
        Font f = new Font(Font.SANS_SERIF, Font.ITALIC, 16);
        jfp.setFont(f);
        jf.setFont(f);
        System.out.println(jf.getFont());

        // 最大最小化，往往不起效果
        jf.setMaximumSize(new Dimension(1000,500));
        System.out.println(jf.getMaximumSize());
        jf.setMinimumSize(new Dimension(100,50));
        System.out.println(jf.getMinimumSize());

        // 本地化，不起效，只对颜色日期等组件或本地化资源包起效
        jf.setLocale(Locale.ENGLISH);
        System.out.println(jf.getLocale());

        // 组件是否可交互（可用）
        jf.setEnabled(true);
        // 组件是否可获得焦点
        jf.setFocusable(false);

        System.out.println(jf.getParent());
        System.out.println(jf.getToolkit());

        // setMixingCutoutShape
        // setFocusTraversalKeys
        // setFocusTraversalKeysEnabled
        // setDropTarget
        // setPreferredSize
        // setIgnoreRepaint

        // Container

        jf.setAlwaysOnTop(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
