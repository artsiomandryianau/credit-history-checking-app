package com.wolknashatle.datacollectionservice.service;


import com.wolknashatle.datacollectionservice.model.*;
import com.wolknashatle.datacollectionservice.model.reports.LoansInfoReport;
import com.wolknashatle.datacollectionservice.model.reports.OverdueLoansReport;
import com.wolknashatle.datacollectionservice.model.reports.UnpaidLoansReport;
import com.wolknashatle.datacollectionservice.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ReportService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;


    public ClientInfo getClientLoansReport(String clientId) {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + clientId, Client.class);
        if(client == null) return null;
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/client/" + clientId, LoanList.class);
        //Saving data into one object
        return new ClientInfo(client, loanList);
    }

    public LoanInfo getLoanReport(String loanId) {
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        Loan loan = restTemplate.getForObject(loanServiceUrl +"/loans/loan/" + loanId, Loan.class);
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + loan.getClient_id(), Client.class);
        return new LoanInfo(client, loan);
    }


    public OverdueLoansReport getOverdueReport() {
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/overdue", LoanList.class);
        OverdueLoansReport report = new OverdueLoansReport(new ArrayList<>());
        for (Loan loan: loanList.getList()) {
            //Getting data from client-data-service
            Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + loan.getClient_id().toString(), Client.class);
            LoanInfo overdueLoanInfo = new LoanInfo(client, loan);
            report.getOverdueLoanInfos().add(overdueLoanInfo);
        }
        return report;
    }

    public UnpaidLoansReport getUnpaidReport() {
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/unpaid", LoanList.class);
        UnpaidLoansReport report = new UnpaidLoansReport(new ArrayList<>());
        for (Loan loan: loanList.getList()) {
            //Getting data from client-data-service
            Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + loan.getClient_id().toString(), Client.class);
            LoanInfo overdueLoanInfo = new LoanInfo(client, loan);
            report.getOverdueLoanInfos().add(overdueLoanInfo);
        }
        return report;
    }

    public LoansInfoReport getAllLoans () {
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        ClientList clientList = restTemplate.getForObject(clientServiceUrl + "/client/findAll", ClientList.class);
        //Getting data from loan-data-service,
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoansInfoReport report = new LoansInfoReport(new ArrayList<>());
        for (Client client: clientList.getClientList()) {
            //Getting data from client-data-service
            LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/client/" + client.getId(), LoanList.class);
            ClientInfo clientInfo = new ClientInfo(client, loanList);
            report.getClientInfos().add(clientInfo);
        }
        return report;
    }
}
