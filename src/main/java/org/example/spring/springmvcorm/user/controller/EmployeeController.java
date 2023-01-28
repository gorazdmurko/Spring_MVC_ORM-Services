package org.example.spring.springmvcorm.user.controller;

import org.example.spring.springmvcorm.user.dto.Student;
import org.example.spring.springmvcorm.user.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.codejava.net/frameworks/spring/spring-mvc-form-handling-tutorial-and-example

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private String EMPLOYEE_FORM_VIEW = "employeeFormView";
    private String EMPLOYEE_SUCCESS_VIEW = "success_employee";

//    // 1
//    @RequestMapping(value = "/viewRegistrationForm", method = RequestMethod.GET)
//    public ModelAndView showForm() {
//        System.out.println("First controller called");
//        return new ModelAndView(EMPLOYEE_FORM_VIEW, "employee", new Employee());
//    }
//
//    // 2
//    @GetMapping("/viewRegistrationForm")
//    public String getStudentForm(@ModelAttribute("employee") Employee employee, Model model) {
//        System.out.println("Second controller called");
//        return EMPLOYEE_FORM_VIEW;
//    }


    // 3 - @RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/viewRegistrationForm")
    public String viewRegistration(Map<String, Object> model) {
        System.out.println("view registration form");
        Employee employee = new Employee();

        // Map<String, Object> model = new HashMap<>();
        model.put("employeeForm", employee);

        List<String> professionList = new ArrayList<>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        professionList.add("Engineer");
        model.put("professionList", professionList);

        return EMPLOYEE_FORM_VIEW;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("employeeForm") Employee employee,
                                      Map<String, Object> model) {

        // implement your own registration logic here...

        // for testing purpose:
        System.out.println("username: " + employee.getUsername());
        System.out.println("password: " + employee.getPassword());
        System.out.println("email: " + employee.getEmail());
        System.out.println("birth date: " + employee.getBirthDate());
        System.out.println("profession: " + employee.getProfession());

        return EMPLOYEE_SUCCESS_VIEW;
    }
}
