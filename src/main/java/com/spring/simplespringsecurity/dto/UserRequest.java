package com.spring.simplespringsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public record UserRequest(String email, String password, Set<String> roles) {
}
