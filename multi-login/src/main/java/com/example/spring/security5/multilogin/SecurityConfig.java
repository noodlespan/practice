package com.example.spring.security5.multilogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**")
                    .authorizeRequests()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()

                    .and()
                    .formLogin()
                    .loginPage("/admin/login")
                    .defaultSuccessUrl("/admin/home")
                    .permitAll()

                    .and()
                    .logout()
                    .logoutUrl("/admin/logout")
                    .permitAll();

        }

        @Configuration
        @Order(2)
        public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.antMatcher("/user/**")
                        .authorizeRequests()
                        .antMatchers("/css/**").permitAll()
                        .anyRequest()
                        .authenticated()

                        .and()
                        .formLogin()
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/user/home")
                        .permitAll()

                        .and()
                        .logout()
                        .logoutUrl("/user/logout")
                        .permitAll();
            }
        }

      /*
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password(encoder().encode("123456"))
                    .roles("USER");
            auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password(encoder().encode("123456"))
                    .roles("ADMIN");
        }
      */
       @Bean
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User
                    .withUsername("user")
                    .password(encoder().encode("123456"))
                    .roles("USER")
                    .build());

            manager.createUser(User
                    .withUsername("admin")
                    .password(encoder().encode("123456"))
                    .roles("ADMIN")
                    .build());

            return manager;
        }

        @Bean
        public static PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }


    }
}
