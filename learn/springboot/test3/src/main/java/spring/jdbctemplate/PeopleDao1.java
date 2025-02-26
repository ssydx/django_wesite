package spring.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class PeopleDao1 {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int savePeo(People p) {
        String query = "insert into tb1 values('" + p.getId() + "','" + p.getName() + "','" + p.getAge() + "')";
        return jdbcTemplate.update(query);
    }
    public int updatePeo(People p) {
        String query = "update tb1 set name=?,age=? where id=?";
        return jdbcTemplate.update(query,p.getName(),p.getAge(),p.getId());
    }
    public int deletePeo(People p) {
        String query = "delete from tb1 where id=?";
        return jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, p.getId());
            }
        });
    }
    // 预执行语句
    public boolean insertPeo1(People p) {
        String query = "INSERT INTO tb1 VALUES(?,?,?)";
        return jdbcTemplate.execute(
            query, 
            new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setInt(1,p.getId());
                    ps.setString(2,p.getName());
                    ps.setInt(3, p.getAge());
                    return ps.execute();
                }
        });
    }
    // 获取结果集
    public List<People> getPeo1() {
        String query = "Select * From tb1";
        return jdbcTemplate.query(
            query, 
            new ResultSetExtractor<List<People>>() {
                @Override
                public List<People> extractData(ResultSet res) throws SQLException, DataAccessException {
                    List<People> ls = new ArrayList<People>();
                    while (res.next()) {
                        ls.add(new People(res.getInt(1),res.getString(2),res.getInt(3)));
                    }
                    return ls;
                }
        });
    }
    // 获取结果集更简单的方法
    public List<People> getPeo2() {
        return jdbcTemplate.query(
            "SELECT * FROM tb1 WHERE id <= ?", 
            new RowMapper<People>() {
                @Override
                public People mapRow(ResultSet res, int rownumber) throws SQLException {
                    return new People(res.getInt(1),res.getString(2),res.getInt("age"));
                }
            }, 
        3
        );
    }
}
