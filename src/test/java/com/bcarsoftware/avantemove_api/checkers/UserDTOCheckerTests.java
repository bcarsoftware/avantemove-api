package com.bcarsoftware.avantemove_api.checkers;

import com.bcarsoftware.avantemove_api.core.utils.UserDTOChecker;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;
import com.bcarsoftware.avantemove_api.mocks.UserDTOMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(UserDTOChecker.class)
public class UserDTOCheckerTests {
    @Test
    @DisplayName("success user dto")
    void userDTOSuccessCase() {
        assertDoesNotThrow(() -> UserDTOChecker.userDTOChecker(UserDTOMock.success()));
    }

    @Test
    @DisplayName("failed first name")
    void userDTOFailCaseOne() {
        assertThrows(BodyException.class,
            () -> UserDTOChecker.userDTOChecker(UserDTOMock.failedFirstName())
        );
    }

    @Test
    @DisplayName("failed last name")
    void userDTOFailCaseTwo() {
        assertThrows(BodyException.class,
            () -> UserDTOChecker.userDTOChecker(UserDTOMock.failedLastName())
        );
    }

    @Test
    @DisplayName("failed email")
    void userDTOFailCaseThree() {
        assertThrows(BodyException.class,
            () -> UserDTOChecker.userDTOChecker(UserDTOMock.failedEmail())
        );
    }

    @Test
    @DisplayName("failed username")
    void userDTOFailCaseFour() {
        assertThrows(BodyException.class,
            () -> UserDTOChecker.userDTOChecker(UserDTOMock.failedUsername())
        );
    }

    @Test
    @DisplayName("failed password")
    void userDTOFailCaseFive() {
        assertThrows(BodyException.class,
                () -> UserDTOChecker.userDTOChecker(UserDTOMock.failedPassword())
        );
    }

    @Test
    @DisplayName("failed mobile number if present")
    void userDTOFailCaseSix() {
        assertThrows(BodyException.class,
            () -> UserDTOChecker.userDTOChecker(UserDTOMock.failedMobileNumber())
        );
    }
}
