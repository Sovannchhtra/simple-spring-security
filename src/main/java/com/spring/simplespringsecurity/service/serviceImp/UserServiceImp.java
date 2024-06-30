package com.spring.simplespringsecurity.service.serviceImp;

import com.spring.simplespringsecurity.dto.UserRequest;
import com.spring.simplespringsecurity.dto.UserResponse;
import com.spring.simplespringsecurity.mapper.UserMapper;
import com.spring.simplespringsecurity.model.Role;
import com.spring.simplespringsecurity.model.User;
import com.spring.simplespringsecurity.repository.RoleRepository;
import com.spring.simplespringsecurity.repository.UserRepository;
import com.spring.simplespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // Check role for email
        if(userRepository.existsByEmail(userRequest.email())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email is already in use");
        }

        Set<Role> roles = new HashSet<>();
        // Check for Role
        userRequest.roles().forEach(role -> {
            var roleObject = roleRepository.findByName(role)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Role "+role+" not found"
                    )
            );
            roles.add(roleObject);
        });

        User newUser = userMapper.userRequestMapToUser(userRequest,roles);
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
        userRepository.save(newUser);
        return userMapper.userMapToUserResponse(newUser);
    }
}
