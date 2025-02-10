package swing_test;

import java.awt.*;
import java.util.Locale;

import javax.swing.*;

public class Test1 {
    public static void main(String[] args) {
        JFrame jf1 = new JFrame("窗口标题");
        jf1.setLocation(1000, 500);
        jf1.setSize(300, 300);
        jf1.setBounds(1000,500,500,500);
        jf1.setBackground(Color.BLUE);
        jf1.setForeground(Color.GREEN);
        jf1.setVisible(true);
        
    }
}
