package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IBeliefController {
    public abstract ResponseEntity<?> save(@RequestBody BeliefDTO beliefDTO);
    public abstract ResponseEntity<?> getBeliefByUserId(@PathVariable Long userId);
    public abstract ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody BeliefDTO beliefDTO
    );
    public abstract ResponseEntity<?> delete(@PathVariable Long id);
}
