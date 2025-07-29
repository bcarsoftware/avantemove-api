package com.bcarsoftware.avantemove_api.core.beans;

import com.bcarsoftware.avantemove_api.core.responses.ErrorResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseBeans {
    @Bean
    public ErrorResponse errorResponse() {return new ErrorResponse();}
}
