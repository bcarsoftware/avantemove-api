package com.bcarsoftware.avantemove_api.core.jwt;

import com.bcarsoftware.avantemove_api.core.environ.EnvironLoader;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtInsert {
    private final EnvironLoader environ = new EnvironLoader();

    private SecretKey getSecretKey() {
        String keyString = environ.getSecret();

        byte[] keyBytes = Base64.getDecoder().decode(keyString);

        return new SecretKeySpec(keyBytes, environ.getAlgorithm());
    }

    public String createToken(Long userId, String role) {
        SecretKey key = this.getSecretKey();

        return Jwts.builder().subject(userId.toString())
                .claim("role", role)
                .issuer(this.environ.getAppName())
                .issuedAt(new Date())
                .expiration(
                    new Date(System.currentTimeMillis() + this.environ.getExpiration())
                )
                .signWith(key)
                .compact();
    }

    public void verifyToken(String token) {
        SecretKey key = this.getSecretKey();

        try {
            Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token);
        }
        catch (Exception e) {
            throw new AuthException("user not authorized");
        }
    }
}
