package com.team1.mohaji.config;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class CustomUserDetails implements UserDetails {

    private String name;
    private int memberId;  // 사용자 ID

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String name, int memberId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
