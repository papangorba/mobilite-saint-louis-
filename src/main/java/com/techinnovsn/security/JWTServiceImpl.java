//package com.techinnovsn.security;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
//
//@Service
//public class JWTServiceImpl implements JWTService {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.access-token-expiration}")
//    private long expirationTime;
//
//    @Override
//    public String generateToken(UserDetails userDetails) {
//        return JWT.create()
//                .withSubject(userDetails.getUsername())
//                .withIssuedAt(new Date())
//                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
//                .sign(Algorithm.HMAC512(secret.getBytes()));
//    }
//
//    @Override
//    public String getUserNameFromToken(String token) {
//        return decodeToken(token).getSubject();
//    }
//
//    @Override
//    public boolean validateToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC512(secret.getBytes());
//            JWTVerifier verifier = JWT.require(algorithm).build();
//            verifier.verify(token);
//            return true;
//        } catch (JWTVerificationException e) {
//            return false;
//        }
//    }
//
//    @Override
//    public String refreshToken(String token) {
//        DecodedJWT decodedJWT = decodeToken(token);
//        return JWT.create()
//                .withSubject(decodedJWT.getSubject())
//                .withIssuedAt(new Date())
//                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
//                .sign(Algorithm.HMAC512(secret.getBytes()));
//    }
//
//    @Override
//    public boolean isTokenExpired(String token) {
//        return decodeToken(token).getExpiresAt().before(new Date());
//    }
//
//    @Override
//    public DecodedJWT decodeToken(String token) {
//        Algorithm algorithm = Algorithm.HMAC512(secret.getBytes());
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        return verifier.verify(token);
//    }
//}
