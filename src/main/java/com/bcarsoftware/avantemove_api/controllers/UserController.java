package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController{
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        return null;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        return null;
    }

    @Override
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String token) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
        @PathVariable Integer id,
        @RequestParam String token
    ) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Integer id,
        @RequestBody UserDTO userDTO,
        @RequestParam String token
    ) {
        return null;
    }

    @Override
    @PatchMapping("/recovery")
    public ResponseEntity<?> updatePassword(RecoveryDTO recoveryDTO) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
        @PathVariable Integer id,
        @RequestParam String token
    ) {
        return null;
    }
}
