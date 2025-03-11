package com.ssydx.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao1 {
    @Autowired
    private DsProperty dsProperty;
    public List<UserDomain1> query1() {
        List<UserDomain1> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(dsProperty.getUrl(), dsProperty.getUsername(), dsProperty.getPassword())) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user_info");
            while (resultSet.next()) {
                list.add(new UserDomain1(resultSet.getInt(1), resultSet.getString("name"), resultSet.getInt("age")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
