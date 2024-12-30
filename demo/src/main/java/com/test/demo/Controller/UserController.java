package com.test.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.demo.entity.User;
import com.test.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        
        return userService.createUser(user.getFirstName(), user.getMiddleName(), user.getLastName());
    }
}