package org.example.spring.springmvcorm.user.controller.restcontrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.spring.springmvcorm.user.dto.RestStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/restApi")         // restApi/rest-students
public class RestController {

    private RestStudent student = new RestStudent();
    private List<RestStudent> studentsList = new ArrayList<>();

    @ResponseBody
    @RequestMapping(value = "/rest-students", method = RequestMethod.GET)
    public List<RestStudent> getStudentsList() {
        return getStudents();
    }

    @ResponseBody
    @RequestMapping(value = "/rest-students/id/{id}", method = RequestMethod.GET)
    public RestStudent getStudentById(@PathVariable int id) {

        List<RestStudent> studentsList = getStudents();

        for (RestStudent student : studentsList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/rest-students/name/{name}", method = RequestMethod.GET)
    public RestStudent getStudentByName(@PathVariable String name) {

        List<RestStudent> studentsList = getStudents();

        for (RestStudent student : studentsList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @PostMapping("/create")        // restApi/create
    public RestStudent createStudent(@RequestBody RestStudent student) {
        int id = studentsList.size() + 1;
        student.setId(id);
        studentsList.add(student);
        return student;
    }

    @PutMapping("/update-student/{id}")
    public void updateStudent(@PathVariable("id") int id, @RequestBody RestStudent student) {
        int index = id - 1;
        RestStudent updatedStudent = studentsList.get(index);

        updatedStudent.setId(id);
        updatedStudent.setName(student.getName());
        updatedStudent.setDateOfBirth(student.getDateOfBirth());

        studentsList.remove(index);
        studentsList.add(index, updatedStudent);
    }

    // @DeleteMapping("/delete-student/{id}")
    @RequestMapping(value = "/delete-student/{id}", method = RequestMethod.DELETE)
    public RestStudent deleteOrder(@PathVariable("id") int id) {
        int index = id - 1;

        RestStudent deletedStudent = studentsList.get(index);
        studentsList.remove(index);

        updateIDs();
        return deletedStudent;
    }


    private void updateIDs() {
        for (int i = 0; i < studentsList.size(); i++) {
            studentsList.get(i).setId(i + 1);
        }
    }

    private List<RestStudent> getStudents() {
        RestStudent student1 = new RestStudent();
        student1.setId(1);
        student1.setName("TheGreatKali");
        student1.setDateOfBirth(new Date());

        RestStudent student2 = new RestStudent();
        student2.setId(2);
        student2.setName("TheUndertaker");
        student2.setDateOfBirth(new Date());

        RestStudent student3 = new RestStudent();
        student3.setId(3);
        student3.setName("JohnDoe");
        student3.setDateOfBirth(new Date());

        if (studentsList.isEmpty()) {
            studentsList.add(student1);
            studentsList.add(student2);
            studentsList.add(student3);
        }

        return studentsList;
    }

    // ---------------------------------------------------------------------------------------------------------------

    // TEST: Map -> JSON    --> returns ResponseEntity
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test(@RequestParam String id, @RequestParam String name) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("name", name);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(json);
    }

    // TEST: Map -> JSON    --> returns String
    @ResponseBody
    @RequestMapping(value = "/test123", method = RequestMethod.GET)
    public String test123(@RequestParam String id, @RequestParam String name) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("name", name);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);

        return json;
    }
}
