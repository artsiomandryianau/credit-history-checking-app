package com.wolknashatle.APIgateway.service;


import com.wolknashatle.APIgateway.model.reports.XmlOverdueLoansReport;
import com.wolknashatle.APIgateway.model.reports.XmlSingleClientReport;
import com.wolknashatle.APIgateway.model.reports.XmlUnpaidLoansReport;
import com.wolknashatle.APIgateway.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConnectionService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private RestTemplate restTemplate;

    public XmlOverdueLoansReport getOverdueReport() {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
        return restTemplate.getForObject(clientServiceUrl + "/getReport/overdueReport/", XmlOverdueLoansReport.class);
    }

    public XmlSingleClientReport getSingleClientReport(String clientId) {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
        return restTemplate.getForObject(clientServiceUrl + "/getReport/clientsLoans/" + clientId, XmlSingleClientReport.class);
    }

    public XmlUnpaidLoansReport getUnpaidReport() {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
        return restTemplate.getForObject(clientServiceUrl + "/getReport/unpaid", XmlUnpaidLoansReport.class);
    }
}
