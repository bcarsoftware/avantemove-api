package com.bcarsoftware.avantemove_api.repositories;

import com.bcarsoftware.avantemove_api.models.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {
    public abstract AccessToken findFirstByToken(String token);
    public abstract AccessToken findFirstByUsername(String username);

    @Modifying
    @Query("update AccessToken as at set at.token='' where at.token=:token")
    public abstract int deleteAccessTokenByToken(@Param("token") String token);

    @Modifying
    @Query("update AccessToken at set at.token='' where at.username=:username or at.username=:email")
    public abstract int deleteAccessTokenByUsernameOrEmail(
        @Param("username") String username,
        @Param("email") String email
    );
}
