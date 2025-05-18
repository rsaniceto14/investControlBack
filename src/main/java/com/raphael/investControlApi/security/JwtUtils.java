package com.raphael.investControlApi.security;

import com.raphael.investControlApi.model.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;




@Component
public class JwtUtils {

@Value("${jwt.secret}")
private String secret;

private final long expirationTime = 86400000; // expires in 1 day

public String generateJwtToken(User user) {


    return Jwts.builder()
            .setSubject(user.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) 
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
}

public String extractUsername(String token) {
    return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();

}

public boolean validateToken(String token, UserDetails userDetails) {
    String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}

private boolean isTokenExpired(String token) {
    Date expiration = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
    return expiration.before(new Date());



}
}
