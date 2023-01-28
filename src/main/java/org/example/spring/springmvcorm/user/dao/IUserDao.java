package org.example.spring.springmvcorm.user.dao;

import org.example.spring.springmvcorm.user.entity.User;

import java.util.List;

public interface IUserDao {

    int create(User user);

    List<User> findUsers();

    // AJAX & jQuery
    User findUser(Integer id);

    void updateUser(User user);

    void updateById(Integer id, User user);

    void deleteById(Integer id);
}
