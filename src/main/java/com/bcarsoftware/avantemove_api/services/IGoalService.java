package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import com.bcarsoftware.avantemove_api.models.Goal;

import java.util.List;

public interface IGoalService {
    public abstract Goal save(GoalDTO goalDTO);
    public abstract List<Goal> getByUserId(Long userId);
    public abstract Goal update(Long id, GoalDTO goalDTO);
    public abstract Goal delete(Long id);
}
