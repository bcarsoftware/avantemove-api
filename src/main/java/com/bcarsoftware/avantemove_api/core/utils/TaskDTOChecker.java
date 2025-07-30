package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.List;

public class TaskDTOChecker {
    public static void taskDTOChecker(TaskDTO taskDTO) {
        var failed = List.of(
            !taskDTO.comment().matches("^[a-zA-Z_0-9][a-zA-Z-_ ,.0-9]{1,510}[a-zA-Z.0-9]$"),
            taskDTO.comment().contains("  ")
        );

        if (failed.contains(true))
            throw new BodyException("task comment characters not match");
    }
}
