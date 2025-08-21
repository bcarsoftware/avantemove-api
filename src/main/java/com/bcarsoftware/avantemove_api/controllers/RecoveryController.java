package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.models.Recovery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recovery")
public class RecoveryController implements IRecoveryController {
    private final JwtInsert jwtInsert = new JwtInsert();

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody RecoveryDTO recoveryDTO) {
        SuccessResponse<Recovery> successResponse = new SuccessResponse<>();

        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @GetMapping("/{username}/user")
    public ResponseEntity<?> getRecoveryByUser(@PathVariable String username) {
        SuccessResponse<Recovery> successResponse = new SuccessResponse<>();

        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{userId}/user")
    public ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long userId,
        @RequestBody RecoveryDTO recoveryDTO
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Recovery> successResponse = new SuccessResponse<>();

        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{username}/user")
    public ResponseEntity<?> updateUserPassword(
        @PathVariable String username,
        @RequestBody RecoveryDTO recoveryDTO
    ) {
        SuccessResponse<Recovery> successResponse = new SuccessResponse<>();

        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
