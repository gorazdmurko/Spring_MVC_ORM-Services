package org.example.spring.springmvcorm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.example.spring.springmvcorm.user.userupload.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private String INDEX_PAGE = "indexPage";

    // if there is no index.jsp page, it redirects the root page to /index which calls indexPage !!
    @GetMapping("/")
    public String index(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getIndexPage() {
        return INDEX_PAGE;
    }

    //    @GetMapping("/user/retrieve")
    //    public String fakeGetUser(){
    //        throw new UserNotFoundException("This is a practice......");
    //    }
}
