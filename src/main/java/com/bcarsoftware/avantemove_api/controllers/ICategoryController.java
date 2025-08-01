package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICategoryController {
    public abstract ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO);
    public abstract ResponseEntity<?> getCategoryByUserId(@PathVariable Long userId);
    public abstract ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody CategoryDTO categoryDTO
    );
    public abstract ResponseEntity<?> delete(@PathVariable Long id);
}
