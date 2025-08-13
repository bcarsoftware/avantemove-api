package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.DateIntervalDTO;
import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ITaskController {
    public abstract ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody TaskDTO taskDTO
    );
    public abstract ResponseEntity<?> getTaskByHabit(
        @RequestParam String token,
        @PathVariable Long habitId,
        @RequestBody DateIntervalDTO dateIntervalDTO
    );
    public abstract ResponseEntity<?> getTaskHabitDetached(
        @RequestParam String token,
        @RequestBody DateIntervalDTO dateIntervalDTO
    );
    public abstract ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody TaskDTO taskDTO
    );
    public abstract ResponseEntity<?> finish(
        @RequestParam String token,
        @PathVariable Long id
    );
    public abstract ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    );
}
