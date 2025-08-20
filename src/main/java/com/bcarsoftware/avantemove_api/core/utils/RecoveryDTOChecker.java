package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.List;

public class RecoveryDTOChecker {
    public static void recoveryDTOChecker(RecoveryDTO recoveryDTO) {
        if (!recoveryDTO.newPassword().matches("^[\\S+]{8,32}$"))
            throw new BodyException("invalid password format or size");

        questionsChecker(List.of(
                recoveryDTO.firstQuestion(),
                recoveryDTO.secondResponse(),
                recoveryDTO.thirdResponse()
        ));

        responsesChecker(List.of(
                recoveryDTO.firstResponse(),
                recoveryDTO.secondResponse(),
                recoveryDTO.thirdResponse()
        ));
    }

    private static void questionsChecker(List<String> questions) {
        String question = "^[A-Za-z0-9.-? ]{2,128}$]";

        questions.forEach(quest -> {
            if (!quest.matches(question))
                throw new BodyException("invalid question format or length");
        });
    }

    private static void responsesChecker(List<String> responses) {
        String response = "^[A-Za-z0-9.-? ]{2,255}$";

        responses.forEach(resp -> {
            if (!resp.matches(response))
                throw new BodyException("invalid question format or length");
        });
    }
}
