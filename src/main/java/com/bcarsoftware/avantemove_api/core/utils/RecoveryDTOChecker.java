package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.List;

public class RecoveryDTOChecker {
    public static void recoveryDTOChecker(RecoveryDTO recoveryDTO) {
        if (!recoveryDTO.newPassword().matches("^[\\S+]{8,32}$"))
            throw new BodyException("invalid password format or size");

        checkUniqueQuestionsAnswers(recoveryDTO);
    }

    public static void checkUniqueQuestionsAnswers(RecoveryDTO recoveryDTO) {
        questionsChecker(recoveryDTO);
        responsesChecker(recoveryDTO);
        checkUniqueQuestions(recoveryDTO);
        checkUniqueAnswers(recoveryDTO);
    }

    public static void checkOriginalNewerRecoveryPassword(
        RecoveryDTO originalDTO,
        RecoveryDTO recoveryDTO
    ) {
        recoveryDTOChecker(recoveryDTO);

        List<String> originalQuestions = getQuestions(recoveryDTO);
        List<String> recoveryQuestions = getQuestions(originalDTO);
        List<String> originalResponses = getResponses(recoveryDTO);
        List<String> recoveryResponses = getResponses(originalDTO);

        int length = originalQuestions.size();

        for (int i = 0; i < length; i++) {
            if (!originalQuestions.get(i).equalsIgnoreCase(recoveryQuestions.get(i)))
                throw new BodyException("questions don't match");
            if (!originalResponses.get(i).equalsIgnoreCase(recoveryResponses.get(i)))
                throw new BodyException("answers don't match");
        }
    }

    // Private Methods */

    private static void checkUniqueQuestions(RecoveryDTO recoveryDTO) {
        List<String> questions = getQuestions(recoveryDTO);

        questions.forEach(quest -> {
            long equals = questions.stream().filter(quest::equalsIgnoreCase).count();

            if (equals > 1) throw new BodyException("questions must be unique");
        });
    }

    private static void checkUniqueAnswers(RecoveryDTO recoveryDTO) {
        List<String> questions = getQuestions(recoveryDTO);

        questions.forEach(quest -> {
            long equals = questions.stream().filter(quest::equalsIgnoreCase).count();

            if (equals > 1) throw new BodyException("answers must be unique");
        });
    }

    private static void questionsChecker(RecoveryDTO recoveryDTO) {
        String question = "^[\\p{L}0-9.? -]{2,128}$";

        List<String> questions = getQuestions(recoveryDTO);

        questions.forEach(quest -> {
            if (!quest.matches(question))
                throw new BodyException("invalid question format or length");
        });
    }

    private static void responsesChecker(RecoveryDTO recoveryDTO) {
        String response = "^[\\p{L}0-9.? -]{2,255}$";

        List<String> responses = getResponses(recoveryDTO);

        responses.forEach(resp -> {
            if (!resp.matches(response))
                throw new BodyException("invalid response format or length =" +resp);
        });
    }

    private static List<String> getQuestions(RecoveryDTO recoveryDTO) {
        return List.of(
            recoveryDTO.firstQuestion(),
            recoveryDTO.secondQuestion(),
            recoveryDTO.thirdQuestion()
        );
    }

    private static List<String> getResponses(RecoveryDTO recoveryDTO) {
        return List.of(
            recoveryDTO.firstResponse(),
            recoveryDTO.secondResponse(),
            recoveryDTO.thirdResponse()
        );
    }
}
