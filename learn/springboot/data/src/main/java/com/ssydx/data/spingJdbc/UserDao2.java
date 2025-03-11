package com.ssydx.data.spingJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao2 {
    @Autowired
    private JdbcTemplate template;
    // @Autowired
    // private NamedParameterJdbcTemplate namedTemplate;
    // @Autowired
    // private SimpleJdbcInsert  jdbcInsert;
    // @Autowired
    // private SimpleJdbcCall jdbcCall;

    public int insert1(UserDomain2 userDomain) {
        return template.update("insert into user_info(name,desc,score) values(?,?,?)", userDomain.getName(),userDomain.getDesc(),userDomain.getScore());
    }
    public int insert2(UserDomain2 userDomain) {
        return template.update("insert into user_info(name,desc,score) values(?,?,?)", ps -> {
            ps.setString(1, userDomain.getName());
            ps.setString(2, userDomain.getDesc());
            ps.setDouble(3, userDomain.getScore());
        });
    }
    public int insert3(UserDomain2 userDomain) {
        String sql = "insert into user_info(name,desc,score) values(?,?,?)";
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, userDomain.getName());
                ps.setString(2, userDomain.getDesc());
                ps.setDouble(3, userDomain.getScore());
            }
        };
        return template.update(sql, pss);
    }
    public int insert4(UserDomain2 userDomain) {
        return template.update((Connection conn )-> {
            PreparedStatement ps = conn.prepareStatement("insert into user_info(name,desc,score) values(?,?,?)");
            ps.setString(1, userDomain.getName());
            ps.setString(2, userDomain.getDesc());
            ps.setDouble(3, userDomain.getScore());
            return ps;
        });
    }
    public int insert5(UserDomain2 userDomain) {
        String sql = "insert into user_info(name,desc,score) values(?,?,?)";
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, userDomain.getName());
                ps.setString(2, userDomain.getDesc());
                ps.setDouble(3, userDomain.getScore());
                return ps;
            }
        };
        return template.update(psc);
    }
    public int insert6(UserDomain2 userDomain) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
            (Connection conn ) -> {
                PreparedStatement ps = conn.prepareStatement("insert into user_info(name,desc,score) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, userDomain.getName());
                ps.setString(2, userDomain.getDesc());
                ps.setDouble(3, userDomain.getScore());
                return ps;
            },
            keyHolder
        );
        return keyHolder.getKey().intValue();
    }
    public int insert7(UserDomain2 userDomain) {
        return template.update("insert into user_info(name,desc,score) values(?,?,?)",new Object[]{userDomain.getName(),userDomain.getDesc(),userDomain.getScore()},new int[]{Types.VARCHAR,Types.LONGNVARCHAR,Types.DOUBLE});
    }
    public int delete1(List<String> names) {
        return Arrays.stream(template.batchUpdate("delete from user_info where name = ?",names.stream().map(e -> new Object[]{e}).toList())).sum();
    }
    public Object[] udpate1(List<UserDomain2> userDomains) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.batchUpdate(
            new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                    return conn.prepareStatement("update user_info set name = ?,desc = ?,score = ? where id = ?",PreparedStatement.RETURN_GENERATED_KEYS);
                }
            },
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    UserDomain2 userDomain = userDomains.get(i);
                    ps.setString(1,userDomain.getName());
                    ps.setString(2,userDomain.getDesc());
                    ps.setDouble(3,userDomain.getScore());
                    ps.setInt(4, userDomain.getId());
                }
                @Override
                public int getBatchSize() {
                    return userDomains.size();
                }
            },
            keyHolder
        );
        return keyHolder.getKeys().values().toArray();
    }
    public List<UserDomain2> query1() {
        return template.query("select * from user_info", new RowMapper<UserDomain2>() {
            @Override
            public UserDomain2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new UserDomain2(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getDouble("score"));
            }
        });
    }

}
