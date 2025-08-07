package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ISealExpController {
    public abstract ResponseEntity<?> save(@RequestBody SealExpDTO sealExpDTO);
    public abstract ResponseEntity<?> getAllSealExp();
    public abstract ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody SealExpDTO sealExpDTO
    );
    public abstract ResponseEntity<?> getSealExpByUserExperience(@PathVariable int experience);
    public abstract ResponseEntity<?> delete(@PathVariable Long id);
}
