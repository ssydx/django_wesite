package Dinosaur_test;

import java.io.File;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class MusicPlayer implements Runnable {
    File file;
    boolean cir;
    Thread thread;
    MusicPlayer(String path, boolean cir) throws FileNotFoundException {
        this.cir = cir;
        file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("音频文件未找到");
        }
    }
    public void run() {
        byte[] barr = new byte[1024 * 128];
        do {
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                AudioFormat f = ais.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, f);
                SourceDataLine ln = (SourceDataLine) AudioSystem.getLine(info);
                ln.open(f);
                ln.start();
                int byteCount = 0;
                while (byteCount != -1) {
                    byteCount = ais.read(barr, 0, barr.length);
                    if (byteCount >= 0) {
                        ln.write(barr, 0, byteCount);
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (cir);
    }
    public void play() {
        thread = new Thread(this);
        thread.start();
    }
    public void stop() {
        thread.stop();
    }
}
