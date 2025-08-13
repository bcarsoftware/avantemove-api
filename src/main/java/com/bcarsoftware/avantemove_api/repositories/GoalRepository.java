package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    @Query("select g from Goal as g where g.active=true and g.user.id=:userId")
    List<Goal> findGoalByUserId(@Param("userId") Long userId);

    Goal findFirstById(Long id);
}
