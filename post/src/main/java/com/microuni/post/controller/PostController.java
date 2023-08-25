package com.microuni.post.controller;

import com.microuni.post.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("post")
public class PostController {
    public static List<Post> posts = new ArrayList<>();
    public static Long id=0L;

    @PostMapping("{userId}")
    public List<Post> addUser(@PathVariable(name = "userId") Long userId){
        Post post = new Post();
        post.setId(id++);
        post.setText(UUID.randomUUID().toString());
        post.setUserId(userId);
        posts.add(post);
        return posts;
    }

    @GetMapping
    public List<Post> getUserList(){
        return posts;
    }

    @GetMapping("/{userId}")
    public List<Post> getUserList(@PathVariable Long userId){
        return posts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
