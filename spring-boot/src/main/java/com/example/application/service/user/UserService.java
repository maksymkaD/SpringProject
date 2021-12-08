package com.example.application.service.user;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Field Injection
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(String role) {
        return userRepository.getUsersByRole(role);
    }

    @Cacheable("users")
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    @CacheEvict(value="users", allEntries=true)
    public void updateUser(User user) { userRepository.save(user); }

    public void deleteUser(int id) { userRepository.deleteById(id); }
}
