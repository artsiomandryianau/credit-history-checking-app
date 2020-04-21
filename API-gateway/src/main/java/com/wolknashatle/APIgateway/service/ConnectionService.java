package com.wolknashatle.APIgateway.service;

import com.wolknashatle.APIgateway.config.DataServiceConnectionConfig;
import com.wolknashatle.APIgateway.model.ClientInfo;
import com.wolknashatle.APIgateway.model.LoanInfo;
import com.wolknashatle.APIgateway.model.reports.OverdueLoansReport;
import com.wolknashatle.APIgateway.model.reports.UnpaidLoansReport;
import com.wolknashatle.APIgateway.properties.ApplicationProperties;
import javafx.application.Application;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.wolknashatle.APIgateway.config.DataServiceConnectionConfig;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.logging.Logger;


@Service
@Log4j2
public class ConnectionService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(Application.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private RestTemplate restTemplate;

    public OverdueLoansReport getOverdueReport() {
        try {
            //Getting data from client-data-service!
            LOGGER.info("try to connect to data collection service");
            String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
            return restTemplate.getForObject(clientServiceUrl + "/getReport/overdueReport/", OverdueLoansReport.class);
        } catch (RuntimeException re) {
            LOGGER.info("wrong id error");
            throw new ConstraintViolationException("error", Collections.emptySet());

        }
    }

    public LoanInfo getLoanReport(String loanId) {
        try {
            //Getting data from client-data-service!!
            String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
            return restTemplate.getForObject(clientServiceUrl + "/getReport/loanReport/" + loanId, LoanInfo.class);
        } catch (RuntimeException re) {
            throw new RuntimeException("error", re);
        }
    }

    public ClientInfo getSingleClientReport(String clientId) {
        try {
            //Getting data from client-data-service

            String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
            ClientInfo clientInfo = restTemplate.getForObject(clientServiceUrl + "/getReport/clientsLoans/" + clientId, ClientInfo.class);
            if (clientInfo == null) { throw  new RuntimeException(); }
            else return clientInfo;
        } catch (RuntimeException re) {
            throw new RuntimeException("error", re);
        }
    }

    public UnpaidLoansReport getUnpaidReport() {
        try {
            //Getting data from client-data-service
            String clientServiceUrl = "http://" + applicationProperties.getDataCollectionServiceHost() + ":" + applicationProperties.getDataCollectionServicePort();
            return restTemplate.getForObject(clientServiceUrl + "/getReport/unpaid", UnpaidLoansReport.class);
        } catch (RuntimeException re) {
            throw new ConstraintViolationException("error", Collections.emptySet());
        }
    }
}
