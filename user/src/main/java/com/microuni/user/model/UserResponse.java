package com.microuni.user.model;

import com.microuni.user.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String username;


}
