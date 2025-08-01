package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seal-exp")
public class SealExpController implements ISealExpController {
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody SealExpDTO sealExpDTO) {
        return null;
    }

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAllSealExp() {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody SealExpDTO sealExpDTO
    ) {
        return null;
    }

    @Override
    @GetMapping("/{experience}/user")
    public ResponseEntity<?> getSealExpByUserExperience(@PathVariable Long experience) {
        return null;
    }
}
