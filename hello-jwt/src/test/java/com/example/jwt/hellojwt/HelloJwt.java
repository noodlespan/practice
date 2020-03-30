package com.example.jwt.hellojwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Date;

@Log4j2
public class HelloJwt {

    private static final String strKey ="1YGZJCiSuFkyw4luzkNma4VqRf4ULYMpKkQTu8CE9iD4=";
    private static final String strToken ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJQYW4ifQ.meGdRN9QNFlrl1wevgqIxe9rNQ6BCYpcLoVVBYX5gAU";

    @Test
    public void generate(){
        var key = Keys.hmacShaKeyFor(strKey.getBytes());
        //og.info("encodeKey:{}",encodeKey);
        var token = Jwts.builder().setSubject("Pan")
                .setIssuedAt(new Date())
                .setIssuer("www.pan.com")
                .signWith(key).compact();
        log.info("token:{}",token);

        var sub = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
                .getBody().getSubject();

    }
}
