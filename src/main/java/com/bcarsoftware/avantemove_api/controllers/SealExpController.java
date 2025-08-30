package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import com.bcarsoftware.avantemove_api.models.SealExp;
import com.bcarsoftware.avantemove_api.services.ISealExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seal-exp")
public class SealExpController implements ISealExpController {
    private final ISealExpService sealExpService;

    @Autowired
    public SealExpController(ISealExpService sealExpService) {
        this.sealExpService = sealExpService;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody SealExpDTO sealExpDTO) {
        SuccessResponse<SealExp> successResponse = new SuccessResponse<>();

        successResponse.setData(this.sealExpService.save(sealExpDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAllSealExp() {
        SuccessResponse<List<SealExp>> successResponse = new SuccessResponse<>();

        successResponse.setData(this.sealExpService.getAllSealExp());
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody SealExpDTO sealExpDTO
    ) {
        SuccessResponse<SealExp> successResponse = new SuccessResponse<>();

        successResponse.setData(this.sealExpService.update(id, sealExpDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @GetMapping("/{experience}/user")
    public ResponseEntity<?> getSealExpByUserExperience(@PathVariable int experience) {
        SuccessResponse<SealExp> successResponse = new SuccessResponse<>();

        successResponse.setData(this.sealExpService.getSealExpByUserExperience(experience));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        SuccessResponse<SealExp> successResponse = new SuccessResponse<>();

        successResponse.setData(this.sealExpService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
