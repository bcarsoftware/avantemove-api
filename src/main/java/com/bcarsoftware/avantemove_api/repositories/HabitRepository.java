package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    @Query("select h from Habit as h where h.active=true and h.user.id=:id")
    List<Habit> findHabitByUserId(@Param("id") Long id);

    @Query("select h from Habit as h where h.active=true and h.goal.id=:id")
    List<Habit> findHabitByGoalId(@Param("id") Long id);

    @Query("select h from Habit as h where h.active=true and h.id=:id")
    Habit findFirstById(@Param("id") Long id);
}
