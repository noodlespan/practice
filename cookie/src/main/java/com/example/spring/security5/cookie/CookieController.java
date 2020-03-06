package com.example.spring.security5.cookie;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    @GetMapping("/read")
    public String read(@CookieValue String username){
        return username;
    }

    @GetMapping("/write")
    public String write(HttpServletResponse response){
        Cookie cookie = new Cookie("username","uservalue2");
        //cookie.setPath("/write");
        //cookie.setMaxAge(0);
        //cookie.setHttpOnly(true);
        //cookie.setSecure(true);
        response.addCookie(cookie);
        return "OK";
    }
}
