package com.example.application.security.auth;

import com.example.application.crud.model.User;
import com.example.application.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.getByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with email not found");
        }

        return new MyUserDetails(user);
    }
}
