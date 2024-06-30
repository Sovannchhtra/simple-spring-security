package com.spring.simplespringsecurity.service;

import com.spring.simplespringsecurity.dto.UserRequest;
import com.spring.simplespringsecurity.dto.UserResponse;
import com.spring.simplespringsecurity.model.User;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
