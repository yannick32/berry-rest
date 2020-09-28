package com.upsilonium.berry.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Service
public class JwtProvider {
    private KeyStore keyStore;

    @PostConstruct
    public void init(){
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/berry.jks");
            keyStore.load(resourceAsStream, "P@ssw0rd".toCharArray());
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
    }

    public String generateToken(Authentication authentication){
        return Jwts.builder()
                .setSubject(authentication.getName())
                .signWith(getPrivateKey())
                .compact();
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        
        return claims.getSubject();
    }


    boolean validateToken(String jwt){
        Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build()
                .parseClaimsJws(jwt);
        return true;

    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("berry", "P@ssw0rd".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Exception was thrown while retrieving private key");
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("berry").getPublicKey();
        } catch (KeyStoreException e) {
            e.printStackTrace();
            throw new RuntimeException("Exception was thrown while retrieving private key");
        }
    }
}
