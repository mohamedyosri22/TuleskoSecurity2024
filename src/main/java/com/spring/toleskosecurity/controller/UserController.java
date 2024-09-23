package com.spring.toleskosecurity.controller;


import com.spring.toleskosecurity.UserRepo;
import com.spring.toleskosecurity.model.User;
import com.spring.toleskosecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    @PostMapping
    public User Register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }


    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName){
        return userRepo.findByUserName(userName);
    }
}
