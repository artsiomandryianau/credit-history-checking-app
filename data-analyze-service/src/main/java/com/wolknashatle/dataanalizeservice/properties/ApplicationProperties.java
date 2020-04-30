package com.wolknashatle.dataanalizeservice.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

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
