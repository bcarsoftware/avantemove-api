package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.HabitDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.Goal;
import com.bcarsoftware.avantemove_api.models.Habit;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.GoalRepository;
import com.bcarsoftware.avantemove_api.repositories.HabitRepository;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService implements IHabitService{
    private final HabitRepository habitRepository;
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;

    @Autowired
    public HabitService(
        HabitRepository habitRepository,
        UserRepository userRepository,
        GoalRepository goalRepository
    ) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
    }

    @Override
    public Habit save(HabitDTO habitDTO) {
        Habit habit = this.transferHabitDtoToHabit(habitDTO);

        return this.habitRepository.save(habit);
    }

    @Override
    public List<Habit> getHabitByUserId(Long userId) {
        List<Habit> habits = this.habitRepository.findHabitByUserId(userId);

        if (habits.isEmpty())
            throw new DatabaseException("habits not found", 404);

        return habits;
    }

    @Override
    public List<Habit> getHabitByGoalId(Long goalId) {
        List<Habit> habits = this.habitRepository.findHabitByGoalId(goalId);

        if (habits.isEmpty())
            throw new DatabaseException("habits not found", 404);

        return habits;
    }

    @Override
    public Habit update(Long id, HabitDTO habitDTO) {
        Habit habit = this.habitRepository.findFirstById(id);

        if (habit == null)
            throw new DatabaseException("habit not found", 404);

        habit = this.transferHabitDtoToHabit(habitDTO, habit);

        return this.habitRepository.save(habit);
    }

    @Override
    public Habit delete(Long id) {
        Habit habit = this.habitRepository.findFirstById(id);

        if (habit == null)
            throw new DatabaseException("habit not found", 404);

        habit.setActive(false);

        return this.habitRepository.save(habit);
    }

    protected Habit transferHabitDtoToHabit(HabitDTO habitDTO) {
        Habit habit = new Habit();

        return getHabit(habitDTO, habit);
    }

    protected Habit transferHabitDtoToHabit(HabitDTO habitDTO, Habit habit) {
        return getHabit(habitDTO, habit);
    }

    private Habit getHabit(HabitDTO habitDTO, Habit habit) {
        HabitDTOChecker.habitDTOChecker(habitDTO);

        var user = this.getUserById(habitDTO.userId());
        Goal goal = null;

        habit.setUser(user);

        if (habitDTO.goalId().isPresent())
            goal = this.getGoalById(habitDTO.goalId().get());

        habit.setGoal(goal);
        habit.setName(habitDTO.name());
        habit.setCategory(habitDTO.category());
        habit.setDaysWeek(habitDTO.daysWeek());
        habit.setActive(habitDTO.active());

        return habit;
    }

    private Goal getGoalById(Long goalId) {
        Goal goal = goalRepository.findFirstById(goalId);

        if (goal == null)
            throw new DatabaseException("goal not found", 404);

        return goal;
    }

    private User getUserById(Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new DatabaseException("user not found", 404));
    }
}
