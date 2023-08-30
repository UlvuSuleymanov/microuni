package com.microuni.user.service.impl;

import com.microuni.user.entity.User;
import com.microuni.user.model.UserRequest;
import com.microuni.user.model.UserResponse;
import com.microuni.user.repository.UserRepository;
import com.microuni.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = User
                .builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();

        userRepository.save(user);

        return new UserResponse(user);
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public List<UserResponse> getUsers() {
     return   userRepository.findAll().stream().map(
               user->new UserResponse(user)
       ).collect(Collectors.toList());
    }
}
