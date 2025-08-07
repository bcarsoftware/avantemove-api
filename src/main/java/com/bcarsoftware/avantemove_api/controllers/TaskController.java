package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.DateIntervalDTO;
import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import com.bcarsoftware.avantemove_api.models.Task;
import com.bcarsoftware.avantemove_api.services.ITaskService;
import com.bcarsoftware.avantemove_api.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController implements ITaskController {
    private final ITaskService taskService = new TaskService();

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody TaskDTO taskDTO) {
        SuccessResponse<Task> successResponse = new SuccessResponse<>();

        successResponse.setData(this.taskService.save(taskDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @GetMapping("/{habitId}/habit")
    public ResponseEntity<?> getTaskByHabit(
        @PathVariable Long habitId,
        @RequestBody DateIntervalDTO dateIntervalDTO
    ) {
        SuccessResponse<List<Task>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.taskService.getTaskByHabit(habitId, dateIntervalDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @GetMapping("/detached")
    public ResponseEntity<?> getTaskHabitDetached(@RequestBody DateIntervalDTO dateIntervalDTO) {
        SuccessResponse<List<Task>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.taskService.getTaskHabitDetached(dateIntervalDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody TaskDTO taskDTO
    ) {
        SuccessResponse<Task> successResponse = new SuccessResponse<>();

        successResponse.setData(this.taskService.update(id, taskDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/finish")
    public ResponseEntity<?> finish(@PathVariable Long id) {
        SuccessResponse<Task> successResponse = new SuccessResponse<>();

        successResponse.setData(this.taskService.finish(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        SuccessResponse<Task> successResponse = new SuccessResponse<>();

        successResponse.setData(this.taskService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
