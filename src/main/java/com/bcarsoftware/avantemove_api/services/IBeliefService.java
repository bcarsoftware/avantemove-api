package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import com.bcarsoftware.avantemove_api.models.Belief;

import java.util.List;

public interface IBeliefService {
    Belief save(BeliefDTO beliefDTO);
    List<Belief> getBeliefByUserId(Long userId);
    Belief update(Long id, BeliefDTO beliefDTO);
    Belief delete(Long id);
}
