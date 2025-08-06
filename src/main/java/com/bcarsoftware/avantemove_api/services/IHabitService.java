package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import com.bcarsoftware.avantemove_api.models.Habit;

import java.util.List;

public interface IHabitService {
    public abstract Habit save(HabitDTO habitDTO);
    public abstract List<Habit> getHabitByUserId(Long userId);
    public abstract List<Habit> getHabitByGoalId(Long goalId);
    public abstract Habit update(Long id, HabitDTO habitDTO);
    public abstract Habit delete(Long id);
}
