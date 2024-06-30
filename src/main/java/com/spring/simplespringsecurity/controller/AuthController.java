package com.spring.simplespringsecurity.controller;

import com.spring.simplespringsecurity.dto.UserRequest;
import com.spring.simplespringsecurity.model.User;
import com.spring.simplespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


    public Map<String,Object> generateResponse(Object data , String massage , int status) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload",data);
        response.put("message",massage);
        response.put("status",status);
        return response;
    }

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody UserRequest userRequest){
        return generateResponse(
                userService.createUser(userRequest),
                "Created account successful!",
                HttpStatus.CREATED.value()
        );
    }

}
