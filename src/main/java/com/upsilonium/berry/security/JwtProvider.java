package com.upsilonium.berry.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Service
public class JwtProvider {
    private Key key;

    @PostConstruct
    public void init(){
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(Authentication authentication){
        return Jwts.builder()
                .setSubject(authentication.getName())
                .signWith(key)
                .compact();
    }

    boolean validateToken(String jwt){
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt);
        return true;

    }

    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        
        return claims.getSubject();
    }
}
