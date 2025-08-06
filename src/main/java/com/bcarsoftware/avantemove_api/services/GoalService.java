package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.GoalDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.Goal;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.GoalRepository;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService implements IGoalService {
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Goal save(GoalDTO goalDTO) {
        try {
            Goal goal = this.transferGoalDtoTOGoal(goalDTO);

            return this.goalRepository.save(goal);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public List<Goal> getByUserId(Long userId) {
        List<Goal> goals = this.goalRepository.findGoalByUserId(userId);

        if (goals.isEmpty())
            throw new DatabaseException("goals not found for this user id", 404);

        return goals;
    }

    @Override
    public Goal update(Long id, GoalDTO goalDTO) {
        Goal goal = this.goalRepository.findFirstById(id);

        if (goal == null)
            throw new DatabaseException("goal not found", 404);

        goal = this.transferGoalDtoTOGoal(goalDTO, goal);

        try {
            return this.goalRepository.save(goal);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public Goal delete(Long id) {
        Goal goal = this.goalRepository.findFirstById(id);

        if (goal == null)
            throw new DatabaseException("goal not found", 404);

        goal.setActive(false);

        try {
            return this.goalRepository.save(goal);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    protected User getUserById(Long id) {
        User user = this.userRepository.findFirstById(id);

        if (user == null)
            throw new DatabaseException("user not found", 404);

        return user;
    }

    protected Goal transferGoalDtoTOGoal(GoalDTO goalDTO) {
        var goal = new Goal();

        return getGoal(goalDTO, goal);
    }

    protected Goal transferGoalDtoTOGoal(GoalDTO goalDTO, Goal goal) {
        return getGoal(goalDTO, goal);
    }

    private Goal getGoal(GoalDTO goalDTO, Goal goal) {
        GoalDTOChecker.goalDTOChecker(goalDTO);

        User user = this.getUserById(goalDTO.userId());

        goal.setUser(user);
        goal.setName(goalDTO.name());
        goal.setDescription(goalDTO.description());
        goal.setStartDate(goalDTO.startDate());
        goal.setFinishDate(goalDTO.finishDate());
        goal.setActive(goalDTO.active());

        return goal;
    }
}
