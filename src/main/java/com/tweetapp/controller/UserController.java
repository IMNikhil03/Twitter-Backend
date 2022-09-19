package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tweetapp.model.User;
import com.tweetapp.service.UserService;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "https://tweetappfse2.azurewebsites.net/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
        return users;
    }

    @GetMapping("/user/search/{loginIdPattern}")
    public List<User> getAllUsersByLoginId(@PathVariable String loginIdPattern) {
        List<User> users = userService.getAllUsersByLoginId(loginIdPattern);
        return users;
    }
}
