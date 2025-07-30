package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.core.utils.TaskDTOChecker;

public record TaskDTO(
        Long habitId,
        String comment,
        boolean finished
) {
    public TaskDTO {
        TaskDTOChecker.taskDTOChecker(this);
    }
}
