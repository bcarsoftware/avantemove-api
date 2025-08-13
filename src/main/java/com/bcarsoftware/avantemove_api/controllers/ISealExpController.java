package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ISealExpController {
    ResponseEntity<?> save(@RequestBody SealExpDTO sealExpDTO);
    ResponseEntity<?> getAllSealExp();
    ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody SealExpDTO sealExpDTO
    );
    ResponseEntity<?> getSealExpByUserExperience(@PathVariable int experience);
    ResponseEntity<?> delete(@PathVariable Long id);
}
