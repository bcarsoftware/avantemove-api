package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.DateIntervalDTO;
import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import com.bcarsoftware.avantemove_api.models.Task;

import java.util.List;

public interface ITaskService {
    Task save(TaskDTO taskDTO);
    List<Task> getTaskByHabit(Long habitId, DateIntervalDTO dateIntervalDTO);
    List<Task> getTaskHabitDetached(DateIntervalDTO dateIntervalDTO);
    Task update(Long id, TaskDTO taskDTO);
    Task finish(Long id);
    Task delete(Long id);
}
