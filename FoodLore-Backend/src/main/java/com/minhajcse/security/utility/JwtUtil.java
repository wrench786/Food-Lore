package com.minhajcse.security.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {

    // this will make issue as , The @Value annotation injects the value after the constructor or field initializers are called.
    @Value("${jwt.expiry}")
    private long JWT_EXP;

    @Value("${jwt.secret}")
    private String base64Secret;

    private SecretKey SECRET_KEY;
    //this will solve the issue
    @PostConstruct
    public void init() {
        SECRET_KEY = Keys.hmacShaKeyFor(base64Secret.getBytes());
    }

    //method to generate token
    public String generateToken(UserDetails userDetails) {
        List<String> authorities = userDetails.getAuthorities().stream().map(
                grantedAuthority -> grantedAuthority.getAuthority()
        ).toList();
        Map<String, Object> claims = new HashMap<>();
        claims.put("Authorities", authorities);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date( new Date().getTime()))
                .setExpiration(new Date( new Date().getTime() + JWT_EXP ))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .signWith(SECRET_KEY)
                .compact();
    }

    //method to validate token
    public boolean validateJwtToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)  // Ensure you use the correct key
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;  // Token is valid
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired token");
        } catch (Exception ex) {
            System.out.println("Invalid token");
        }
        return false;  // Invalid token
    }

    //method to extract username from token
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // Extracts username (subject)
    }

    //Method to extract authorities from token
    public List<String> extractAuthorities(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return (List<String>) claims.get("Authorities");  // Extracts authorities
    }
}
