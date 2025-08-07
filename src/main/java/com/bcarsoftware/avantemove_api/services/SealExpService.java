package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.SealExpDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.SealExpDTO;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.SealExp;
import com.bcarsoftware.avantemove_api.repositories.SealExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SealExpService implements ISealExpService {
    @Autowired
    private SealExpRepository sealExpRepository;

    @Override
    public SealExp save(SealExpDTO sealExpDTO) {
        SealExp sealExp = transferSealExpDtoToSealExp(sealExpDTO);

        SealExp maxSealExp = this.getMaxSealExp();

        sealExp.setStartXp(
            maxSealExp == null ?
            0: maxSealExp.getFinishXp() + 1
        );

        sealExp.setFinishXp(
            sealExp.getStartXp() + sealExpDTO.interval()
        );

        try {
            return this.sealExpRepository.save(sealExp);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public List<SealExp> getAllSealExp() {
        return this.sealExpRepository.findAll();
    }

    @Override
    public SealExp update(Long id, SealExpDTO sealExpDTO) {
        List<SealExp> sealExps = this.sealExpRepository.findAll();

        SealExp sealExp = sealExps.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        if (sealExp == null)
            throw new DatabaseException("seal exp not found", 404);

        sealExp = this.transferSealExpDtoToSealExp(sealExpDTO, sealExp);
        sealExp.setFinishXp(
            sealExp.getStartXp() + sealExpDTO.interval()
        );

        SealExp finalSealExp = sealExp;
        List<SealExp> editSealExps = sealExps.stream().filter(seal -> seal.getId() >= finalSealExp.getId()).toList();

        if (editSealExps.size() > 1) {
            AtomicInteger startXp = new AtomicInteger(finalSealExp.getFinishXp() + 1);

            editSealExps = editSealExps.stream().skip(1).peek(seal -> {
                int interval = seal.getFinishXp() - seal.getStartXp();

                seal.setStartXp(startXp.get());
                seal.setFinishXp(startXp.get() + interval);

                startXp.set(seal.getFinishXp() + 1);
            }).toList();
        }

        try {
            this.sealExpRepository.saveAll(editSealExps);

            return finalSealExp;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public SealExp getSealExpByUserExperience(int experience) {
        SealExp sealExp = this.sealExpRepository.findSealExpByUserExperience(experience);

        if (sealExp == null)
            throw new DatabaseException("seal exp not found", 404);

        return sealExp;
    }

    @Override
    public SealExp delete(Long id) {
        List<SealExp> sealExps = this.sealExpRepository.findAll();

        SealExp sealExp = sealExps.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        if (sealExp == null)
            throw new DatabaseException("seal exp not found", 404);

        List<SealExp> editSealExps = sealExps.stream().filter(seal -> seal.getId() > sealExp.getId()).toList();

        if (!editSealExps.isEmpty()) {
            AtomicInteger startXp = new AtomicInteger(sealExp.getStartXp());

            editSealExps = editSealExps.stream().peek(seal -> {
                int interval = seal.getFinishXp() - seal.getStartXp();

                seal.setStartXp(startXp.get());
                seal.setFinishXp(startXp.get() + interval);

                startXp.set(seal.getFinishXp() + 1);
            }).toList();
        }

        try {
            this.sealExpRepository.delete(sealExp);
            this.sealExpRepository.saveAll(editSealExps);

            return sealExp;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    protected SealExp transferSealExpDtoToSealExp(SealExpDTO sealExpDTO) {
        SealExp sealExp = new SealExp();

        return this.getSealExp(sealExpDTO, sealExp);
    }

    protected SealExp transferSealExpDtoToSealExp(SealExpDTO sealExpDTO, SealExp sealExp) {
        return this.getSealExp(sealExpDTO, sealExp);
    }

    private SealExp getSealExp(SealExpDTO sealExpDTO, SealExp sealExp) {
        SealExpDTOChecker.sealExpDTOChecker(sealExpDTO);

        sealExp.setName(sealExpDTO.name());

        return sealExp;
    }

    private SealExp getMaxSealExp() {
        return this.sealExpRepository.findMaxFinishXpSealExp();
    }
}
