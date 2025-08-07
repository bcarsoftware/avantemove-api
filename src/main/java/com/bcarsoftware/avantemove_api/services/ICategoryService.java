package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import com.bcarsoftware.avantemove_api.models.Category;

public interface ICategoryService {
    public abstract Category save(CategoryDTO categoryDTO);
    public abstract Category getCategoryByUserId(Long userId);
    public abstract Category update(Long id, CategoryDTO categoryDTO);
    public abstract Category delete(Long id, String categoryName);
}
