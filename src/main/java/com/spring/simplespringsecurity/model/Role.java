package com.spring.simplespringsecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;

    @ManyToMany
    private Set<Authority> authorities;

    // ROLE_ + this.name
    // ROLE_USER
    // ROLE_ADMIN
    @Override
    public String getAuthority() {
        return "ROLE_"+this.name;
    }
}
