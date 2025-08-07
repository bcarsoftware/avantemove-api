package com.bcarsoftware.avantemove_api.dtos;

public record DeleteCategoryDTO(String category) {
    public DeleteCategoryDTO {
        category = category.toLowerCase();
    }
}
