package org.example.spring.springmvcorm.user.services.impl;

import org.example.spring.springmvcorm.user.dao.IUserDao;
import org.example.spring.springmvcorm.user.entity.User;
import org.example.spring.springmvcorm.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    @Transactional  // it is always a good practice to have @Transactional at SERVICES LAYER (we could add it to create method in IUserDao interface)
    public int save(User user) {
        // Business Logic
        return dao.create(user);    // invokes the HibernateTemplate method create() which saves the model object into DB table
    }

    @Override
    public List<User> getUsers() {
        List<User> users = dao.findUsers();
        Collections.sort(users);
        return users;
    }

    // AJAX & jQuery
    @Override
    public User getUser(Integer id) {
        return dao.findUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    @Transactional
    public void updateById(Integer id, User user) {
        dao.updateById(id, user);
    }


    @Override
    @Transactional
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public IUserDao getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

}
