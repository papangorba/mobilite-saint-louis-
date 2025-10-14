package com.techinnovsn.security;


import org.springframework.security.core.userdetails.UserDetails;

import com.auth0.jwt.interfaces.DecodedJWT;

public interface JWTService {

    String generateToken(UserDetails userDetails);

    String getUserNameFromToken(String token);

    boolean validateToken(String token);

    String refreshToken(String token);

    boolean isTokenExpired(String token);

    DecodedJWT decodeToken(String token);
}

