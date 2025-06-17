package com.example.spring_app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.spring_app.entity.User;
import com.example.spring_app.repository.UserRepository;
import com.example.spring_app.security.CustomUserDetails;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .stream()
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません: " + username));

        String role = user.getRoleId() == 2 ? "ROLE_ADMIN" : "ROLE_USER";

        return new CustomUserDetails(
            user.getUserId().longValue(),
            user.getUserName(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority(role))
        );
    }
} 