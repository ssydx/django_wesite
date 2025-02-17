package Dinosaur.src.com.ssydx.service;

import java.awt.Container;

import Dinosaur.src.com.ssydx.view.GamePanel;
import Dinosaur.src.com.ssydx.view.MainFrame;
import Dinosaur.src.com.ssydx.view.ScoreDialog;

public class FreshThread extends Thread {
    public static final int FREASH = 20;
    GamePanel p;
    public FreshThread(GamePanel p) {
        this.p = p;
    }
    public void run() {
        while (!p.isFinish()) {
            p.repaint();
            try {
                Thread.sleep(FREASH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Container c = p.getParent();
        while (!(c instanceof MainFrame)) {
            c = c.getParent();
        }
        MainFrame frame = (MainFrame) c;
        new ScoreDialog(frame);
        frame.restart();
    }
}
