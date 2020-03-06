package com.example.spring.security5.sessionh2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
    private static final String USER_SESSION="USER_SESSION";

    @GetMapping(value="/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/setSession")
    public Boolean setSession(HttpSession session){
        session.setAttribute(USER_SESSION,"THIS IS A TEST SESSION VALUE");
        return Boolean.TRUE;
    }

    @GetMapping("/getSession")
    public String getSession(HttpSession session){
        return session.getAttribute(USER_SESSION).toString();
    }

    @GetMapping("/invalidate")
    public Boolean invalidate(HttpSession session){
        session.invalidate();
        return Boolean.TRUE;
    }
}
