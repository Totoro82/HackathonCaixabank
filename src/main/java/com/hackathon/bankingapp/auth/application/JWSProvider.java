package com.hackathon.bankingapp.auth.application;


import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.crypto.SecretKey;
@Component
public class JWSProvider {

    private final SecretKey key = Jwts.SIG.HS256.key().build();


    public String createToken(String identifier) {
        return Jwts.builder()
                .subject(identifier)
                .signWith(key)
                .compact();
    }

    public String decodeToken(String token) {
        //todo docodeToken
    }

//    public static void main(String[] args) {
//
//        String jws = Jwts.builder().subject("Joe").signWith(key).compact();
//        boolean joe = Jwts.parser().verifyWith(key).build().parseSignedClaims(jws).getPayload().getSubject().equals("Joe");
//        Assert.isTrue(joe, "El sujeto es el mismox");
//        System.out.println(jws);
//    }
}
