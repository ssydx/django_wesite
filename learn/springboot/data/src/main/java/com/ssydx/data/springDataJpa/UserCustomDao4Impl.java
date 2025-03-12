package com.ssydx.data.springDataJpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;

public class UserCustomDao4Impl implements UserCustomDao4 {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<UserDomain4> myfindAll() {
        return entityManager.createQuery("select u from User4 u", UserDomain4.class).getResultList();
    }
}
