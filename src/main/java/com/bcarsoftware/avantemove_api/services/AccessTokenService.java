package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.AccessTokenDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.AccessTokenDTO;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import com.bcarsoftware.avantemove_api.models.AccessToken;
import com.bcarsoftware.avantemove_api.repositories.AccessTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService implements IAccessTokenService {
    private final AccessTokenRepository accessTokenRepository;

    @Autowired
    public AccessTokenService(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    @Override
    public AccessToken save(AccessTokenDTO accessTokenDTO) {
        AccessTokenDTOChecker.accessTokenDTOChecker(accessTokenDTO);

        AccessToken accessToken = this.accessTokenRepository.findFirstByUsername(accessTokenDTO.username());

        accessToken = accessToken == null ? new AccessToken() : accessToken;

        accessToken.setUsername(accessTokenDTO.username());
        accessToken.setToken(accessTokenDTO.token());

        return accessTokenRepository.save(accessToken);
    }

    @Override
    public AccessToken getAccessTokenByUsername(AccessTokenDTO accessTokenDTO) {
        AccessTokenDTOChecker.checkUsernameAccessToken(accessTokenDTO);

        AccessToken accessToken = this.accessTokenRepository.findFirstByUsername(accessTokenDTO.username());

        if (accessToken == null)
            throw new AuthException("access token user not authorized");

        return accessToken;
    }

    @Override
    public AccessToken getAccessTokenByEmail(AccessTokenDTO accessTokenDTO) {
        AccessTokenDTOChecker.checkEmailAccessToken(accessTokenDTO);

        AccessToken accessToken = this.accessTokenRepository.findFirstByUsername(accessTokenDTO.username());

        if (accessToken == null)
            throw new AuthException("access token user not authorized");

        return accessToken;
    }

    @Override
    public AccessToken getAccessTokenByToken(AccessTokenDTO accessTokenDTO) {
        AccessTokenDTOChecker.checkTokenLength512(accessTokenDTO);

        AccessToken accessToken = this.accessTokenRepository.findFirstByToken(accessTokenDTO.token());

        if (accessToken == null)
            throw new AuthException("access token user not authorized");

        return accessToken;
    }

    @Override
    public String deleteAccessTokenByToken(AccessTokenDTO accessTokenDTO) {
        AccessTokenDTOChecker.checkTokenLength512(accessTokenDTO);

        int deleted = this.accessTokenRepository.deleteAccessTokenByToken(accessTokenDTO.token());

        if (deleted == 0)
            throw new AuthException("access token user not authorized");

        return "access token deleted successfully";
    }

    @Override
    public String deleteAccessTokenByUsernameOrEmail(String username, String email) {
        AccessTokenDTO accessUsername = new AccessTokenDTO(username, null);
        AccessTokenDTO accessEmail = new AccessTokenDTO(email, null);

        AccessTokenDTOChecker.checkUsernameAccessToken(accessUsername);
        AccessTokenDTOChecker.checkEmailAccessToken(accessEmail);

        int deleted = this.accessTokenRepository.deleteAccessTokenByUsernameOrEmail(username, email);

        if (deleted == 0)
            throw new AuthException("access token user not authorized");

        return "access tokens deleted successfully";
    }
}
