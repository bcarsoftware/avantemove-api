package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import com.bcarsoftware.avantemove_api.models.Goal;

import java.util.List;

public interface IGoalService {
    Goal save(GoalDTO goalDTO);
    List<Goal> getByUserId(Long userId);
    Goal update(Long id, GoalDTO goalDTO);
    Goal delete(Long id);
}
