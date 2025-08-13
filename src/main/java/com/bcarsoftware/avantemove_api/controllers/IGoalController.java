package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IGoalController {
    public abstract ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody GoalDTO goalDTO
    );
    public abstract ResponseEntity<?> getByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    );
    public abstract ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody GoalDTO goalDTO
    );
    public abstract ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    );
}
