package org.example.spring.springmvcorm.user.dao.impl;

import org.example.spring.springmvcorm.user.dao.IUserDao;
import org.example.spring.springmvcorm.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// it is going to do all the DB work and needs the transactional support (use @Repository)
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int create(User user) {
        Integer result = (Integer) hibernateTemplate.save(user);    // template saves the object into DB
        String sql = "SELECT * FROM users";
        // ** check **
        //List<User> xxx = getHibernateTemplate().find(sql);    https://stackoverflow.com/questions/8612933/how-to-write-hibernate-template-query-from-the-sql-query
        // ** check **
        return result;                                              // it returns the result back, which is an id
    }

    @Override
    public List<User> findUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

    // AJAX & jQuery
    @Override
    public User findUser(Integer id) {
        return hibernateTemplate.get(User.class, id);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
