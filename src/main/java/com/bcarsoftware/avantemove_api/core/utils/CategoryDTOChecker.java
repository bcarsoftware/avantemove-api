package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.List;

public class CategoryDTOChecker {
    public static void categoryDTOChecker(CategoryDTO categoryDTO) {
        String regex = "^[A-Z][A-Za-z ]{1,30}[A-Za-z]$";
        String followingSpaces = " {2,}";

        if (categoryDTO.categories().isEmpty())
            throw new BodyException("categories list can't be empty");

        categoryDTO.categories().forEach(category -> {
            List<Boolean> failed = List.of(category.matches(followingSpaces), !category.matches(regex));

            if (failed.contains(true))
                throw new BodyException("categories list is invalid");
        });
    }
}
