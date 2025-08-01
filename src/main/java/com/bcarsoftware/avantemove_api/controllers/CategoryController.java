package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController implements ICategoryController {
    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getCategoryByUserId(@PathVariable Long userId) {
        return null;
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody CategoryDTO categoryDTO
    ) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
