package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.BeliefDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.BeliefDTOMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(BeliefDTOChecker.class)
public class BeliefDTOCheckerTests {
    @Test
    @DisplayName("success belief")
    void successBelief() {
        assertDoesNotThrow(() -> BeliefDTOChecker.beliefDTOChecker(BeliefDTOMock.success()));
    }

    @Test
    @DisplayName("failed description empty belief")
    void failedDescriptionEmptyBelief() {
        assertThrows(BodyException.class,
            () -> BeliefDTOChecker.beliefDTOChecker(BeliefDTOMock.failedDescriptionEmpty())
        );
    }

    @Test
    @DisplayName("failed description chars belief")
    void failedDescriptionCharsBelief() {
        assertThrows(BodyException.class,
            () -> BeliefDTOChecker.beliefDTOChecker(BeliefDTOMock.failedDescriptionChars())
        );
    }

    @Test
    @DisplayName("failed description max length belief")
    void failedDescriptionMaxLengthBelief() {
        assertThrows(BodyException.class,
            () -> BeliefDTOChecker.beliefDTOChecker(BeliefDTOMock.failedDescriptionMaxLength())
        );
    }

    @Test
    @DisplayName("failed description min length belief")
    void failedDescriptionMinLengthBelief() {
        assertThrows(BodyException.class,
            () -> BeliefDTOChecker.beliefDTOChecker(BeliefDTOMock.failedDescriptionMinLength())
        );
    }
}
