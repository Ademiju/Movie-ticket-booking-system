package com.crown.movieTicketBooking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${secret_key}")
    private String SECRET_KEY;

    public <T> T getClaim(String jwtToken, Function<Claims,T> claimsResolver){
        Claims claims = getAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    public String getUsername(String jwtToken) {
        return null;
    }
    private Claims getAllClaims(String jwtToken){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
