package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.AccessTokenDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

public class AccessTokenDTOChecker {
    private static final String EMAIL_REGEX = "^[a-z][a-z0-9._-]{1,254}[a-z0-9]@[a-z0-9]{1,16}(.[a-z]{2,3}){1,2}$";
    private static final String USERNAME_REGEX = "^[a-z][a-z-_0-9]{1,254}$";

    public static void checkEmailAccessToken(AccessTokenDTO accessTokenDTO) {
        if (!accessTokenDTO.username().matches(EMAIL_REGEX))
            throw new BodyException("access token invalid email address");
    }

    public static void checkUsernameAccessToken(AccessTokenDTO accessTokenDTO) {
        if (!accessTokenDTO.username().matches(USERNAME_REGEX))
            throw new BodyException("access token invalid email address");
    }

    public static void checkTokenLength512(AccessTokenDTO accessTokenDTO) {
        if (accessTokenDTO.token().length() > 512)
            throw new BodyException("access token too long");
    }

    public static void accessTokenDTOChecker(AccessTokenDTO accessTokenDTO) {
        checkTokenLength512(accessTokenDTO);

        if (accessTokenDTO.username().contains("@")) {
            checkEmailAccessToken(accessTokenDTO);
        } else {
            checkUsernameAccessToken(accessTokenDTO);
        }
    }
}
