package com.satyam.taskflow.security;

import java.util.Date;

//import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
private final String jwtSecret = "SnowBall";
private final int jwtExpirationMs = 86400000; // 1day 
//private final SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

public String generateToken(UserDetails userDetails) {
	return Jwts.builder()
			.setSubject(userDetails.getUsername())
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMs))
			.signWith(SignatureAlgorithm.HS512, jwtSecret)
			.compact();
}

public String extractUsername(String token) {
	return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
}

public boolean validateToken(String token, UserDetails userDetails) {
	String username = extractUsername(token);
	return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
}

public boolean isTokenExpired(String token) {
	Date expiration = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getExpiration();
	return expiration.before(new Date()); // returns true if it is expired 
}
}
