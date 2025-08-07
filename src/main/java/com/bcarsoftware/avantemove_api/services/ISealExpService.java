package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import com.bcarsoftware.avantemove_api.models.SealExp;

import java.util.List;

public interface ISealExpService {
    public abstract SealExp save(SealExpDTO sealExpDTO);
    public abstract List<SealExp> getAllSealExp();
    public abstract SealExp update(Long id, SealExpDTO sealExpDTO);
    public abstract SealExp getSealExpByUserExperience(int experience);
    public abstract SealExp delete(Long id);
}
