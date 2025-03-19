package com.ssydx.website.app.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import net.objecthunter.exp4j.ExpressionBuilder;

public class VercodeUtil {
    private String exp = "";
    private char[] chars = {'+','-','*'};
    public BufferedImage createVercode() {
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            exp += random.nextInt(10) + 1;
            exp += chars[random.nextInt(3)];
        }
        exp += random.nextInt(10) + 1;
        int width = 120;
        int height = 32;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);
        for (int i = 0; i < 10; i++) {
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.drawOval(random.nextInt(width), random.nextInt(height), random.nextInt(width / 5), random.nextInt(height / 3));
        }
        g.setColor(Color.RED);
        g.setFont(new Font("Candara", Font.BOLD, 24));
        g.drawString(exp, 8, 24);
        g.dispose();
        return image;
    }
    public Integer calcVercode() {
        try {
            ExpressionBuilder expression = new ExpressionBuilder(exp);
            return (int)(expression.build().evaluate());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
