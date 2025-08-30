package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import com.bcarsoftware.avantemove_api.models.Habit;
import com.bcarsoftware.avantemove_api.services.IHabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit")
public class HabitController implements IHabitController{
    private final IHabitService habitService;
    private final JwtInsert jwtInsert;

    @Autowired
    public HabitController(IHabitService habitService, JwtInsert jwtInsert) {
        this.habitService = habitService;
        this.jwtInsert = jwtInsert;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody HabitDTO habitDTO
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Habit> successResponse = new SuccessResponse<>();

        successResponse.setData(this.habitService.save(habitDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getHabitByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<List<Habit>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.habitService.getHabitByUserId(userId));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @GetMapping("/{goalId}/goal")
    public ResponseEntity<?> getHabitByGoalId(
        @RequestParam String token,
        @PathVariable Long goalId
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<List<Habit>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.habitService.getHabitByGoalId(goalId));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody HabitDTO habitDTO
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Habit> successResponse = new SuccessResponse<>();

        successResponse.setData(this.habitService.update(id, habitDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Habit> successResponse = new SuccessResponse<>();

        successResponse.setData(this.habitService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
