package com.wolknashatle.datacollectionservice.service;


import com.wolknashatle.datacollectionservice.model.*;
import com.wolknashatle.datacollectionservice.model.reports.XmlOverdueLoansReport;
import com.wolknashatle.datacollectionservice.model.reports.XmlSingleClientReport;
import com.wolknashatle.datacollectionservice.model.reports.XmlUnpaidLoansReport;
import com.wolknashatle.datacollectionservice.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;


    public XmlSingleClientReport getClientLoansReport(String clientId) {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + clientId, Client.class);
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/client/" + clientId, LoanList.class);
        //Saving data into one object
        ClientInfo clientInfo = new ClientInfo(client, loanList);
        XmlSingleClientReport xmlSingleClientReport = new XmlSingleClientReport();
        List<ClientInfo> clientInfoList = new ArrayList<>();
        clientInfoList.add(clientInfo);
        xmlSingleClientReport.setClientsInfo(clientInfoList);
        return xmlSingleClientReport;
    }

    public XmlSingleClientReport getLoanReport(String loanId) {
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + clientId, Client.class);
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/client/" + clientId, LoanList.class);
        //Saving data into one object
        ClientInfo clientInfo = new ClientInfo(client, loanList);
        XmlSingleClientReport xmlSingleClientReport = new XmlSingleClientReport();
        List<ClientInfo> clientInfoList = new ArrayList<>();
        clientInfoList.add(clientInfo);
        xmlSingleClientReport.setClientsInfo(clientInfoList);
        return xmlSingleClientReport;
    }


    public XmlOverdueLoansReport getOverdueReport() {
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/overdue", LoanList.class);
        XmlOverdueLoansReport report = new XmlOverdueLoansReport(new ArrayList<>());
        for (Loan loan: loanList.getList()) {
            //Getting data from client-data-service
            Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + loan.getClient_id().toString(), Client.class);
            OverdueLoanInfo overdueLoanInfo = new OverdueLoanInfo(loan, client);
            report.getOverdueLoanInfos().add(overdueLoanInfo);
        }
        return report;
    }

    public XmlUnpaidLoansReport getUnpaidReport() {
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/unpaid", LoanList.class);
        XmlUnpaidLoansReport report = new XmlUnpaidLoansReport(new ArrayList<>());
        for (Loan loan: loanList.getList()) {
            //Getting data from client-data-service
            Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + loan.getClient_id().toString(), Client.class);
            OverdueLoanInfo overdueLoanInfo = new OverdueLoanInfo(loan, client);
            report.getOverdueLoanInfos().add(overdueLoanInfo);
        }
        return report;
    }
}
