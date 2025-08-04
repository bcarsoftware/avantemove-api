package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Belief;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeliefRepository extends JpaRepository<Belief, Long> {
    public abstract List<Belief> findBeliefByUserId(Long userId);
}
