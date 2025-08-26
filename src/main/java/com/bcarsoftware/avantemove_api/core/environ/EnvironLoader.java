package com.bcarsoftware.avantemove_api.core.environ;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class EnvironLoader {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.jwt.secret}")
    private String secret;

    @Value("${spring.jwt.expiration}")
    private int expiration;

    @Value("${spring.jwt.algorithm}")
    private String algorithm;
}
