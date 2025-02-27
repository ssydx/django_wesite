package spring.mvcbase;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao2 {
    private JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public List<Employee> getByPage(int offset,int num) {
        return template.query("select * from tb1 limit ?,?", new Object[]{offset,num}, (res, cnt) -> {
            Employee e = new Employee();
            e.setId(res.getInt(1));
            e.setName(res.getString(2));
            e.setAge(res.getInt(3));
            return e;
        });
    }
}
