package com.example.spring.security5.session;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class SessionController {

    private static final String USER_SESSION="USER_SESSION";

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/setSession")
    public String setSession(HttpSession session, Authentication authentication){
        session.setAttribute(USER_SESSION,authentication.getName());
        return "hello";
    }

    @GetMapping("/getSession")
    public String getSession(HttpSession session){
        return session.getAttribute(USER_SESSION).toString();
    }

    @GetMapping("/cookies")
    public String cookies(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if(null != cookies){
            return Arrays.stream(cookies)
                    .map(cookie -> cookie.getName() +"："+cookie.getValue()).collect(Collectors.joining(","));
        }
        return "null";
    }

}
