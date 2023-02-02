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

    // 1. GET list of all users
    @GetMapping("/get")
    public List<User> allUsers() {
        return service.getUsers();
    }

    // 2. GET user by id    =>  http://localhost:8282/Spring_MVC_ORM/user/get/6     or     http://localhost:8282/Spring_MVC_ORM/user/get/?id=6
    @GetMapping("/get/{id}")
    public User user(@PathVariable(value = "id") Integer id) {
        return service.getUser(id);
    }

    // 3. create (POST) user
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

    // 4. UPDATE user (based on its body)
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User userToUpdate) {
        boolean isUser = checkIfIdExists(userToUpdate.getId());
        if (isUser) {
            service.updateUser(userToUpdate);
        }
    }

    // 5. UPDATE a list users
    @RequestMapping(value = "/updateList", method = RequestMethod.PUT)
    public void updateListOfUsers(@RequestBody List<User> usersList) {
        for (User user : usersList) {
            boolean isUser = checkIfIdExists(user.getId());
            if (isUser) {
                service.updateUser(user);
            }
        }
    }

    // 6. UPDATE user by id
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateUserById(@PathVariable("id") Integer id, @RequestBody User userToUpdate) {
        boolean isUser = checkIfIdExists(id);
        if (isUser) {
            service.updateById(id, userToUpdate);
        }
    }

    // 7. DELETE user by id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteUserById(@PathVariable("id") Integer id) {
        User user = null;
        boolean isUser = checkIfIdExists(id);
        if (isUser) {
            user = service.getUser(id);
            service.deleteById(id);
        }

        return user;
    }

    // validation
    private boolean checkIfIdExists(Integer id) {
        boolean isUser = false;
        User user = service.getUser(id);
        if (user != null) {
            isUser = true;
        }
        return isUser;
    }
}
