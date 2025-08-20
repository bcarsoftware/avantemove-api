package com.bcarsoftware.avantemove_api.dtos;

public record RecoveryDTO(
        Long userId,
        String newPassword,
        String firstQuestion,
        String secondQuestion,
        String thirdQuestion,
        String firstResponse,
        String secondResponse,
        String thirdResponse
) { }
