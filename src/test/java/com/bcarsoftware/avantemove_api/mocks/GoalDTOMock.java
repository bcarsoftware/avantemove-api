package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;

import java.time.LocalDate;

public class GoalDTOMock {
    public static GoalDTO success() {
        return new GoalDTO(
            1L,
            "Be Strong",
            "Make Gym",
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalName() {
        return new GoalDTO(
            1L,
            "Be Strong$",
            "Make Gym",
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalNameMinLength() {
        return new GoalDTO(
            1L,
            "Be",
            "Make Gym",
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalNameMaxLength() {
        return new GoalDTO(
            1L,
            "Be".repeat(33),
            "Make Gym",
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalDescription() {
        return new GoalDTO(
            1L,
            "Be Strong",
            "Make #Gym",
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalDescriptionMinLength() {
        return new GoalDTO(
            1L,
            "Be Strong",
            "Mk",
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalDescriptionMaxLength() {
        return new GoalDTO(
            1L,
            "Be Strong",
            "Mk".repeat(257),
            LocalDate.of(2025, 5, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }

    public static GoalDTO failedGoalDateComparing() {
        return new GoalDTO(
            1L,
            "Be Strong",
            "Make Gym",
            LocalDate.of(2025, 12, 22),
            LocalDate.of(2025, 11, 17),
            true
        );
    }
}
