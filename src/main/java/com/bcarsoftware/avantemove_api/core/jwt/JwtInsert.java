package com.bcarsoftware.avantemove_api.core.jwt;

import com.bcarsoftware.avantemove_api.core.environ.EnvironLoader;
import com.bcarsoftware.avantemove_api.dtos.AccessTokenDTO;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import com.bcarsoftware.avantemove_api.models.AccessToken;
import com.bcarsoftware.avantemove_api.services.AccessTokenService;
import com.bcarsoftware.avantemove_api.services.IAccessTokenService;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtInsert {
    private final IAccessTokenService accessTokenService = new AccessTokenService();
    private final EnvironLoader environ = new EnvironLoader();

    private SecretKey getSecretKey() {
        String keyString = environ.getSecret();

        byte[] keyBytes = Base64.getDecoder().decode(keyString);

        return new SecretKeySpec(keyBytes, environ.getAlgorithm());
    }

    public String createToken(Long userId, String username, String role) {
        SecretKey key = this.getSecretKey();

        String token = Jwts.builder().subject(userId.toString())
                .claim("role", role)
                .issuer(this.environ.getAppName())
                .issuedAt(new Date())
                .expiration(
                    new Date(System.currentTimeMillis() + this.environ.getExpiration())
                )
                .signWith(key)
                .compact();

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO(username, token);

        this.accessTokenService.save(accessTokenDTO);

        return token;
    }

    public void verifyToken(String token) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO(null, token);

        var result = this.accessTokenService.getAccessTokenByToken(accessTokenDTO);

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

    public AccessToken getAccessTokenByToken(String token) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO(null, token);

        AccessToken accessToken = this.accessTokenService.getAccessTokenByToken(accessTokenDTO);

        if (accessToken == null)
            throw new AuthException("user not found to that token");

        return accessToken;
    }

    public boolean deleteTokenByToken(String token) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO(null, token);

        String result = this.accessTokenService.deleteAccessTokenByToken(accessTokenDTO);

        return result != null && result.contains("deleted");
    }

    public boolean deleteAllTokensUser(String username, String email) {
        String result = this.accessTokenService.deleteAccessTokenByUsernameOrEmail(username, email);

        return result != null && result.contains("deleted");
    }
}
