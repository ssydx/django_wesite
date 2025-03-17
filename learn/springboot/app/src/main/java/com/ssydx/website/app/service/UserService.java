package com.ssydx.website.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssydx.website.app.dao.UserDao;
import com.ssydx.website.app.dao.UserMapper;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.domain.UserHash;
import com.ssydx.website.app.vo.UserVo;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;


    private UserHash getUserHash(String name) {
        Optional<UserHash> optionalUserHash = userDao.findByName(name);
        if (optionalUserHash.isEmpty()) {
            User user = userMapper.findByName(name);
            if (user != null) {
                UserHash userHash = new UserHash(user.getUserName(), user.getUserPwd(), 3600L);
                userDao.save(userHash);
                return userHash;
            } else {
                return null;
            }

        } else {
            return optionalUserHash.get();
        }
    }

    public String isExistUser(UserVo userVo) {
        UserHash userHash = this.getUserHash(userVo.getName());
        if (userHash == null) {
            return "用户不存在";
        }
        if (userHash.getPwd().equals(userVo.getPwd())) {
            return "验证成功";
        }
        return "密码错误";
    }

}
