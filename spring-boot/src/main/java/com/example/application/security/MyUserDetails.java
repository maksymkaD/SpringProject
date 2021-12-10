package com.example.application.security;

import com.example.application.dal.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MyUserDetails implements UserDetails {
    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("admin");
        SimpleGrantedAuthority teacher = new SimpleGrantedAuthority("teacher");
        SimpleGrantedAuthority student = new SimpleGrantedAuthority("student");

        if (Objects.equals(this.user.getRole(), "teacher")) {
            authorities.add(teacher);
        }

        if (Objects.equals(this.user.getRole(), "student")) {
            authorities.add(student);
        }

        if (Objects.equals(this.user.getRole(), "admin")) {
            authorities.add(admin);
        }

        return authorities;
    }

    public Integer getId() {
        return user.getId();
    }

    public User getUser() {return user; }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    public String getRole() {
        return user.getRole();
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
