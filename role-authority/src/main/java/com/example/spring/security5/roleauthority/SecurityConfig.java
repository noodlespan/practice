package com.example.spring.security5.roleauthority;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

        @Configuration
        public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable()
                        .authorizeRequests()
                        .antMatchers(HttpMethod.GET,"/employee**").hasAuthority("read")
                        //.antMatchers(HttpMethod.DELETE,"/employee/**").hasAuthority("delete")
                        .anyRequest()
                        .authenticated()
                        .and()
                        .httpBasic();

            }
        }

        @Bean
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

            manager.createUser(User
                    .withUsername("admin")
                    .password(encoder().encode("123456"))
                    .authorities("read","delete")
                    .build());
            manager.createUser(User
                    .withUsername("user")
                    .password(encoder().encode("123456"))
                    .authorities("read")
                    .build());
            manager.createUser(User
                    .withUsername("guest")
                    .password(encoder().encode("123456"))
                    .roles("GUEST")
                    .build());
            return manager;
        }

        @Bean
        public static PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }

}
