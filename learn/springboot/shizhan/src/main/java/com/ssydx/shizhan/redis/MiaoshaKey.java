package com.ssydx.shizhan.redis;

public class MiaoshaKey extends AbstractPrefix {
    public MiaoshaKey(int expireSeconds, String prefix) {
        super(expireSeconds,prefix);
    }
    public static MiaoshaKey miaoshaVerifyCode = new MiaoshaKey(300, "vc");
    public static MiaoshaKey miaoshaPath = new MiaoshaKey(60, "mp");
    public static MiaoshaKey isItemOver = new MiaoshaKey(0, "over");
}
