package com.ssydx.website.app.service;

import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssydx.website.app.dao.UserMapper;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.UserRedis;
import com.ssydx.website.app.redis.VercodeRedis;
import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.util.VercodeUtil;
import com.ssydx.website.app.vo.UserVo;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisDao redisDao;

    public User getUser(String name) {
        User user = redisDao.get(UserRedis.prefix, name, User.class);
        if (user != null) {
            return user;
        }
        user = userMapper.findByName(name);
        if (user != null) {
            redisDao.set(UserRedis.prefix, name, user, UserRedis.expiredSeconds);
            return user;
        } else {
            return null;
        }
    }

    public String isExistUser(UserVo userVo) {
        User user = this.getUser(userVo.getName());
        if (user == null) {
            return "用户不存在";
        }
        if (user.getUserPwd().equals(userVo.getPwd())) {
            return "验证成功";
        }
        return "密码错误";
    }

    public BufferedImage setVercode(String sessionId) {
        VercodeUtil vercode = new VercodeUtil();
        BufferedImage image = vercode.createVercode();
        redisDao.set(VercodeRedis.prefix, sessionId, vercode.calcVercode(), VercodeRedis.expiredSeconds);
        return image;
    }
    public Boolean checkVercode(String sessionId, int vercode) {
        Integer value = redisDao.get(VercodeRedis.prefix, sessionId, Integer.class);
        redisDao.delete(VercodeRedis.prefix, sessionId);
        if (value != null && value - vercode == 0) {
            return true;
        }
        return false;
    }
}
