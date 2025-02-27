package spring.mvcbase;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
    private JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int insert(Employee e) {
        return template.update("insert into tb1 values(?,?,?)", e.getId(),e.getName(),e.getAge());
    }
    public int update(Employee e) {
        return template.update("update tb1 set name=?,age=? where id=?", e.getName(),e.getAge(),e.getId());
    }
    public int delete(int id) {
        return template.update("delete from tb1 where id=?", id);
    }
    public Employee getById(int id) {
        return template.queryForObject("select * from tb1 where id=?", new Object[]{id}, (res,rc) -> {
            Employee e = new Employee();
            e.setId(res.getInt(1));
            e.setName(res.getString(2));
            e.setAge(res.getInt(3));
            return e;
        });
    }
    public List<Employee> getEmps() {
        return template.query("select * from tb1", (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setAge(rs.getInt("age"));
            return employee;
        });
    }
}
