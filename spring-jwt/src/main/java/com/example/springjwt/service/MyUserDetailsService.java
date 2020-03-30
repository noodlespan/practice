package com.example.springjwt.service;

import com.example.springjwt.entity.User;
import com.example.springjwt.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("user not exit"));
        List<GrantedAuthority> grantedAuthorityes = user.getRoles().stream().map(role ->  new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorityes);
        return userDetails;
    }
}