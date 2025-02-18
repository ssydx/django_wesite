package Dinosaur_test;

public class Sound {
    static final String DIR = "C:\\Users\\ssydx\\Desktop\\学习\\GIT\\django_wesite\\learn\\java\\Dinosaur\\music\\",BACKGROUND = "background.wav",JUMP = "jump.wav",HIT = "hit.wav";
    private static void play(String file, boolean circulate) {
        try {
            MusicPlayer player = new MusicPlayer(file, circulate);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static public void jump() {
        play(DIR + JUMP, false);
    }
    static public void hit() {
        play(DIR + HIT, false);
    }
    static public void background() {
        play(DIR + BACKGROUND, true);
    }
}
