package com.example.spring.security5.customauthenticate;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Log4j2
public class UserInfoController {

    @GetMapping("/userInfo")
    public String userInfo(Authentication authentication){
        log.info("getName:{}",authentication.getName());
        log.info("getPrincipal:{}",authentication.getPrincipal());
        log.info("getCredentials:{}",authentication.getCredentials());
        log.info("getDetails:{}",authentication.getDetails());
        log.info("getAuthorities:{}",authentication.getAuthorities());
        return authentication.getName();
    }

    @GetMapping("/userInfo2")
    public String userInfo2(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("getName:{}",authentication.getName());
        log.info("getPrincipal:{}",authentication.getPrincipal());
        log.info("getCredentials:{}",authentication.getCredentials());
        log.info("getDetails:{}",authentication.getDetails());
        log.info("getAuthorities:{}",authentication.getAuthorities());
        return authentication.getName();
    }

    @GetMapping("/userInfo3")
    public String userInfo3(Principal principal){
        log.info("getPrincipal:{}",principal);
        return principal.getName();
    }


}
