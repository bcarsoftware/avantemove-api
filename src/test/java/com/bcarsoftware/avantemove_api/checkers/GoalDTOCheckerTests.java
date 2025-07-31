package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.GoalDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.GoalDTOMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(GoalDTOChecker.class)
public class GoalDTOCheckerTests {
    @Test
    @DisplayName("success goal checker")
    void successGoalChecker() {
        assertDoesNotThrow(() -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.success()));
    }

    @Test
    @DisplayName("failed goal name")
    void failedGoalName() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalName())
        );
    }

    @Test
    @DisplayName("failed goal name min length")
    void failedGoalNameMinLength() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalNameMinLength())
        );
    }

    @Test
    @DisplayName("failed goal name max length")
    void failedGoalNameMaxLength() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalNameMaxLength())
        );
    }

    @Test
    @DisplayName("failed goal description")
    void failedGoalDescription() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalDescription())
        );
    }

    @Test
    @DisplayName("failed goal description min length")
    void failedGoalDescriptionMinLength() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalDescriptionMinLength())
        );
    }

    @Test
    @DisplayName("failed goal description max length")
    void failedGoalDescriptionMaxLength() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalName())
        );
    }

    @Test
    @DisplayName("failed goal date comparing")
    void failedGoalDateComparing() {
        assertThrows(BodyException.class,
            () -> GoalDTOChecker.goalDTOChecker(GoalDTOMock.failedGoalDateComparing())
        );
    }
}
