package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.TaskDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.TaskDTOMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@WebMvcTest(TaskDTOChecker.class)
public class TaskDTOCheckerTests {
    @Test
    @DisplayName("success task dto")
    void successTaskDTO() {
        assertDoesNotThrow(() -> TaskDTOChecker.taskDTOChecker(TaskDTOMock.success()));
    }

    @Test
    @DisplayName("failed task two spaces")
    void failedTaskTwoSpaces() {
        assertThrows(BodyException.class,
            () ->TaskDTOChecker.taskDTOChecker(TaskDTOMock.failedTaskTwoSpaces())
        );
    }

    @Test
    @DisplayName("failed task characters")
    void failedTaskChars() {
        assertThrows(BodyException.class,
            () ->TaskDTOChecker.taskDTOChecker(TaskDTOMock.failedTaskChars())
        );
    }

    @Test
    @DisplayName("failed task min length")
    void failedTaskMinLength() {
        assertThrows(BodyException.class,
            () ->TaskDTOChecker.taskDTOChecker(TaskDTOMock.failedTaskMinLength())
        );
    }

    @Test
    @DisplayName("failed task max length")
    void failedTaskMaxLength() {
        assertThrows(BodyException.class,
            () ->TaskDTOChecker.taskDTOChecker(TaskDTOMock.failedTaskMaxLength())
        );
    }
}
