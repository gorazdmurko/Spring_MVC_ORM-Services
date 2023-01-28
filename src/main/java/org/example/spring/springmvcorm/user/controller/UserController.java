package org.example.spring.springmvcorm.user.controller;

import org.example.spring.springmvcorm.user.entity.Person;
import org.example.spring.springmvcorm.user.entity.User;
import org.example.spring.springmvcorm.user.services.IPersonService;
import org.example.spring.springmvcorm.user.services.IUserService;
import org.example.spring.springmvcorm.user.parser.SAXParser;
import org.example.spring.springmvcorm.user.parser.impl.STAXParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/registration")
@javax.servlet.annotation.MultipartConfig
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/registrationPage")
    public String showRegistrationPage() {
        return "userReg";
    }

    @RequestMapping(value="/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, ModelMap model) { // Spring automatically converts the incoming data into a Model Object
        // pass the object into service, which invokes HibernateTemplate method (creates new DB row) and returns an id
        System.out.println("\nUser created: " + user);
        int result = service.save(user);    // hibernateTemplate save() returns an id
                                            // set an id into a ModelMap and send the result back to UI

        System.out.println("User " + user + " created with id " + result);
        model.addAttribute("result", user + " created with id " + result);
        model.addAttribute("message", "User successfully created and returned:");

        // push that result back to the same registration page
        return "userReg";
    }

    @RequestMapping("/getUsers")
    public String getUser(ModelMap model) {                     // ModelMap - to send the data back to the UI
        List<User> users = service.getUsers();
        System.out.println("A list of all users: " + users);
        model.addAttribute("users", users);         // appends users to model and send it to UI (available under users variable)

        return "displayUsers";
    }

    @RequestMapping("/getIndex")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("displayUsers");

        return modelAndView;
    }



    // AJAX & jQuery
    // wrap up back-end development by implementing the controller methods

    @RequestMapping("/logToConsole")
    public @ResponseBody String logToConsole() {
        System.out.println("Submit button clicked");
        return "userReg";
    }

    @RequestMapping("/validateEmail")
    public @ResponseBody String validateEmail(@RequestParam("id") Integer id) {

        User user = service.getUser(id);
        String msg = "";

        // if the user is not equal to null, it means that validation has failed (the user with a given id already exists in the DB)
        if (user != null) {
            msg = id + " already exists!";
        }

        // @ResponseBody tell Spring that whatever we are returning from this method
        // should be used in the response body (and also  no need to resolve for a view name)
        return msg;
    }

    // GETTERS & SETTERS
    public IUserService getService() { return service; }
    public void setService(IUserService service) { this.service = service; }
}

/*
        File file = new File(FILE_NAME);
        file.setWritable(true);
        file.setReadable(true);
        String path = file.getAbsolutePath();
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();

        System.out.println("\n\nPATH of writer: " + path);
        Path filePath = Path.of(path);
        System.out.println("PATH from reader: " + filePath);
        String result = Files.readString(filePath);
* */