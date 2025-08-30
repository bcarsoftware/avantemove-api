package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.RecoveryDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.Recovery;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.RecoveryRepository;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryService implements IRecoveryService {
    private final UserRepository userRepository;
    private final RecoveryRepository recoveryRepository;

    @Autowired
    public RecoveryService(UserRepository userRepository, RecoveryRepository recoveryRepository) {
        this.userRepository = userRepository;
        this.recoveryRepository = recoveryRepository;
    }

    @Override
    public Recovery save(RecoveryDTO recoveryDTO) {
        Recovery recovery = this.getRecoveryFromDTO(recoveryDTO);

        try {
            return this.recoveryRepository.save(recovery);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public Recovery getRecoveryByUser(String username) {
        User user = this.userRepository.findUserByUsernameOrEmail(username, username)
                .orElseThrow(() -> new DatabaseException("user not found", 404));

        Recovery recovery = this.recoveryRepository.findFirstByUserId(user.getId());

        if (recovery == null)
            throw new DatabaseException("user not found", 404);

        return recovery;
    }

    @Override
    public Recovery update(Long id, RecoveryDTO recoveryDTO) {
        Recovery data = this.recoveryRepository.findFirstByUserId(id);

        if (data == null)
            throw new DatabaseException("recovery not found", 404);

        Recovery recovery = this.getRecoveryFromDTO(data, recoveryDTO);

        try {
            return this.recoveryRepository.save(recovery);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public Recovery updateUserPassword(String username, RecoveryDTO recoveryDTO) {
        User user = this.userRepository.findUserByUsernameOrEmail(username, username)
                .orElseThrow(() -> new DatabaseException("user not found", 404));

        Recovery recovery = this.recoveryRepository.findFirstByUserId(user.getId());

        if (recovery == null)
            throw new DatabaseException("recovery data not found", 404);

        List<String> originalQuestions = List.of(
            recovery.getFirstQuestion(), recovery.getSecondQuestion(), recovery.getThirdQuestion()
        );

        List<String> recoveryQuestions = List.of(
            recoveryDTO.firstQuestion(), recoveryDTO.secondQuestion(), recoveryDTO.thirdQuestion()
        );

        List<String> originalResponses = List.of(
            recovery.getFirstResponse(), recovery.getSecondResponse(), recovery.getThirdResponse()
        );

        List<String> recoveryResponses = List.of(
            recoveryDTO.firstResponse(), recoveryDTO.secondResponse(), recoveryDTO.thirdResponse()
        );

        RecoveryDTOChecker.checkContentQuestionsResponses(
            originalQuestions, recoveryQuestions,
            originalResponses, recoveryResponses
        );

        try {
            user.setPassword(recoveryDTO.newPassword());

            this.userRepository.save(user);

            return recovery;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    private Recovery getRecoveryFromDTO(RecoveryDTO recoveryDTO) {
        Recovery recovery = new Recovery();

        User user = this.userRepository.findById(recoveryDTO.userId())
                .orElseThrow(() -> new DatabaseException("user not found", 404));

        recovery.setUser(user);

        return this.getRecovery(recovery, recoveryDTO);
    }

    private Recovery getRecoveryFromDTO(Recovery recovery, RecoveryDTO recoveryDTO) {
        return this.getRecovery(recovery, recoveryDTO);
    }

    private Recovery getRecovery(Recovery recovery, RecoveryDTO recoveryDTO) {
        RecoveryDTOChecker.recoveryDTOChecker(recoveryDTO);

        RecoveryDTOChecker.checkUniqueQuestionsAnswers(
            List.of(recoveryDTO.firstQuestion(), recoveryDTO.secondQuestion(), recoveryDTO.thirdQuestion()),
            List.of(recoveryDTO.firstResponse(), recoveryDTO.secondResponse(), recoveryDTO.thirdResponse())
        );

        recovery.setFirstQuestion(recoveryDTO.firstQuestion());
        recovery.setSecondQuestion(recoveryDTO.secondQuestion());
        recovery.setThirdQuestion(recoveryDTO.thirdQuestion());

        recovery.setFirstResponse(recoveryDTO.firstResponse());
        recovery.setSecondResponse(recoveryDTO.secondResponse());
        recovery.setThirdResponse(recoveryDTO.thirdResponse());

        return recovery;
    }
}
