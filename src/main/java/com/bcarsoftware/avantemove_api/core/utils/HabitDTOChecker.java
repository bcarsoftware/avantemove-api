package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.HabitDTO;
import com.bcarsoftware.avantemove_api.enums.EnumWeek;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HabitDTOChecker {
    public static void habitDTOChecker(HabitDTO habitDTO) {
        var weekDays = List.of(EnumWeek.values());

        habitDTO.daysWeek().forEach(day -> {
            if (!weekDays.contains(day))
                throw new BodyException("invalid value for week day");
        });

        var regex = regexes();

        var nameChecker = List.of(
            habitDTO.name().matches(regex.get("name")),
            !habitDTO.name().matches(regex.get("followingSpaces"))
        );

        var categoryChecker = List.of(
            habitDTO.category().matches(regex.get("category")),
            !habitDTO.category().matches(regex.get("followingSpaces"))
        );

        if (nameChecker.contains(false))
            throw new BodyException("habit name characters not match");

        if (categoryChecker.contains(false))
            throw new BodyException("habit category characters not match");
    }

    private static Map<String, String> regexes() {
        var regex = new HashMap<String, String>();

        regex.put("name", "^[A-Z][a-zA-Z- .]{1,62}[a-zA-Z.]$");
        regex.put("category", "^[A-Z][A-Za-z ]{1,30}[A-Za-z]$");
        regex.put("followingSpaces", " {2,}");

        return regex;
    }
}
