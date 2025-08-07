package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.DateIntervalDTO;
import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITaskController {
    public abstract ResponseEntity<?> save(@RequestBody TaskDTO taskDTO);
    public abstract ResponseEntity<?> getTaskByHabit(
        @PathVariable Long habitId,
        @RequestBody DateIntervalDTO dateIntervalDTO
    );
    public abstract ResponseEntity<?> getTaskHabitDetached(@RequestBody DateIntervalDTO dateIntervalDTO);
    public abstract ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody TaskDTO taskDTO
    );
    public abstract ResponseEntity<?> finish(@PathVariable Long id);
    public abstract ResponseEntity<?> delete(@PathVariable Long id);
}
