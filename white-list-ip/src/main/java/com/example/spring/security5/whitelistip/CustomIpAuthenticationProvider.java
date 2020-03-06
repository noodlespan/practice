package com.example.spring.security5.whitelistip;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomIpAuthenticationProvider implements AuthenticationProvider {

    private List<String> whiteIps = new ArrayList<String>();

    public CustomIpAuthenticationProvider(){
        whiteIps.add("192.168.1.9");
        //whiteIps.add("127.0.0.1");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WebAuthenticationDetails webAuthenticationDetails =(WebAuthenticationDetails)authentication.getDetails();
        String ip = webAuthenticationDetails.getRemoteAddress();
        if(!whiteIps.contains(ip)){
            throw  new BadCredentialsException("Invalid IP");
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
