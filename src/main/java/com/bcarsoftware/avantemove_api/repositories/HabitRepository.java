package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    public abstract List<Habit> findHabitByUserId(Long id);
    public abstract List<Habit> findHabitByGoalId(Long id);
}
