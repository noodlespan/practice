package com.example.springboot2.security5.customlogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class HomeController {

    @GetMapping(value={"/","home"})
    public String home(){
        return "index";
    }

}
