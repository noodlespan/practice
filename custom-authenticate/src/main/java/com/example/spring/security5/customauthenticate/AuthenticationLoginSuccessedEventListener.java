package com.example.spring.security5.customauthenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Access;

@Component
public class AuthenticationLoginSuccessedEventListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Autowired
    private LoginAttemptService loginAttemptService;
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authenticationSuccessEvent
                .getAuthentication().getDetails();
        loginAttemptService.loginSucceeded(webAuthenticationDetails.getRemoteAddress());
    }
}
