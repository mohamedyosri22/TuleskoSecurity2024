package com.spring.toleskosecurity.controller;

import com.spring.toleskosecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
       new Student(1,"mohamed yosri"),
            new Student(2,"ahmed ali")
    ));

    @GetMapping("csrf-token")
    public CsrfToken getCsrf(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @GetMapping
    public List<Student> getAll(){
        return students;
    }

    @PostMapping
    public Student getAll(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
