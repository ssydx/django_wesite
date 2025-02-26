package spring.hibernate;




import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


public class PeopleDao {
    HibernateTemplate template;
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    @Transactional(readOnly = false)
    public void insertPeo1(People p) {
        template.save(p);
    }
    @Transactional(readOnly = false)
    public void updatePeo1(People p) {
        template.update(p);
    }
    @Transactional(readOnly = false)
    public void deletePeo1(People p) {
        template.delete(p);
    }
    public People getById(int id) {
        return (People)template.get(People.class, id);
    }
    public List<People> getPeos() {
        return template.loadAll(People.class);
    }
}
