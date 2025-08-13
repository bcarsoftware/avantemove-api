package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import com.bcarsoftware.avantemove_api.models.Habit;

import java.util.List;

public interface IHabitService {
    Habit save(HabitDTO habitDTO);
    List<Habit> getHabitByUserId(Long userId);
    List<Habit> getHabitByGoalId(Long goalId);
    Habit update(Long id, HabitDTO habitDTO);
    Habit delete(Long id);
}
