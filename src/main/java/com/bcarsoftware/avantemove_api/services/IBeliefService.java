package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import com.bcarsoftware.avantemove_api.models.Belief;

import java.util.List;

public interface IBeliefService {
    public abstract Belief save(BeliefDTO beliefDTO);
    public abstract List<Belief> getBeliefByUserId(Long userId);
    public abstract Belief update(Long id, BeliefDTO beliefDTO);
    public abstract Belief delete(Long id);
}
