package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goal")
public class GoalController implements IGoalController {
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody GoalDTO goalDTO) {
        return null;
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody GoalDTO goalDTO
    ) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
