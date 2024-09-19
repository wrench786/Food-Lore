package com.minhajcse.service;

import com.minhajcse.model.Authority;
import com.minhajcse.model.User;
import com.minhajcse.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);

        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Authority authority : user.getAuthorities()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities
        );
    }
}
