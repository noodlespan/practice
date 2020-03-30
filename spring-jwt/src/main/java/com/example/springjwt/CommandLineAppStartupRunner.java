package com.example.springjwt;

import com.example.springjwt.entity.Role;
import com.example.springjwt.entity.User;
import com.example.springjwt.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final String USERNAME="user";
    private static final String PASSWORD="123456";
    private static final String ROLE="ADMIN";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Optional<User> optionalUser = userRepository.findByName(USERNAME);
        if(!optionalUser.isPresent()){
            var user = new User();
            user.setName(USERNAME);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            var role = new Role();

            role.setName(ROLE);
            role.setUsers(Arrays.asList(user));
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
        }
    }

}
