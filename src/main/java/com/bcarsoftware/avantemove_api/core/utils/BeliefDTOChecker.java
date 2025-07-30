package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

public class BeliefDTOChecker {
    public static void beliefDTOChecker(BeliefDTO beliefDTO) {
        String regex = "^[a-zA-Z_0-9][a-zA-Z-_ ,.0-9]{1,512}[a-zA-Z.0-9]$";

        if (!beliefDTO.description().matches(regex))
            throw new BodyException("description does not match");
    }
}
