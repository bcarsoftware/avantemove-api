package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.utils.BeliefDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.BeliefDTO;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.Belief;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.BeliefRepository;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeliefService implements IBeliefService {
    private final BeliefRepository beliefRepository;
    private final UserRepository userRepository;

    @Autowired
    public BeliefService(BeliefRepository beliefRepository, UserRepository userRepository) {
        this.beliefRepository = beliefRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Belief save(BeliefDTO beliefDTO) {
        Belief belief = this.transferBeliefDtoToBelief(beliefDTO);

        return this.beliefRepository.save(belief);
    }

    @Override
    public List<Belief> getBeliefByUserId(Long userId) {
        List<Belief> beliefs = this.beliefRepository.findBeliefByUserId(userId);

        if (beliefs.isEmpty())
            throw new DatabaseException("beliefs not found", 404);

        return beliefs;
    }

    @Override
    public Belief update(Long id, BeliefDTO beliefDTO) {
        Belief belief = this.beliefRepository.findFirstById(id);

        if (belief == null)
            throw new DatabaseException("belief not found", 404);

        Belief beliefData = this.transferBeliefDtoToBelief(beliefDTO, belief);

        return this.beliefRepository.save(beliefData);
    }

    @Override
    public Belief delete(Long id) {
        Belief belief = beliefRepository.findFirstById(id);

        if (belief == null)
            throw new DatabaseException("belief not found", 404);

        this.beliefRepository.delete(belief);

        return belief;
    }

    protected Belief transferBeliefDtoToBelief(BeliefDTO beliefDTO) {
        Belief belief = new Belief();

        return this.getBelief(beliefDTO, belief);
    }

    protected Belief transferBeliefDtoToBelief(BeliefDTO beliefDTO, Belief belief) {
        return this.getBelief(beliefDTO, belief);
    }

    private Belief getBelief(BeliefDTO beliefDTO, Belief belief) {
        BeliefDTOChecker.beliefDTOChecker(beliefDTO);

        var user = this.getUser(beliefDTO.userId());

        belief.setUser(user);
        belief.setDescription(beliefDTO.description());

        return belief;
    }

    private User getUser(Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new DatabaseException("User not found", 404));
    }
}
