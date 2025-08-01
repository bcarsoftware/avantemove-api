package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habit")
public class HabitController implements IHabitController{
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody HabitDTO habitDTO) {
        return null;
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getHabitByUserId(@PathVariable Long userId) {
        return null;
    }

    @Override
    @GetMapping("/{goalId}/goal")
    public ResponseEntity<?> getHabitByGoalId(@PathVariable Long goalId) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody HabitDTO habitDTO
    ) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
