package com.wolknashatle.dataanalizeservice.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationProperties {


    @Bean
    public RestTemplate getRestTemplate () { return new RestTemplate();}

    @Value("${collection-data-service.host}")
    private String dataCollectionServiceHost;

    @Value("${collection-data-service.port}")
    private String dataCollectionServicePort;
    

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
