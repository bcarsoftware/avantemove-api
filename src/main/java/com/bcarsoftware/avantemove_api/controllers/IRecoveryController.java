package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IRecoveryController {
    ResponseEntity<?> save(@RequestBody RecoveryDTO recoveryDTO);
    ResponseEntity<?> getRecoveryByUser(@PathVariable String username);
    ResponseEntity<?> update(
        @RequestHeader("Authorization") String token,
        @PathVariable Long userId,
        @RequestBody RecoveryDTO recoveryDTO
    );
    ResponseEntity<?> updateUserPassword(
        @PathVariable String username,
        @RequestBody RecoveryDTO recoveryDTO
    );
}
