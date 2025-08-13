package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHabitController {
    public abstract ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody HabitDTO habitDTO
    );
    public abstract ResponseEntity<?> getHabitByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    );
    public abstract ResponseEntity<?> getHabitByGoalId(
        @RequestParam String token,
        @PathVariable Long goalId
    );
    public abstract ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody HabitDTO habitDTO
    );
    public abstract ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    );
}
