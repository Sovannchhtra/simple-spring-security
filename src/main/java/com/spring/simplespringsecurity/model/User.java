package com.spring.simplespringsecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    private boolean isDisable;
    private boolean isAccountLocked;
    private boolean isAccountExpired;
    private boolean isCredentialsExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
