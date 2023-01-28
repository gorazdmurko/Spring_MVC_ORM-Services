package org.example.spring.springmvcorm.user.dao.impl;

import org.example.spring.springmvcorm.user.dao.IPersonDao;
import org.example.spring.springmvcorm.user.entity.Person;
import org.example.spring.springmvcorm.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements IPersonDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int create(Person person) {
        Integer result = (Integer) hibernateTemplate.save(person);    // template saves the object into DB
        String sql = "SELECT * FROM users";

        return result;                                              // it returns the result back, which is an id
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
