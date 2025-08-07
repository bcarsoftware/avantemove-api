package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import com.bcarsoftware.avantemove_api.models.Task;

import java.util.List;

public interface ITaskService {
    public abstract Task save(TaskDTO taskDTO);
    public abstract List<Task> getTaskByHabit(Long habitId);
    public abstract Task update(Long id, TaskDTO taskDTO);
    public abstract Task finish(Long id);
    public abstract Task delete(Long id);
}
