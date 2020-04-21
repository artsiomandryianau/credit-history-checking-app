package com.wolknashatle.APIgateway.service;

import com.wolknashatle.APIgateway.model.LoanInfo;
import com.wolknashatle.APIgateway.model.reports.OverdueLoansReport;
import com.wolknashatle.APIgateway.model.reports.SingleClientReport;
import com.wolknashatle.APIgateway.model.reports.UnpaidLoansReport;
import com.wolknashatle.APIgateway.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintViolationException;
import java.util.Collections;


@Service
public class ConnectionService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private RestTemplate restTemplate;

    public OverdueLoansReport getOverdueReport() {
        //Getting data from client-data-service!!
        String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
        return restTemplate.getForObject(clientServiceUrl + "/getReport/overdueReport/", OverdueLoansReport.class);
    }

    public LoanInfo getLoanReport(String loanId) {
        try {
            //Getting data from client-data-service!!
            String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
            return restTemplate.getForObject(clientServiceUrl + "/getReport/loanReport/" + loanId, LoanInfo.class);
        } catch (RuntimeException re) {
            throw new ConstraintViolationException("error", Collections.emptySet());
        }
    }

    public SingleClientReport getSingleClientReport(String clientId) {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
        return restTemplate.getForObject(clientServiceUrl + "/getReport/clientsLoans/" + clientId, SingleClientReport.class);
    }

    public UnpaidLoansReport getUnpaidReport() {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
        return restTemplate.getForObject(clientServiceUrl + "/getReport/unpaid", UnpaidLoansReport.class);
    }
}
