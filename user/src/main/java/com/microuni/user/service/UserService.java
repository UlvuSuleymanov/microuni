package com.microuni.user.service;

import com.microuni.user.model.UserRequest;
import com.microuni.user.model.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);
    void deleteUser(String username);

    List<UserResponse> getUsers();
}
