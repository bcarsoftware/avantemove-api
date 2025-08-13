package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User as u where (u.email=:username or u.username=:username) and u.password=:password")
    User makeUserLogin(
        @Param("username") String username,
        @Param("password") String password
    );

    User findUserById(Long id);

    User findUserByEmail(String email);

    User findFirstById(Long id);
}
