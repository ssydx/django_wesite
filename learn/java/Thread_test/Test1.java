package Thread_test;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
class SwingAndThread extends JFrame {
    int cnt = 0;
    public SwingAndThread() {
        setBounds(100, 100, 500, 300);
        Container c = getContentPane();
        c.setLayout(null);
        JLabel jl =  new JLabel(new ImageIcon(Test1.class.getResource("src/呵护.jpeg")));
        jl.setBounds(0, 10, 200, 200);
        c.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    jl.setBounds(cnt, 10, 200, 200);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    cnt += 1;
                    if ( cnt >= 300) {
                        cnt = 0;
                    }
                }
            }
        };
        t.start();
    }
}

class Thread3 extends JFrame {
    private Thread threadA;
    private Thread threadB;
    private JProgressBar jpb1 = new JProgressBar();
    private JProgressBar jpb2 = new JProgressBar();
    public Thread3() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        getContentPane().add(jpb1, BorderLayout.NORTH);
        getContentPane().add(jpb2, BorderLayout.SOUTH);
        setVisible(true);
        jpb1.setStringPainted(true);
        jpb2.setStringPainted(true);
        threadA = new Thread(new Runnable() {
            int cnt = 0;
            public void run() {
                while (true) {
                    jpb1.setValue(++cnt);
                    try {
                        Thread.sleep(100);
                        threadB.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int cnt = 0;
            public void run() {
                while (true) {
                    jpb2.setValue(++cnt);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (cnt == 100) {
                        break;
                    }
                }
            }                
        });
        threadB.start();
    }
}


public class Test1 {
    public static void main(String[] args) {
        // Thread1 t1 = new Thread1();
        // t1.start();
        // new SwingAndThread();
        new Thread3();
    }
}
