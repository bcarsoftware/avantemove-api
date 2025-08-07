package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Belief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeliefRepository extends JpaRepository<Belief, Long> {
    public abstract List<Belief> findBeliefByUserId(Long userId);

    public abstract Belief findFirstById(Long id);
}
