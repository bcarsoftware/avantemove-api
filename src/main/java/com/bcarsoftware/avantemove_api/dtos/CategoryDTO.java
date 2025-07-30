package com.bcarsoftware.avantemove_api.dtos;

import java.util.List;

public record CategoryDTO(
        Long userId,
        List<String> categories
) { }
