package com.ssydx.website.app;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.website.app.dao.ClazzMapper;
import com.ssydx.website.app.dao.MiaoshaOrderMapper;
import com.ssydx.website.app.dao.MiaoshaProductMapper;
import com.ssydx.website.app.dao.OrderMapper;
import com.ssydx.website.app.dao.ProductMapper;
import com.ssydx.website.app.dao.UserMapper;
import com.ssydx.website.app.domain.Clazz;
import com.ssydx.website.app.domain.MiaoshaOrder;
import com.ssydx.website.app.domain.Order;
import com.ssydx.website.app.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
// @MybatisTest
public class TestMyBatis {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ClazzMapper clazzMapper;

    @Test
    public void testFindAll() {
        userMapper.findAll().forEach(System.out::println);
    }
    @Test
    public void testSave() {
        Clazz clazz = clazzMapper.findById(2);
        User user = new User().setUserName("shisan").setUserPwd("shisan").setUserRegisterDate(new Date()).setUserLastLoginDate(new Date()).setUserLoginCount(1).setClazz(clazz);
        userMapper.save(user);
        System.out.println(user.getUserId());
        testFindAll();
    }
    @Test
    public void testRemove() {
        userMapper.remove(3L);
        testFindAll();
    }
    @Test
    public void testUpdate() {
        Clazz clazz = clazzMapper.findById(2);
        userMapper.update(new User(1L,"zhangsan","zhangsan1",new Date(),new Date(),2,clazz));
        testFindAll();
    }
    @Test
    public void testFind() {
        System.out.println(userMapper.find(2L));
    }
    @Test
    public void testFindAll1() {
        userMapper.findAll1().forEach(System.out::println);
    }
    @Test
    public void testFind1() {
        System.out.println(userMapper.find1(2L));
    }
    @Test
    public void testSave1() {
        Clazz clazz = clazzMapper.findById(2);
        User user = new User().setUserName("shisan").setUserPwd("shisan").setUserRegisterDate(new Date()).setUserLastLoginDate(new Date()).setUserLoginCount(1).setClazz(clazz);
        userMapper.save(user);
        System.out.println(user.getUserId());
        testFindAll();
    }
    @Test
    public void testRemove1() {
        userMapper.remove(3L);
        testFindAll();
    }
    @Test
    public void testUpdate1() {
        Clazz clazz = clazzMapper.findById(2);
        userMapper.update(new User(1L,"zhangsan","zhangsan1",new Date(),new Date(),2,clazz));
        testFindAll();
    }
    @Test
    public void testFindById() {
        System.out.println(clazzMapper.findById(2));
    }
    @Test
    public void testFindByClazzId() {
        userMapper.findByClazzId(1).forEach(System.out::println);
    }
    @Test
    public void testFindAllUsers() {
        clazzMapper.findAllUsers().forEach(System.out::println);
    }

    @Autowired
    private ProductMapper productMapper;
    @Test
    public void testFindAllProducts() {
        productMapper.findAll().forEach(System.out::println);
    }

    @Autowired
    private MiaoshaProductMapper miaoshaProductMapper;
    @Test
    public void testFindAllMiaoshaProducts() {
        miaoshaProductMapper.findAll().forEach(System.out::println);
        System.out.println(miaoshaProductMapper.findAll().get(0).getProduct_desc());;
    }

    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void testOrder() {
        orderMapper.save(new Order().setUser_id(1L).setProduct_id(1L).setProduct_name("aaa"));
        System.out.println(orderMapper.findByIdAndOwnerId(1, 1));
    }
    @Autowired
    private MiaoshaOrderMapper miaoshaOrderMapper;
    @Test
    public void testMiaoshaOrder() {
        orderMapper.save(new Order().setUser_id(1L).setProduct_id(1L).setProduct_name("aaa"));
        miaoshaOrderMapper.save(new MiaoshaOrder().setOrder_id(1L).setProduct_id(1L).setUser_id(1L));
        System.out.println(miaoshaOrderMapper.findByUserIdItemId(1, 1));
    }
}
