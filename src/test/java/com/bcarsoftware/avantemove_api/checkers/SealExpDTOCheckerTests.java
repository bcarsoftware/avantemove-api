package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.SealExpDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.SealExpDTOMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(SealExpDTOChecker.class)
public class SealExpDTOCheckerTests {
    @Test
    @DisplayName("success seal exp")
    void successSealExp() {
        assertDoesNotThrow(() -> SealExpDTOChecker.sealExpDTOChecker(SealExpDTOMock.success()));
    }

    @Test
    @DisplayName("failed seal exp name")
    void failedSealExpName() {
        assertThrows(BodyException.class,
            () -> SealExpDTOChecker.sealExpDTOChecker(SealExpDTOMock.failedSealExpName())
        );
    }

    @Test
    @DisplayName("failed seal exp max length")
    void failedSealExpMaxLength() {
        assertThrows(BodyException.class,
            () -> SealExpDTOChecker.sealExpDTOChecker(SealExpDTOMock.failedSealExpMaxLength())
        );
    }

    @Test
    @DisplayName("failed seal exp min length")
    void failedSealExpMinLength() {
        assertThrows(BodyException.class,
            () -> SealExpDTOChecker.sealExpDTOChecker(SealExpDTOMock.failedSealExpMinLength())
        );
    }

    @Test
    @DisplayName("failed seal exp start xp")
    void failedSealExpStartXP() {
        assertThrows(BodyException.class,
            () -> SealExpDTOChecker.sealExpDTOChecker(SealExpDTOMock.failedSealExpStartXP())
        );
    }

    @Test
    @DisplayName("failed seal exp xps")
    void failedSealExpXPS() {
        assertThrows(BodyException.class,
            () -> SealExpDTOChecker.sealExpDTOChecker(SealExpDTOMock.failedSealExpXPS())
        );
    }
}
