package org.example.spring.springmvcorm.user.services;

import org.example.spring.springmvcorm.user.entity.User;

import java.util.List;

public interface IUserService {

    int save(User user);

    List<User> getUsers();

    // AJAX & jQuery
    User getUser(Integer id);

    void updateUser(User user);

    void updateById(Integer id, User user);

    void deleteById(Integer id);

}
