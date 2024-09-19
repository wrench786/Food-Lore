package com.minhajcse.service;

import com.minhajcse.model.Authority;
import com.minhajcse.model.User;
import com.minhajcse.repository.AuthorityRepository;
import com.minhajcse.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username.toLowerCase());
    }

    public User addUser(User user) {
        Authority authority = authorityRepository.findByAuthority("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities(Set.of(authority));
        return userRepository.save(user);
    }
    public User addAdmin(User user) {
        Authority authority = authorityRepository.findByAuthority("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities(Set.of(authority));
        return userRepository.save(user);
    }
}
