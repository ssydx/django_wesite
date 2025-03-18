package com.ssydx.website.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.dao.UserMapper;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.UserRedis;
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
        } else {
            user = userMapper.findByName(name);
            if (user != null) {
                redisDao.set(UserRedis.prefix, name, user, UserRedis.expiredSeconds);
                return user;
            } else {
                return null;
            }
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
}
