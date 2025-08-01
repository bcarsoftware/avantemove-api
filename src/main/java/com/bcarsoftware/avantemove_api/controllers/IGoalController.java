package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IGoalController {
    public abstract ResponseEntity<?> save(@RequestBody GoalDTO goalDTO);
    public abstract ResponseEntity<?> getByUserId(@PathVariable Long userId);
    public abstract ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody GoalDTO goalDTO
    );
    public abstract ResponseEntity<?> delete(@PathVariable Long id);
}
