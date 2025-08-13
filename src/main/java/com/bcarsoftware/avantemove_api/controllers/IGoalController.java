package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IGoalController {
    ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody GoalDTO goalDTO
    );
    ResponseEntity<?> getByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    );
    ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody GoalDTO goalDTO
    );
    ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    );
}
