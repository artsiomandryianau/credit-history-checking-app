package com.wolknashatle.APIgateway.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationProperties {

    @Bean
    public RestTemplate getRestTemplate() { return new RestTemplate();}

    @Value("${client-data-micro-service.host}")
    private String dataCollectionServiceHost;

    @Value("${client-data-micro-service.port}")
    private String dataCollectionServicePort;

    @Value("${data-analyze-micro-service.host}")
    private String dataAnalyzeServiceHost;

    @Value("${data-analyze-micro-service.port}")
    private String dataAnalyzeServicePort;


    public String getDataAnalyzeServiceHost() {
        return dataAnalyzeServiceHost;
    }

    public void setDataAnalyzeServiceHost(String dataAnalyzeServiceHost) {
        this.dataAnalyzeServiceHost = dataAnalyzeServiceHost;
    }

    public String getDataAnalyzeServicePort() {
        return dataAnalyzeServicePort;
    }

    public void setDataAnalyzeServicePort(String dataAnalyzeServicePort) {
        this.dataAnalyzeServicePort = dataAnalyzeServicePort;
    }

    public String getDataCollectionServiceHost() {
        return dataCollectionServiceHost;
    }

    public void setDataCollectionServiceHost(String dataCollectionServiceHost) {
        this.dataCollectionServiceHost = dataCollectionServiceHost;
    }

    public String getDataCollectionServicePort() {
        return dataCollectionServicePort;
    }

    public void setDataCollectionServicePort(String dataCollectionServicePort) {
        this.dataCollectionServicePort = dataCollectionServicePort;
    }

}
