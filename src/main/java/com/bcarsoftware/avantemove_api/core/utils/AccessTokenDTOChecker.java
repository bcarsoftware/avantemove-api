package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.AccessTokenDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.List;

public class AccessTokenDTOChecker {
    public static void accessTokenDTOChecker(AccessTokenDTO accessTokenDTO) {
        boolean tokenGreater512length = accessTokenDTO.token().length() > 512;

        if (!tokenGreater512length)
            throw new BodyException("token is too long");

        String emailRegex = "^[a-z][a-z0-9._-]{1,254}[a-z0-9]@[a-z0-9]{1,16}(.[a-z]{2,3}){1,2}$";
        String usernameRegex = "^[a-z][a-z-_0-9]{1,254}$";

        List<Boolean> checkersUsername = List.of(
            accessTokenDTO.username().matches(emailRegex),
            accessTokenDTO.username().matches(usernameRegex)
        );

        if (!checkersUsername.contains(true))
            throw new BodyException("username isn't a valid username or email");
    }
}
