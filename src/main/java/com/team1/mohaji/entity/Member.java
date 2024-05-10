package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String loginId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean status;

    public enum Role {
        STUDENT,
        ADMIN,
        PROFESSOR
    }

    public boolean getStatus() {
        return this.status;
    }
}
