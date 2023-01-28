package org.example.spring.springmvcorm.user.dao.impl;

import org.example.spring.springmvcorm.user.dao.IUserDao;
import org.example.spring.springmvcorm.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

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
        return result;                                            // it returns the result back, which is an id
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

    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }


    @Override
    public void updateById(Integer id, User user) {
        User existingUser = hibernateTemplate.get(User.class, id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        hibernateTemplate.update(existingUser);
    }


    @Override
    public void deleteById(Integer id) {
        hibernateTemplate.delete(Objects.requireNonNull(hibernateTemplate.get(User.class, id)));
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
