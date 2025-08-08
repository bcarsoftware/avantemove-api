package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task as t where t.date>=:startDate and t.date<=:end and t.habit.id=:habitId")
    public abstract List<Task> findTaskByHabitId(
        @Param("habitId") Long habitId,
        @Param("start") LocalDate start,
        @Param("end") LocalDate end
    );

    @Query("select t from Task as t where t.date>=:startDate and t.date<=:end")
    public abstract List<Task> findTaskDetached(@Param("start") LocalDate start, @Param("end") LocalDate end);

    public abstract Task findFirstById(Long id);
}
