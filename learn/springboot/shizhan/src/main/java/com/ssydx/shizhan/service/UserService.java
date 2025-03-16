package com.ssydx.shizhan.service;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssydx.shizhan.dao.UserMapper;
import com.ssydx.shizhan.domain.User;
import com.ssydx.shizhan.exception.MiaoshaException;
import com.ssydx.shizhan.redis.RedisUtil;
import com.ssydx.shizhan.redis.UserKey;
import com.ssydx.shizhan.result.CodeMsg;
import com.ssydx.shizhan.util.MD5Util;
import com.ssydx.shizhan.util.VercodeUtil;
import com.ssydx.shizhan.vo.LoginVo;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final RedisUtil redisUtil;
    public UserService(UserMapper userMapper, RedisUtil redisUtil) {
        this.userMapper = userMapper;
        this.redisUtil = redisUtil;
    }
    public BufferedImage createVerifyCode(String token) {
        if (token == null) {
            return null;
        }
        Random random = new Random();
        String verifyCode = VercodeUtil.generateVerifyCode(random);
        int rnd = VercodeUtil.calc(verifyCode);
        redisUtil.set(UserKey.verifyCode, token, rnd);
        return VercodeUtil.createVerifyImage(verifyCode,random);
    }
    public boolean checkVerifyCode(String token, int verifyCode) {
        if (token == null) {
            return false;
        }
        Integer codeOld = redisUtil.get(UserKey.verifyCode, token, Integer.class);
        if (codeOld == null || codeOld - verifyCode != 0) {
            return false;
        }
        redisUtil.delete(UserKey.verifyCode, token);
        return true;
    }
    @Transactional
    public User login(LoginVo loginVo) {
        if (loginVo == null) {
            throw new MiaoshaException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new MiaoshaException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPass = user.getPassword();
        String calcPass = MD5Util.passToDbPass(loginVo.getPassword(),user.getSalt());
        if (!calcPass.equals(dbPass)) {
            throw new MiaoshaException(CodeMsg.PASSWORD_ERROR);
        }
        user.setLoginCount(user.getLoginCount() + 1);
        user.setLastLoginDate(new Date());
        userMapper.update(user);
        return user;
    }
    private User getById(long id) {
        User user = redisUtil.get(UserKey.getById, "" + id, User.class);
        if (user != null) {
            return user;
        }
        user = userMapper.findById(id);
        if (user != null) {
            redisUtil.set(UserKey.getById, "" + id, user);
        }
        return user;
    }
}
