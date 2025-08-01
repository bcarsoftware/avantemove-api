package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/belief")
public class BeliefController implements IBeliefController {
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody BeliefDTO beliefDTO) {
        return null;
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getBeliefByUserId(@PathVariable Long userId) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody BeliefDTO beliefDTO
    ) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
