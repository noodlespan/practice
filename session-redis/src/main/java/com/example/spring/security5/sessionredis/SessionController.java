package com.example.spring.security5.sessionredis;

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
        session.setAttribute(USER_SESSION,new Employee(1L,"ALEX"));
        return Boolean.TRUE;
    }

    @GetMapping("/getSession")
    public Employee getSession(HttpSession session){
        return (Employee)session.getAttribute(USER_SESSION);
    }

    @GetMapping("/invalidate")
    public Boolean invalidate(HttpSession session){
        session.invalidate();
        return Boolean.TRUE;
    }
}
