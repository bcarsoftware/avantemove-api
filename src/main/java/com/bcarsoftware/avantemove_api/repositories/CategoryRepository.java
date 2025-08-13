package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findFirstByUserId(Long userId);

    Category findFirstById(Long id);
}
