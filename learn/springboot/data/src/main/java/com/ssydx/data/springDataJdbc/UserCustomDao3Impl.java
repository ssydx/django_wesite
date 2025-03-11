package com.ssydx.data.springDataJdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

public class UserCustomDao3Impl implements UserCustomDao3 {
    @Autowired
    private JdbcAggregateTemplate template;

    @Override
    public List<UserDomain3> custom() {
        return template.findAll(UserDomain3.class);
    }
}
