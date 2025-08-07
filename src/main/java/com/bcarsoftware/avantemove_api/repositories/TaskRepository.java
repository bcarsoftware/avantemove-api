package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("update Task as tk set tk.finished=true where tk.id=:id")
    public abstract Task finishTaskById(@Param("id") Long id);
    public abstract List<Task> findTaskByHabitId(Long habitId);

    public abstract Task findFirstById(Long id);
}
