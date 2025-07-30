package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.HabitDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.HabitDTOMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@WebMvcTest(HabitDTOChecker.class)
public class HabitDTOCheckerTests {
    @Test
    @DisplayName("success habit checker")
    void successHabitChecker() {
        assertDoesNotThrow(() -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.success()));
    }

    @Test
    @DisplayName("failed habit name")
    void failedHabitName() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitName())
        );
    }

    @Test
    @DisplayName("failed habit name min length")
    void failedHabitNameMinLength() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitNameMinLength())
        );
    }

    @Test
    @DisplayName("failed habit name max length")
    void failedHabitNameMaxLength() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitNameMaxLength())
        );
    }

    @Test
    @DisplayName("failed habit category min length")
    void failedHabitCategoryMinLength() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitCategoryMinLength())
        );
    }

    @Test
    @DisplayName("failed habit category max length")
    void failedHabitCategoryMaxLength() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitCategoryMaxLength())
        );
    }

    @Test
    @DisplayName("failed habit category spaces")
    void failedHabitCategorySpaces() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitCategorySpaces())
        );
    }

    @Test
    @DisplayName("failed habit name spaces")
    void failedHabitNameSpaces() {
        assertThrows(BodyException.class,
            () -> HabitDTOChecker.habitDTOChecker(HabitDTOMock.failedHabitNameSpaces())
        );
    }
}
