package org.example.spring.springmvcorm.user.controller.restcontrollers;

import org.example.spring.springmvcorm.user.entity.User;
import org.example.spring.springmvcorm.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class RestUserDBController {

    @Autowired
    private IUserService service;

    // 1. get list of all users
    @GetMapping("/get")
    public List<User> allUsers() {
        return service.getUsers();
    }

    // 2. get user by id
    @GetMapping("/get/{id}")
    public User user(@PathVariable(value = "id") Integer id) {
        return service.getUser(id);
    }

    // 3. post user
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User postedUser) {

        User userToCreate = new User();
        List<User> userList = service.getUsers();

        int index = 1;
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == index) {
                index++;
            }
        }

        userToCreate.setId(index);
        userToCreate.setName(postedUser.getName());
        userToCreate.setEmail(postedUser.getEmail());

        service.save(userToCreate);
        return userToCreate;
    }

    // 4. update user
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User userToUpdate) {
        service.updateUser(userToUpdate);
    }

    // 5. update user by id
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateUserById(@PathVariable("id") Integer id, @RequestBody User userToUpdate) {
        service.updateById(id, userToUpdate);
    }

    // 6. delete user by id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteUserById(@PathVariable("id") Integer id) {
        User user = service.getUser(id);
        service.deleteById(id);
        return user;
    }
}
