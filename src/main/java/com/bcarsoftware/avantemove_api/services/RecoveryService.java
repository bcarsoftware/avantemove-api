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
    public Recovery update(Long userId, RecoveryDTO recoveryDTO) {
        Recovery data = this.recoveryRepository.findFirstByUserId(userId);

        if (data == null)
            throw new DatabaseException("recovery not found", 404);

        this.getRecoveryFromDTO(data, recoveryDTO);

        try {
            return this.recoveryRepository.save(data);
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

        this.getRecoveryFromDTO(recovery, recoveryDTO);

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
        RecoveryDTOChecker.checkUniqueQuestionsAnswers(recoveryDTO);

        Recovery recovery = new Recovery();

        User user = this.userRepository.findById(recoveryDTO.userId())
                .orElseThrow(() -> new DatabaseException("user not found", 404));

        recovery.setUser(user);

        this.getRecovery(recovery, recoveryDTO);

        return recovery;
    }

    private void getRecoveryFromDTO(Recovery recovery, RecoveryDTO recoveryDTO) {
        RecoveryDTOChecker.recoveryDTOChecker(recoveryDTO);
        this.getRecovery(recovery, recoveryDTO);
    }

    private void getRecovery(Recovery recovery, RecoveryDTO recoveryDTO) {
        recovery.setFirstQuestion(recoveryDTO.firstQuestion());
        recovery.setSecondQuestion(recoveryDTO.secondQuestion());
        recovery.setThirdQuestion(recoveryDTO.thirdQuestion());

        recovery.setFirstResponse(recoveryDTO.firstResponse());
        recovery.setSecondResponse(recoveryDTO.secondResponse());
        recovery.setThirdResponse(recoveryDTO.thirdResponse());
    }
}
