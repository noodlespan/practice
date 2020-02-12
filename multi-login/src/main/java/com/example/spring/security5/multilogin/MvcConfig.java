package com.example.spring.security5.multilogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("user/home");
        registry.addViewController("/admin/login").setViewName("admin/login");
        registry.addViewController("/admin/home").setViewName("admin/home");
        registry.addViewController("/user/login").setViewName("user/login");
        registry.addViewController("/user/home").setViewName("user/home");

    }
}
