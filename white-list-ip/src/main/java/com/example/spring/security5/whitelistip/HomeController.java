package com.example.spring.security5.whitelistip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("/api")
    public String ip(HttpServletRequest request){
        return request.getRemoteAddr();
    }
}
