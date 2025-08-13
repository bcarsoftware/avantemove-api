package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHabitController {
    ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody HabitDTO habitDTO
    );
    ResponseEntity<?> getHabitByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    );
    ResponseEntity<?> getHabitByGoalId(
        @RequestParam String token,
        @PathVariable Long goalId
    );
    ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody HabitDTO habitDTO
    );
    ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    );
}
