package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBeliefController {
    public abstract ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody BeliefDTO beliefDTO
    );
    public abstract ResponseEntity<?> getBeliefByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    );
    public abstract ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody BeliefDTO beliefDTO
    );
    public abstract ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id
    );
}
