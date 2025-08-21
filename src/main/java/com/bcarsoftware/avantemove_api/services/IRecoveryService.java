package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.models.Recovery;

public interface IRecoveryService {
    Recovery save(RecoveryDTO recoveryDTO);
    Recovery getRecoveryByUser(String username);
    Recovery update(Long id, RecoveryDTO recoveryDTO);
    Recovery updateUserPassword(
        String username,
        RecoveryDTO recoveryDTO
    );
}
