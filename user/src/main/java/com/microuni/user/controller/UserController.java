package com.microuni.user.controller;

import com.microuni.user.model.UserRequest;
import com.microuni.user.model.UserResponse;
import com.microuni.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity addUser(@RequestBody UserRequest userRequest) {
        long start = System.currentTimeMillis();

        UserResponse userResponse = userService.addUser(userRequest);
        System.out.println(System.currentTimeMillis()-start);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
    @GetMapping
    ResponseEntity getUsers(){
        long start = System.currentTimeMillis();

        System.out.println("get users");
        List<UserResponse> users = userService.getUsers();
        System.out.println(System.currentTimeMillis()-start);


        return ResponseEntity.ok(users);
    }


}
