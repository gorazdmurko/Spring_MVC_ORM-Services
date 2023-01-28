package org.example.spring.springmvcorm.user.controller;

import org.example.spring.springmvcorm.user.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/students")
    public Student student(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Student((int) counter.incrementAndGet(), String.format(template, name));
    }

}
