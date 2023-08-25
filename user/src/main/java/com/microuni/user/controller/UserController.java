package com.microuni.user.controller;

import com.microuni.user.model.Post;
import com.microuni.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    public static List<User> userList = new ArrayList<>();
    public static Long id=0L;
//     private PostClient postClient;

    @PostMapping
    public void addUser(){
        User user = new User();
        user.setId(id++);
        user.setUsername(String.valueOf(id.hashCode()));
        user.setPassword(UUID.randomUUID().toString());
        userList.add(user);
    }
    @GetMapping("/{id}/post")
    public List<Post> getUserList(@PathVariable Long id){
//        return postClient.getPostsByUserId(id);
    return Collections.emptyList();
    }


    @GetMapping
    public List<User> getUserList(){
        return userList;
    }


}
