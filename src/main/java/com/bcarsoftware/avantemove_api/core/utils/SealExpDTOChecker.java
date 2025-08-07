package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

public class SealExpDTOChecker {
    public static void sealExpDTOChecker(SealExpDTO sealExpDTO) {
        if (sealExpDTO.finishXp() < 1)
            throw new BodyException("seal exp start xp can't be small than one");

        String regex = "^[A-Z][a-zA-Z- .]{1,62}[a-zA-Z.]$";

        if (!sealExpDTO.name().matches(regex))
            throw new BodyException("seal exp name does not match");
    }
}
