package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.SealExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SealExpRepository extends JpaRepository<SealExp, Long> {
    @Query("select exp from SealExp as exp where exp.startXp<=:experience and exp.finishXp>=:experience")
    SealExp findSealExpByUserExperience(@Param("experience") int experience);

    SealExp findFirstById(Long id);

    @Query("select s from SealExp as s where s.finishXp = (select max(u.finishXp) from SealExp as u)")
    SealExp findMaxFinishXpSealExp();
}
