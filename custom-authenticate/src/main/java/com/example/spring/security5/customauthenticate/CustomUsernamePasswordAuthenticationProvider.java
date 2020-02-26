package com.example.spring.security5.customauthenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRep employeeRep;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Employee employee = employeeRep.findByName(username).orElseThrow(()->  new BadCredentialsException("Invalid username"));

        String usernameDB = employee.getName();
        String passwordDB = employee.getPassword();
        boolean isPassword = BCrypt.checkpw(password, passwordDB);
        if (username.equals(usernameDB) && isPassword) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList());
        } else {
            throw new BadCredentialsException("Invalid username / password");
        }

    }
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
