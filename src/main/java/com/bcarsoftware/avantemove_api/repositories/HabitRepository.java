package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    public abstract List<Habit> findHabitByUserId(Long id);
    public abstract List<Habit> findHabitByGoalId(Long id);

    public abstract Habit findFirstById(Long id);
}
