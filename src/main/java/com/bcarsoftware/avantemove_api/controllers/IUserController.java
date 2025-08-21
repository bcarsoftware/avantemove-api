package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {
    ResponseEntity<?> save(@RequestBody UserDTO userDTO);
    ResponseEntity<?> login(@RequestBody LoginDTO loginDTO);
    ResponseEntity<?> logout(@RequestParam String token);
    ResponseEntity<?> logoutAll(
        @RequestParam String username,
        @RequestParam String email,
        @RequestParam String token
    );
    ResponseEntity<?> getById(
        @PathVariable("id") Long id,
        @RequestParam String token
    );
    ResponseEntity<?> update(
        @PathVariable("id") Long id,
        @RequestBody UserDTO userDTO,
        @RequestParam String token
    );
    ResponseEntity<?> delete(
        @PathVariable("id") Long id,
        @RequestParam String token
    );
}
