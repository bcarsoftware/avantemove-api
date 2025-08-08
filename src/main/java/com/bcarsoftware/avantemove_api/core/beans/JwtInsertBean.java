package com.bcarsoftware.avantemove_api.core.beans;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtInsertBean {
    @Bean
    public JwtInsert jwtInsert() {
        return new JwtInsert();
    }
}
