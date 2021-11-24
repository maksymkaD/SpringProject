package com.example.application.security.auth;

import java.util.*;

import com.example.application.crud.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if (Objects.equals(this.user.getRole(), "teacher")) {
            authorities.add(new SimpleGrantedAuthority("teacher"));
        }

        if (Objects.equals(this.user.getRole(), "student")) {
            authorities.add(new SimpleGrantedAuthority("student"));
        }

        if (Objects.equals(this.user.getRole(), "admin")) {
            authorities.add(new SimpleGrantedAuthority("student"));
            authorities.add(new SimpleGrantedAuthority("admin"));
            authorities.add(new SimpleGrantedAuthority("teacher"));
        }

        return authorities;
    }

    public Integer getId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
