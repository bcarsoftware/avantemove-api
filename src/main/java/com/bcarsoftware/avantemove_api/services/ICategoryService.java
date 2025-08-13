package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import com.bcarsoftware.avantemove_api.dtos.DeleteCategoryDTO;
import com.bcarsoftware.avantemove_api.models.Category;

public interface ICategoryService {
    Category save(CategoryDTO categoryDTO);
    Category getCategoryByUserId(Long userId);
    Category update(Long id, CategoryDTO categoryDTO);
    Category delete(Long id, DeleteCategoryDTO categoryDTO);
}
