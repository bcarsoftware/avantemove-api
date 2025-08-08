package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.TaskDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.DateIntervalDTO;
import com.bcarsoftware.avantemove_api.dtos.TaskDTO;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.Habit;
import com.bcarsoftware.avantemove_api.models.Task;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.HabitRepository;
import com.bcarsoftware.avantemove_api.repositories.TaskRepository;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private UserRepository userRepository;

    private final int EXPERIENCE = 15;

    @Override
    public Task save(TaskDTO taskDTO) {
        Task task = this.transferTaskDtoToTask(taskDTO);

        try {
            return this.taskRepository.save(task);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public List<Task> getTaskByHabit(Long habitId, DateIntervalDTO dateIntervalDTO) {
        return List.of();
    }

    @Override
    public List<Task> getTaskHabitDetached(DateIntervalDTO dateIntervalDTO) {
        return List.of();
    }

    @Override
    public Task update(Long id, TaskDTO taskDTO) {
        Task task = this.taskRepository.findFirstById(id);

        if (task == null)
            throw new DatabaseException("task not found", 404);

        Task taskData = this.transferTaskDtoToTask(taskDTO, task);

        try {
            return this.taskRepository.save(taskData);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public Task finish(Long id) {
        Task task = this.taskRepository.findFirstById(id);

        if (task == null)
            throw new DatabaseException("task not found", 404);

        task.setFinished(!task.isFinished());

        int experience = task.isFinished() ? this.EXPERIENCE : -this.EXPERIENCE;

        User user = task.getHabit().getUser();

        user.setExperience(user.getExperience() + experience);

        try {
            this.userRepository.save(user);
            return this.taskRepository.save(task);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public Task delete(Long id) {
        Task task = this.taskRepository.findFirstById(id);

        if (task == null)
            throw new DatabaseException("task not found", 404);

        User user = task.getHabit().getUser();

        user.setExperience(user.getExperience() - this.EXPERIENCE);

        try {
            this.userRepository.save(user);
            this.taskRepository.delete(task);

            return task;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    protected Task transferTaskDtoToTask(TaskDTO taskDTO) {
        var task = new Task();
        return getTask(taskDTO, task);
    }

    protected Task transferTaskDtoToTask(TaskDTO taskDTO, Task task) {
        return getTask(taskDTO, task);
    }

    private Task getTask(TaskDTO taskDTO, Task task) {
        TaskDTOChecker.taskDTOChecker(taskDTO);

        var habit = taskDTO.habitId() == 0 ? null : this.getHabit(taskDTO.habitId());

        task.setHabit(habit);
        task.setComment(taskDTO.comment());
        task.setXpValue(taskDTO.xpValue());
        task.setFinished(taskDTO.finished());

        return task;
    }

    private Habit getHabit(Long habitId) {
        Habit habit = this.habitRepository.findFirstById(habitId);

        if (habit == null)
            throw new DatabaseException("habit not found", 404);

        return habit;
    }
}
