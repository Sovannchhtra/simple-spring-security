package com.spring.simplespringsecurity.dto;

import com.spring.simplespringsecurity.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public record UserResponse(String id, String email, Set<String> roles) {
}
