package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User as u where (u.email=:username or u.username=:username) and u.password=:password")
    public abstract User makeUserLogin(String username, String password);
    public abstract User updateUserPasswordByEmail(@Param("email") String email, @Param("password") String password);
}
