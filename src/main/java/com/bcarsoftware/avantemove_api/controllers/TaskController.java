package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController implements ITaskController {
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody TaskDTO taskDTO) {
        return null;
    }

    @Override
    @GetMapping("/{habitId}/habit")
    public ResponseEntity<?> getTaskByHabit(@PathVariable Long habitId) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody TaskDTO taskDTO
    ) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/finish")
    public ResponseEntity<?> finish(@PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
