package com.spring.simplespringsecurity.mapper;

import com.spring.simplespringsecurity.dto.UserRequest;
import com.spring.simplespringsecurity.dto.UserResponse;
import com.spring.simplespringsecurity.model.Role;
import com.spring.simplespringsecurity.model.User;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email", source = "userRequest.email"),
            @Mapping(target = "password", source = "userRequest.password"),
            @Mapping(target = "roles", source = "roles")
    })
    User userRequestMapToUser(UserRequest userRequest, Set<Role> roles);

    @Mapping(
            target = "roles",
            source = "user.roles",
            qualifiedByName = "mapRoles"
    )
    UserResponse userMapToUserResponse(User user);

    @Named("mapRoles")
    default Set<String> mapRoles(Set<Role> roles) {
        return roles
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
