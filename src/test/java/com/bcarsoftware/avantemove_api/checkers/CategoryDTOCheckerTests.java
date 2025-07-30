package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.CategoryDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.CategoryDTOMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(CategoryDTOChecker.class)
public class CategoryDTOCheckerTests {
    @Test
    @DisplayName("success category dto")
    void successCategoryDTO() {
        assertDoesNotThrow(() -> CategoryDTOChecker.categoryDTOChecker(CategoryDTOMock.success()));
    }

    @Test
    @DisplayName("failed category empty category dto")
    void failedCategoryEmptyCategoryDTO() {
        assertThrows(BodyException.class,
            () -> CategoryDTOChecker.categoryDTOChecker(CategoryDTOMock.failedCategoryEmpty())
        );
    }

    @Test
    @DisplayName("failed category two spaces category dto")
    void failedCategoryTwoSpacesCategoryDTO() {
        assertThrows(BodyException.class,
            () -> CategoryDTOChecker.categoryDTOChecker(CategoryDTOMock.failedCategoryTwoSpaces())
        );
    }

    @Test
    @DisplayName("failed category max length category dto")
    void failedCategoryMaxLengthCategoryDTO() {
        assertThrows(BodyException.class,
            () -> CategoryDTOChecker.categoryDTOChecker(CategoryDTOMock.failedCategoryMaxLength())
        );
    }

    @Test
    @DisplayName("failed category min length category dto")
    void failedCategoryMinLengthCategoryDTO() {
        assertThrows(BodyException.class,
            () -> CategoryDTOChecker.categoryDTOChecker(CategoryDTOMock.failedCategoryMinLength())
        );
    }
}
