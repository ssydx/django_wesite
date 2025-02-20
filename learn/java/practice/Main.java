package practice;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        LikeRecorder recorder = new LikeRecorderImpl();

        recorder.like("zs");
        recorder.like("zs");
        recorder.like("ls");
        recorder.like("ww");

        System.out.println(Arrays.toString(recorder.getLikeUsers()));
    }

}

/**
 * 点赞记录器
 */
interface LikeRecorder {

    /**
     * 若用户没有点赞过，则记录此次点赞行为。
     * 若用户曾经点赞过，则删除用户点赞记录。
     *
     * @param username 用户名
     */
    void like(String username);

    /**
     * 返回所有点赞的用户名
     *
     * @return 用户名数组
     */
    String[] getLikeUsers();

}

class LikeRecorderImpl implements LikeRecorder {

    // write your code here......
    private HashSet<String> set = new HashSet<String>();
    public void like(String username) {
        set.add(username);
    }
    public String[] getLikeUsers() {
        String[] strs = new String[set.size()];
        set.toArray(strs);
        return strs;
    }

}