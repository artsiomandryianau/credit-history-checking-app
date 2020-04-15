package com.wolknashatle.datacollectionservice.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${client-data-micro-service.host}")
    private String clientDataServicehost;

    @Value("${client-data-micro-service.port}")
    private String clientDataServicePort;

    @Value("${loan-data-micro-service.host}")
    private String loanDataServiceHost;

    @Value("${loan-data-micro-service.port}")
    private String loanDataServicePort;

    public String getClientDataServicehost() {
        return clientDataServicehost;
    }

    public void setClientDataServicehost(String clientDataServicehost) {
        this.clientDataServicehost = clientDataServicehost;
    }

    public String getClientDataServicePort() {
        return clientDataServicePort;
    }

    public void setClientDataServicePort(String clientDataServicePort) {
        this.clientDataServicePort = clientDataServicePort;
    }

    public String getLoanDataServiceHost() {
        return loanDataServiceHost;
    }

    public void setLoanDataServiceHost(String loanDataServiceHost) {
        this.loanDataServiceHost = loanDataServiceHost;
    }

    public String getLoanDataServicePort() {
        return loanDataServicePort;
    }

    public void setLoanDataServicePort(String loanDataServicePort) {
        this.loanDataServicePort = loanDataServicePort;
    }
}
