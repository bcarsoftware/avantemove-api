package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import com.bcarsoftware.avantemove_api.models.SealExp;

import java.util.List;

public interface ISealExpService {
    SealExp save(SealExpDTO sealExpDTO);
    List<SealExp> getAllSealExp();
    SealExp update(Long id, SealExpDTO sealExpDTO);
    SealExp getSealExpByUserExperience(int experience);
    SealExp delete(Long id);
}
