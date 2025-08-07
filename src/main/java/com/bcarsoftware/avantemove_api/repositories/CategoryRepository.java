package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public abstract Category findFirstByUserId(Long userId);

    public abstract Category findFirstById(Long id);
}
