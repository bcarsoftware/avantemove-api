package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.AccessTokenDTO;
import com.bcarsoftware.avantemove_api.models.AccessToken;

public interface IAccessTokenService {
    public abstract AccessToken save(AccessTokenDTO accessTokenDTO);
    public abstract AccessToken getAccessTokenByUsername(AccessTokenDTO accessTokenDTO);
    public abstract AccessToken getAccessTokenByEmail(AccessTokenDTO accessTokenDTO);
    public abstract AccessToken getAccessTokenByToken(AccessTokenDTO accessTokenDTO);
    public abstract String deleteAccessTokenByToken(AccessTokenDTO accessTokenDTO);
    public abstract String deleteAccessTokenByUsernameOrEmail(String username, String email);
}
