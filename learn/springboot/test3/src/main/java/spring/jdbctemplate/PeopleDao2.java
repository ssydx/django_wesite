package spring.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;



public class PeopleDao2 {
    private NamedParameterJdbcTemplate template;
    public void setTemplate(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    public int insertPeo2(People p) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", p.getId());
        map.put("name", p.getName());
        map.put("age", p.getAge());
        return template.execute(
            "insert into tb1 values(:id,:name,:age)", 
            map, 
            new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps)
                throws SQLException, DataAccessException {
                    return ps.executeUpdate();
                }
            }
        );
    }
}
