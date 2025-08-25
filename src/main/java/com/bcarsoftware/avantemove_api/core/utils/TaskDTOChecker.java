package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.List;

public class TaskDTOChecker {
    public static void taskDTOChecker(TaskDTO taskDTO) {
        if (taskDTO.xpValue() < 0)
            throw new BodyException("task xp value cannot be negative");

        var failed = List.of(
            !taskDTO.name().matches("^[a-zA-Z_0-9][a-zA-Z-_ ,.0-9]{1,252}[a-zA-Z.0-9]$"),
            !taskDTO.comment().matches("^[a-zA-Z_0-9][a-zA-Z-_ ,.0-9]{1,510}[a-zA-Z.0-9]$"),
            taskDTO.comment().contains("  ") || taskDTO.name().contains("  ")
        );

        if (failed.contains(true))
            throw new BodyException("task comment characters not match");
    }
}
