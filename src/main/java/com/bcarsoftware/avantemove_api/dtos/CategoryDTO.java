package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.core.utils.CategoryDTOChecker;

import java.util.List;

public record CategoryDTO(
        Long userId,
        List<String> categories
) {
    public CategoryDTO {
        CategoryDTOChecker.categoryDTOChecker(this);
    }
}
