package com.microuni.user.controller;

import com.microuni.user.entity.User;
import com.microuni.user.model.UserRequest;
import com.microuni.user.model.UserResponse;
import com.microuni.user.repository.UserRepository;
import com.microuni.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @PostMapping
    ResponseEntity addUser(@RequestBody UserRequest userRequest) {
        long start = System.currentTimeMillis();
        UserResponse userResponse = userService.addUser(userRequest);
        System.out.println(System.currentTimeMillis() - start);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping
    ResponseEntity getUsers() {
        User userRequest = new User();
        userRequest.setEmail("email");
        userRequest.setName("name");
        userRequest.setPassword("password");
        userRequest.setUsername("username");
        User user = userRepository.save(userRequest);
        return ResponseEntity.ok(user);
    }


}
