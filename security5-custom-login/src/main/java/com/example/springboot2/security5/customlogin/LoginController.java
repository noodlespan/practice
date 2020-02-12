package com.example.springboot2.security5.customlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String login(){
        return "login_page";
    }

    @GetMapping("/logoutPage")
    public String logout(){
        return "logout_page";
    }
}
