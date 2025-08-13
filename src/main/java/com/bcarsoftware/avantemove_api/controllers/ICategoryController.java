package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import com.bcarsoftware.avantemove_api.dtos.DeleteCategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICategoryController {
    public abstract ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody CategoryDTO categoryDTO
    );
    public abstract ResponseEntity<?> getCategoryByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    );
    public abstract ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody CategoryDTO categoryDTO
    );
    public abstract ResponseEntity<?> delete(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody DeleteCategoryDTO categoryDTO
    );
}
