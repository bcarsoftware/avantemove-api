package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import com.bcarsoftware.avantemove_api.models.Goal;
import com.bcarsoftware.avantemove_api.services.GoalService;
import com.bcarsoftware.avantemove_api.services.IGoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController implements IGoalController {
    private final IGoalService goalService = new GoalService();

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody GoalDTO goalDTO
    ) {
        SuccessResponse<Goal> successResponse = new SuccessResponse<>();

        successResponse.setData(this.goalService.save(goalDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    ) {
        SuccessResponse<List<Goal>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.goalService.getByUserId(userId));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody GoalDTO goalDTO
    ) {
        SuccessResponse<Goal> successResponse = new SuccessResponse<>();

        successResponse.setData(this.goalService.update(id, goalDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    ) {
        SuccessResponse<Goal> successResponse = new SuccessResponse<>();

        successResponse.setData(this.goalService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
