package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.TaskDTO;

public class TaskDTOMock {
    public static TaskDTO success() {
        return new TaskDTO(
            1L,
            "This is a comment",
            15L,
            false
        );
    }

    public static TaskDTO failedTaskTwoSpaces() {
        return new TaskDTO(
            1L,
            "This  is a comment",
            15L,
            false
        );
    }

    public static TaskDTO failedTaskChars() {
        return new TaskDTO(
            1L,
            "This# is a comment",
            15L,
            false
        );
    }

    public static TaskDTO failedTaskMinLength() {
        return new TaskDTO(
            1L,
            "Th",
            15L,
            false
        );
    }

    public static TaskDTO failedTaskMaxLength() {
        return new TaskDTO(
            1L,
            "Th".repeat(257),
            15L,
            false
        );
    }

    public static TaskDTO failedTaskXpValue() {
        return new TaskDTO(
                1L,
                "This is a comment",
                -15L,
                false
        );
    }
}
