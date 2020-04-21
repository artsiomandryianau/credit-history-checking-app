package com.wolknashatle.APIgateway.config;

import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Configuration
public class DataServiceConnectionConfig {

    @Bean
    public RestTemplate getRestTemplate() { return new RestTemplate();}


}
