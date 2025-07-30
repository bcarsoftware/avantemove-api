package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import com.bcarsoftware.avantemove_api.enums.EnumWeek;

import java.util.List;
import java.util.Optional;

public class HabitDTOMock {
    public static HabitDTO success() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Running at Monday",
            "Running",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitName() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Running at Monday#",
            "Running",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitNameMinLength() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Ri",
            "Running",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitNameMaxLength() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Ri".repeat(33),
            "Running",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitCategoryMinLength() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Running at Street",
            "Rg",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitCategoryMaxLength() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Running at Street",
            "Rg".repeat(17),
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitCategorySpaces() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Running at Street",
            "Running  Morning",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }

    public static HabitDTO failedHabitNameSpaces() {
        return new HabitDTO(
            1L,
            Optional.of(1L),
            "Running at  Street",
            "Running",
            List.of(EnumWeek.MONDAY, EnumWeek.TUESDAY, EnumWeek.WEDNESDAY),
            true
        );
    }
}
