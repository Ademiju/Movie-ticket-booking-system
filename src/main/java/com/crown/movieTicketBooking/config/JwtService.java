package com.crown.movieTicketBooking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
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
        return getClaim(jwtToken,Claims::getSubject);
    }
    private Claims getAllClaims(String jwtToken){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder().setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }
    public boolean isTokenValid(String jwtToken, UserDetails userDetails){
        String userName = getUsername(jwtToken);
        return userName.equals(userDetails.getUsername())&& !isTokenExpired(jwtToken);
    }

    private boolean isTokenExpired(String jwtToken) {
        return getTokenExpiration(jwtToken).before(new Date());
    }

    private Date getTokenExpiration(String jwtToken) {
        return getClaim(jwtToken,Claims::getExpiration);
    }
}
