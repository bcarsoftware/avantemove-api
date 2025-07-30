package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;

public class SealExpDTOMock {
    public static SealExpDTO success() {
        return new SealExpDTO(
            "Lion",
            10,
            20
        );
    }

    public static SealExpDTO failedSealExpName() {
        return new SealExpDTO(
            "Lion Golden#",
            10,
            20
        );
    }

    public static SealExpDTO failedSealExpMaxLength() {
        return new SealExpDTO(
            "Li".repeat(33),
            10,
            20
        );
    }

    public static SealExpDTO failedSealExpMinLength() {
        return new SealExpDTO(
            "Li",
            10,
            20
        );
    }

    public static SealExpDTO failedSealExpStartXP() {
        return new SealExpDTO(
            "Lion",
            -1,
            20
        );
    }

    public static SealExpDTO failedSealExpXPS() {
        return new SealExpDTO(
            "Lion",
            21,
            20
        );
    }
}
