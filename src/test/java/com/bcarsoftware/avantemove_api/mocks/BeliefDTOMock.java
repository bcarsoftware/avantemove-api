package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;

public class BeliefDTOMock {
    public static BeliefDTO success() {
        return new BeliefDTO(1L, "Description phrase make again");
    }

    public static BeliefDTO failedDescriptionEmpty() {
        return new BeliefDTO(1L, "");
    }

    public static BeliefDTO failedDescriptionChars() {
        return new BeliefDTO(1L, "Description phrase make again#");
    }

    public static BeliefDTO failedDescriptionMaxLength() {
        return new BeliefDTO(1L, "Ab".repeat(257));
    }

    public static BeliefDTO failedDescriptionMinLength() {
        return new BeliefDTO(1L, "Ab");
    }
}
