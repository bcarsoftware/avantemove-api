package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.AccessTokenDTO;
import com.bcarsoftware.avantemove_api.models.AccessToken;

public interface IAccessTokenService {
    AccessToken save(AccessTokenDTO accessTokenDTO);
    AccessToken getAccessTokenByUsername(AccessTokenDTO accessTokenDTO);
    AccessToken getAccessTokenByEmail(AccessTokenDTO accessTokenDTO);
    AccessToken getAccessTokenByToken(AccessTokenDTO accessTokenDTO);
    String deleteAccessTokenByToken(AccessTokenDTO accessTokenDTO);
    String deleteAccessTokenByUsernameOrEmail(String username, String email);
}
