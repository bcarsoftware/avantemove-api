package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IHabitController {
    public abstract ResponseEntity<?> save(@RequestBody HabitDTO habitDTO);
    public abstract ResponseEntity<?> getHabitByUserId(@PathVariable Long userId);
    public abstract ResponseEntity<?> getHabitByGoalId(@PathVariable Long goalId);
    public abstract ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody HabitDTO habitDTO
    );
    public abstract ResponseEntity<?> delete(@PathVariable Long id);
}
