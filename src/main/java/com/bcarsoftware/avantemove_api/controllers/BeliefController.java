package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import com.bcarsoftware.avantemove_api.models.Belief;
import com.bcarsoftware.avantemove_api.services.BeliefService;
import com.bcarsoftware.avantemove_api.services.IBeliefService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/belief")
public class BeliefController implements IBeliefController {
    private final IBeliefService beliefService = new BeliefService();

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody BeliefDTO beliefDTO
    ) {
        SuccessResponse<Belief> successResponse = new SuccessResponse<>();

        successResponse.setData(this.beliefService.save(beliefDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getBeliefByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    ) {
        SuccessResponse<List<Belief>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.beliefService.getBeliefByUserId(userId));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody BeliefDTO beliefDTO
    ) {
        SuccessResponse<Belief> successResponse = new SuccessResponse<>();

        successResponse.setData(this.beliefService.update(id, beliefDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    ) {
        SuccessResponse<Belief> successResponse = new SuccessResponse<>();

        successResponse.setData(this.beliefService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
