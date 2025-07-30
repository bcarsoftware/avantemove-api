package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTOMock {
    public static CategoryDTO success() {
        return new CategoryDTO(
            1L,
                List.of("Food", "Running", "Walking", "Reading", "Wake Up")
        );
    }

    public static CategoryDTO failedCategoryEmpty() {
        return new CategoryDTO(
            1L,
            new ArrayList<String>()
        );
    }

    public static CategoryDTO failedCategoryTwoSpaces() {
        return new CategoryDTO(
            1L,
            List.of("Food", "Running", "Walking", "Reading", "Wake  Up")
        );
    }

    public static CategoryDTO failedCategoryMaxLength() {
        return new CategoryDTO(
                1L,
                List.of("Food".repeat(9))
        );
    }

    public static CategoryDTO failedCategoryMinLength() {
        return new CategoryDTO(
            1L,
            List.of("To")
        );
    }
}
