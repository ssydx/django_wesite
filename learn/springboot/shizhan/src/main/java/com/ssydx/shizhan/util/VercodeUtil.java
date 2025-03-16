package com.ssydx.shizhan.util;

import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class VercodeUtil {
    private static final char[] ops = {'+','-','*'};
    public static String generateVerifyCode(Random random) {
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int num3 = random.nextInt(10) + 1;
        int num4 = random.nextInt(10) + 1;
        var opsLen = ops.length;
        char op1 = ops[random.nextInt(opsLen)];
        char op2 = ops[random.nextInt(opsLen)];
        char op3 = ops[random.nextInt(opsLen)];
        return "" + num1 + op1 + num2 + op2 + num3 + op3 + num4;
    }
    public static BufferedImage createVerifyImage(String verifyCode, Random random) {
        var width = 120;
        var height = 32;
        var image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.decode("0xDCDCDC"));
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height -1);
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        g.setColor(new Color(0,100,0));
        g.setFont(new Font("Candara", Font.BOLD, 24));
        g.drawString(verifyCode, 8, 24);
        g.dispose();
        return image;
    }
    public static int calc(String exp) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            return (Integer) engine.eval(exp);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
