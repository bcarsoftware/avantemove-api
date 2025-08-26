package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.TaskDTO;

import java.time.LocalDate;

public class TaskDTOMock {
    public static TaskDTO success() {
        return new TaskDTO(
            1L,
            "task name",
            "This is a comment",
            15,
            LocalDate.of(2025, 5, 22),
            false
        );
    }

    public static TaskDTO failedTaskTwoSpaces() {
        return new TaskDTO(
            1L,
            "task name",
            "This  is a comment",
            15,
            LocalDate.of(2025, 5, 22),
            false
        );
    }

    public static TaskDTO failedTaskChars() {
        return new TaskDTO(
            1L,
            "task name",
            "This# is a comment",
            15,
            LocalDate.of(2025, 5, 22),
            false
        );
    }

    public static TaskDTO failedTaskMinLength() {
        return new TaskDTO(
            1L,
            "task name",
            "Th",
            15,
            LocalDate.of(2025, 5, 22),
            false
        );
    }

    public static TaskDTO failedTaskMaxLength() {
        return new TaskDTO(
            1L,
            "task name",
            "Th".repeat(257),
            15,
            LocalDate.of(2025, 5, 22),
            false
        );
    }

    public static TaskDTO failedTaskXpValue() {
        return new TaskDTO(
                1L,
                "task name",
                "This is a comment",
                -15,
                LocalDate.of(2025, 5, 22),
                false
        );
    }
}
