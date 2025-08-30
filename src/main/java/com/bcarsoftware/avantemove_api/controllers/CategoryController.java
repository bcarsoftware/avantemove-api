package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import com.bcarsoftware.avantemove_api.dtos.DeleteCategoryDTO;
import com.bcarsoftware.avantemove_api.models.Category;
import com.bcarsoftware.avantemove_api.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController implements ICategoryController {
    private final ICategoryService categoryService;
    private final JwtInsert jwtInsert;

    @Autowired
    public CategoryController(ICategoryService categoryService, JwtInsert jwtInsert) {
        this.categoryService = categoryService;
        this.jwtInsert = jwtInsert;
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(
        @RequestParam String token,
        @RequestBody CategoryDTO categoryDTO
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Category> successResponse = new SuccessResponse<>();

        successResponse.setData(this.categoryService.save(categoryDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @GetMapping("/{userId}/user")
    public ResponseEntity<?> getCategoryByUserId(
        @RequestParam String token,
        @PathVariable Long userId
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Category> successResponse = new SuccessResponse<>();

        successResponse.setData(this.categoryService.getCategoryByUserId(userId));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @RequestParam String token,
        @PathVariable Long id,
        @RequestBody CategoryDTO categoryDTO
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Category> successResponse = new SuccessResponse<>();

        successResponse.setData(this.categoryService.update(id, categoryDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
            @RequestParam String token,
            @PathVariable Long id,
            @RequestBody DeleteCategoryDTO categoryDTO
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<Category> successResponse = new SuccessResponse<>();

        successResponse.setData(this.categoryService.delete(id, categoryDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
