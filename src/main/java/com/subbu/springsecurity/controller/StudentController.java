package com.subbu.springsecurity.controller;


import com.subbu.springsecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.web.server.csrf.;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    public List<Student> list = new ArrayList<>(List.of(new Student("Subbu", 21, 21),
            new Student("Subbu", 21, 21),
            new Student("Subbu", 21, 21)));


    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @PostMapping("/add")
    public Student addStudents(@RequestBody Student student) {
        list.add(student);
        return student;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
