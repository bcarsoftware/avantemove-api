package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.CategoryDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import com.bcarsoftware.avantemove_api.dtos.DeleteCategoryDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.Category;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.CategoryRepository;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Category save(CategoryDTO categoryDTO) {
        if (this.isUserPresent(categoryDTO.userId()))
            throw new BodyException("category's list exists for that user");

        Category category = this.transferCategoryDtoToCategory(categoryDTO);

        return this.categoryRepository.save(category);
    }

    @Override
    public Category getCategoryByUserId(Long userId) {
        Category category = this.categoryRepository.findFirstByUserId(userId);

        if (category == null)
            throw new DatabaseException("category not found", 404);

        return category;
    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findFirstById(id);

        if (category == null)
            throw new DatabaseException("category not found", 404);

        Category categoryData = this.transferCategoryDtoToCategory(categoryDTO, category);

        return this.categoryRepository.save(categoryData);
    }

    @Override
    public Category delete(Long id, DeleteCategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findFirstById(id);

        if (category == null)
            throw new DatabaseException("category not found", 404);

        category.getCategories().remove(categoryDTO.category());

        return this.categoryRepository.save(category);
    }

    protected Category transferCategoryDtoToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();

        return this.getCategory(categoryDTO, category);
    }

    protected Category transferCategoryDtoToCategory(CategoryDTO categoryDTO, Category category) {
        return this.getCategory(categoryDTO, category);
    }

    private Category getCategory(CategoryDTO categoryDTO, Category category) {
        CategoryDTOChecker.categoryDTOChecker(categoryDTO);
        List<String> categories = categoryDTO.categories().stream().map(String::toLowerCase).toList();

        User user = this.getUser(categoryDTO.userId());

        category.setUser(user);

        if (category.getCategories().isEmpty())
            category.setCategories(categories);
        else
            categories.forEach(cat -> {
                if (!category.getCategories().contains(cat))
                    category.getCategories().add(cat);
            });

        return category;
    }

    private boolean isUserPresent(Long userId) {
        return this.userRepository.findById(userId).isPresent();
    }

    private User getUser(Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new DatabaseException("user not found", 404));
    }
}
