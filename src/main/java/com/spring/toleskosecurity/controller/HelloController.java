package com.spring.toleskosecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping("/hi")
    public String sayHi(){
        return "Hi !!";
    }


}
