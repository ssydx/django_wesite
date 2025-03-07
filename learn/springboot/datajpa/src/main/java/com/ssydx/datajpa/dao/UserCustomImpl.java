package com.ssydx.datajpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssydx.datajpa.domain.User;

import jakarta.persistence.EntityManager;

public class UserCustomImpl implements UserCustom {
    @Autowired
    private EntityManager em;
    @Override
    public List<User> customJPQL(String name) {
        return em.createQuery("select u from User u where u.name = ?1",User.class).setParameter(1, name).getResultList();
    }
    @Override
    public List<User> customSQL(String name) {
        return em.createNativeQuery("select * from user_info where name = :name",User.class).setParameter("name", name).getResultList();
    }
}
