package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {
    public abstract ResponseEntity<?> save(@RequestBody UserDTO userDTO);
    public abstract ResponseEntity<?> login(@RequestBody LoginDTO loginDTO);
    public abstract ResponseEntity<?> logout(@RequestParam String token);
    public abstract ResponseEntity<?> logoutAll(
        @RequestParam String username,
        @RequestParam String email,
        @RequestParam String token
    );
    public abstract ResponseEntity<?> getById(
        @PathVariable("id") Long id,
        @RequestParam String token
    );
    public abstract ResponseEntity<?> update(
        @PathVariable("id") Long id,
        @RequestBody UserDTO userDTO,
        @RequestParam String token
    );
    public abstract ResponseEntity<?> updatePassword(
        @RequestBody RecoveryDTO recoveryDTO
    );
    public abstract ResponseEntity<?> delete(
        @PathVariable("id") Long id,
        @RequestParam String token
    );
}
