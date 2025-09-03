package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.TokenDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {
    ResponseEntity<?> save(@RequestBody UserDTO userDTO);
    ResponseEntity<?> login(@RequestBody LoginDTO loginDTO);
    ResponseEntity<?> logout(@RequestHeader("Authorization") String token);
    ResponseEntity<?> logoutAll(
        @RequestParam String username,
        @RequestParam String email,
        @RequestHeader("Authorization") String token
    );
    ResponseEntity<?> getById(
        @PathVariable("id") Long id,
        @RequestHeader("Authorization") String token
    );
    ResponseEntity<?> update(
        @PathVariable("id") Long id,
        @RequestBody UserDTO userDTO,
        @RequestHeader("Authorization") String token
    );
    ResponseEntity<?> delete(
        @PathVariable("id") Long id,
        @RequestHeader("Authorization") String token
    );
    ResponseEntity<?> getUserByToken(@RequestBody TokenDTO tokenDTO);
}
