package com.ssydx.securtiy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.ssydx.securtiy.dao.RedisDao;
import com.ssydx.securtiy.dao.UserMapper;
import com.ssydx.securtiy.domain.User;
import com.ssydx.securtiy.redis.UserRedis;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    public void createUser(User user) {
        if (!inMemoryUserDetailsManager.userExists(user.getUsername())) {
            inMemoryUserDetailsManager.createUser(
                org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .roles(user.getAuthority())
                    .build()
            );
        }
    }
    public void deleteUser(String username) {
        if (inMemoryUserDetailsManager.userExists(username)) {
            inMemoryUserDetailsManager.deleteUser(username);
        }
    }
    public void updateUser(User user) {
        if (inMemoryUserDetailsManager.userExists(user.getUsername())) {
            inMemoryUserDetailsManager.updateUser(
                org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(user.getAuthority())
                .build()
            );
        }
    }
    public User getUser(String username) {
        if (inMemoryUserDetailsManager.userExists(username)) {
            UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(username);
            return new User(userDetails.getUsername(), userDetails.getPassword(), null, null);
        }
        return new User(null, null, null, null);
    }

    // @Autowired
    // private JdbcUserDetailsManager jdbcUserDetailsManager;
    // public void createUser(User user) {
    //     if (!jdbcUserDetailsManager.userExists(user.getUsername())) {
    //         jdbcUserDetailsManager.createUser(
    //             org.springframework.security.core.userdetails.User.builder()
    //                 .username(user.getUsername())
    //                 .password(passwordEncoder.encode(user.getPassword()))
    //                 .roles(user.getAuthority())
    //                 .build()
    //         );
    //     }
    // }
    // public void deleteUser(String username) {
    //     if (jdbcUserDetailsManager.userExists(username)) {
    //         jdbcUserDetailsManager.deleteUser(username);
    //     }
    // }
    // public void updateUser(User user) {
    //     if (jdbcUserDetailsManager.userExists(user.getUsername())) {
    //         jdbcUserDetailsManager.updateUser(
    //             org.springframework.security.core.userdetails.User.builder()
    //             .username(user.getUsername())
    //             .password(passwordEncoder.encode(user.getPassword()))
    //             .roles(user.getAuthority())
    //             .build()
    //         );
    //     }
    // }
    // public User getUser(String username) {
    //     if (jdbcUserDetailsManager.userExists(username)) {
    //         UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(username);
    //         return new User(userDetails.getUsername(), userDetails.getPassword(), null, null);
    //     }
    //     return new User(null, null, null, null);
    // }


    // @Autowired
    // private RedisDao redisDao;
    // @Autowired
    // private UserMapper userMapper;
    // public boolean isExist(String username) {
    //     if (redisDao.isExist(UserRedis.PREFIX, username)) {
    //         return true;
    //     }
    //     User user = userMapper.getUser(username);
    //     if (user != null) {
    //         redisDao.set(UserRedis.PREFIX, username, user, UserRedis.EXPIREDSECONDS);
    //         return true;
    //     }
    //     return false;
    // }
    // public void createUser(User user) {
    //     if (!isExist(user.getUsername())) {
    //         user.setEnabled(true);
    //         user.setPassword(passwordEncoder.encode(user.getPassword()));
    //         user.setAuthority("ROLE_" + user.getAuthority());
    //         userMapper.createUser(user);
    //         userMapper.createUserAuthority(user);
    //         redisDao.set(UserRedis.PREFIX, user.getUsername(), user, UserRedis.EXPIREDSECONDS);
    //     }
    // }
    // public User getUser(String username) {
    //     User user = redisDao.get(UserRedis.PREFIX, username, User.class);
    //     if (user == null) {
    //         user = userMapper.getUser(username);
    //         if (user != null) {
    //             redisDao.set(UserRedis.PREFIX, username, user, UserRedis.EXPIREDSECONDS);
    //         }
    //     }
    //     return user;
    // }



}
